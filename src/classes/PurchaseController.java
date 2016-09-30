/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import jdk.nashorn.internal.ir.ObjectNode;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author Roulf
 */
public class PurchaseController {

    private final String USER_AGENT = "Mozilla/5.0";
    PropertiesHandler propertiesHandler = new PropertiesHandler();

    public TreeMap<Long, Integer> getAllPurchasesMap() {
        ArrayList<String> results = new ArrayList<String>();
        TreeMap<Long, Integer> resultMap = new TreeMap<Long, Integer>();

        File[] files = new File("purchases").listFiles();

        String[] fileNameList;
        long key = -1;
        Integer total = -1;
        for (File file : files) {
            if (file.isFile() && !file.getName().startsWith("0-")) {

                results.add(file.getName());
                fileNameList = file.getName().split("-");
                key = Long.parseLong(fileNameList[1]);
                total = Integer.parseInt(fileNameList[0]);
                resultMap.put(key, total);

            }
        }

        return resultMap;
    }

    public boolean editPreviousPurchase(Long id, Integer total) {

        return false;
    }

    public boolean deletePurchase(Long id, Integer total) throws IOException {
       // System.out.println("delteing:" + id + "total:" + total);
        String fileName = total + "-" + id + "-purchases.txt";
        String deletedFileName = "0-" + id + "-purchases.txt";

        File file = new File("purchases/" + fileName);
        //System.out.println("file to delete:" + file.getName());
        File deletedFile = new File("purchases/" + deletedFileName);
        //System.out.println("deletedFile:" + deletedFile.getName());
        if (file.renameTo(deletedFile)) {

            System.out.println("File renamed");
        } else {
            System.out.println("Sorry! the file can't be renamed forid:" + id + " total:" + total);
        }
        return true;
    }

    public boolean sendPurchasesToServer() throws FileNotFoundException, IOException {

        Map<String, Integer> sellerTotals = getSellersTotals();

        StringBuilder sb = new StringBuilder();
        sb.append("sellerTotals=");
        for (Map.Entry sellerTotal : sellerTotals.entrySet()) {
            sb.append(sellerTotal.getKey() + ":" + sellerTotal.getValue() + ",");
        }

        String urlString = propertiesHandler.getPropertyValue("remote.server.purchases.url") + propertiesHandler.getPropertyValue("remote.server.password");

        URL url = new URL(urlString);

        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        con.setDoOutput(true);
        con.getOutputStream().write(sb.toString().getBytes("UTF-8"));
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(sb.toString());
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return false;
    }

    private TreeMap<String, Integer> getSellersTotals() throws FileNotFoundException, IOException {

        File[] files = new File("purchases").listFiles();

        SellersController sellers = new SellersController();
        TreeMap<String, Integer> sellersMap = sellers.getSellers();
        
        for (File file : files) {

            if (file.isFile() && !file.getName().startsWith("0-")) {

                Scanner scanner = new Scanner(new File(file.getAbsolutePath()));
                String text = scanner.next();

                final JsonNode arrNode = new ObjectMapper().readTree(text).get("purchase");

                if (arrNode.isArray()) {
                    for (final JsonNode objNode : arrNode) {
                        String code = objNode.get("code").getTextValue();
                        Integer total = objNode.get("price").getIntValue();
                         
                        Integer currentTotal = sellersMap.get(code);
                        sellersMap.remove(code);

                        currentTotal = currentTotal + total;
                        System.out.println("code:" + code);
                        System.out.println("cuurentprice:" + currentTotal);
                        System.out.println("price:" + currentTotal);
                        sellersMap.put(code, currentTotal);

                    }
                }
                
                scanner.close();
            }
        }

        return sellersMap;
    }

    public void addPurchaseToTotals() throws FileNotFoundException, IOException {
      
        StringBuilder sb = new StringBuilder();

        sb.append("{\"sellers\":[");
        int i = 0;
        for (Entry<String, Integer> entrySet : getSellersTotals().entrySet()) {
            if (entrySet.getValue() != 0) {
                System.out.println("entrySet.getKey():" + entrySet.getKey());
                System.out.println("entrySet.getValue():" + entrySet.getValue());
            }
            if (i != 0) {
                sb.append(",");
            }
            sb.append("{\"code\":\"" + entrySet.getKey() + "\",\"total\":" + entrySet.getValue() + "}");

            i++;

        }
        sb.append("]}");
        System.out.println("sb was:" + sb.toString());
        PrintWriter pw = new PrintWriter("sellers.txt");
        pw.close();
        try(FileWriter fw = new FileWriter("sellers.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw))
        {
            out.print(sb);
            
        } catch (IOException e) {
            System.out.println("could not print totals");//exception handling left as an exercise for the reader
        }
    }
}
