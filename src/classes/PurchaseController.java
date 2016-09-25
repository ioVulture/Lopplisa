/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.List;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
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
        
        String fileName = total + "-" + id + "-purchases.txt";
        String deletedFileName = "0-" + id + "-purchases.txt";

        File file = new File("purchases/" + fileName);

        File deletedFile = new File("purchases/" + deletedFileName);
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
                        /*
                        if (objNode.get("price").getIntValue() != 0) {
                            
                          
                        } */
                        
                         //System.out.println("price:" + objNode.get("price").getIntValue());
                           currentTotal = currentTotal + total;
                        sellersMap.put(code, currentTotal);

                    }
                }
            }
        }
        return sellersMap;
    }
}
