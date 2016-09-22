/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import java.lang.String;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
/**
 *
 * @author Rasmus_jobb
 */
public class Sellers {
  PropertiesHandler propertiesHandler = new PropertiesHandler();
 public Map<String, Integer> getSellers () throws FileNotFoundException, IOException{
    new FileOutputStream("sellers.txt", true).close();
    Scanner scanner = new Scanner( new File("sellers.txt") );
    System.out.println(scanner);
    System.out.println(scanner.hasNext());
     Map <String, Integer> sellerMap = new HashMap<>();
    if (scanner != null && scanner.hasNext()) {
        String text = scanner.next();

        ObjectMapper mapper = new ObjectMapper();

        JsonNode node = mapper.readValue(text, JsonNode.class);

        JsonNode brandNode = node.get("sellers");

         //System.out.println("brandNode.isArray():" + brandNode.isArray());
        
         final JsonNode arrNode = new ObjectMapper().readTree(text).get("sellers");
            if (arrNode.isArray()) {
                for (final JsonNode objNode : arrNode) {
                    String code = objNode.get("code").getTextValue();
                    Integer total = objNode.get("total").getIntValue();
                    sellerMap.put(code, total);
                }
            }
    }
        return sellerMap;
 }
 
    public void populateSellers() throws MalformedURLException, IOException {
        String sellerCodes = "C02,M103,X18,C01,B12,M110,L03,X110";
        String urlProperty = propertiesHandler.getPropertyValue("remote.server.sellers.url");
        System.out.println("url was:" + urlProperty);
        String passwordProperty = propertiesHandler.getPropertyValue("remote.server.password");
        String url = urlProperty + passwordProperty;
        System.out.println("url was:" + url);
        URL sellerUrl = new URL(url);
        BufferedReader in = new BufferedReader(
        new InputStreamReader(sellerUrl.openStream()));
        String sellerString = in.readLine();
        System.out.println(sellerString);
        String[] sellerCodeList = sellerString.split(",");
        
        try(FileWriter fw = new FileWriter("sellers.txt", false);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw))
        {
            out.print("{\"sellers\":[");
            int i = 0;
            for (String code: sellerCodeList) {
                System.out.println("status:" + sellerCodeList.length);
                if (i != 0) {
                    out.print(",");
                }
                out.print("{\"code\":\"" + code + "\",\"total\":0}\n");
                
                i++;
                
            }
            out.print("]}");
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }
 
}
