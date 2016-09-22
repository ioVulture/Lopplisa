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
        //If this pathname does not denote a directory, then listFiles() returns null. 
        String[] fileNameList;
        long key = -1;
        Integer total = -1;
        for (File file : files) {
            if (file.isFile()) {

                results.add(file.getName());
                fileNameList = file.getName().split("-");
                key = Long.parseLong(fileNameList[1]);
                total = Integer.parseInt(fileNameList[0]);
                resultMap.put(key, total);
          
            }
        }
        return resultMap;
    }

    public boolean deletePurchase(Long id, Integer total) throws IOException {

        String fileName = total + "-" + id + "-purchases.txt";
        String deletedFileName = "0-" + id + "-purchases.txt";

        File file = new File("purchases/" + fileName);

        File deletedFile = new File("purchases/" + deletedFileName);
        if (file.renameTo(deletedFile)) {
            System.out.println("File renamed");
        } else {
            System.out.println("Sorry! the file can't be renamed");
        }
        return true;
    }

    public boolean sendPurchasesToServer() throws FileNotFoundException, IOException {

        Map<String, Integer> sellerTotals = getSellersTotals();
        String postData = "postData=test";
        for (Map.Entry sellerTotal : sellerTotals.entrySet()) {
            postData = postData.concat("code:" + sellerTotal.getKey() + "-Total:" + sellerTotal.getValue() + ",");
            //System.out.println("code:" + sellerTotal.getKey() +  " ---- total:" + sellerTotal.getValue());
        }
        byte[] postDataBytes = postData.getBytes("UTF-8");
        String urlString = propertiesHandler.getPropertyValue("remote.server.purchases.url") + propertiesHandler.getPropertyValue("remote.server.password");
        
        URL url = new URL(urlString);

        HttpURLConnection con = (HttpURLConnection) url.openConnection();

       // System.out.println(postData);
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        con.setDoOutput(true);
        con.getOutputStream().write(postData.getBytes("UTF-8"));
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(postData);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
       // System.out.println("\nSending 'POST' request to URL : " + url);
        //System.out.println("Post parameters : " + postData);
        //System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

        return false;
    }

    private TreeMap<String, Integer> getSellersTotals() throws FileNotFoundException, IOException {

        File[] files = new File("purchases").listFiles();

        SellersController sellers = new SellersController();
        TreeMap<String, Integer> sellersMap = sellers.getSellers();

        for (File file : files) {
             System.out.println("fileName:" + file.getName());
            if (file.isFile() && !file.getName().contains("0-")) {
                
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
                         System.out.println("price:" + objNode.get("price").getIntValue());
                           currentTotal = currentTotal + total;
                        sellersMap.put(code, currentTotal);

                    }
                }
            }
        }
        return sellersMap;
    }
}
