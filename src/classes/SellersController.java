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
import java.util.Date;
import java.util.HashMap;
import java.util.TreeMap;

/**
 *
 * @author Rasmus_jobb
 */
public class SellersController {

    PropertiesHandler propertiesHandler = new PropertiesHandler();

    public TreeMap<String, Integer> getSellers() throws FileNotFoundException, IOException {
        new FileOutputStream("sellers.txt", true).close();
        Scanner scanner = new Scanner(new File("sellers.txt"));
        TreeMap<String, Integer> sellerMap = new TreeMap<>();
        if (scanner != null && scanner.hasNext()) {
            String text = scanner.next();

            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readValue(text, JsonNode.class);
            JsonNode brandNode = node.get("sellers");

            final JsonNode arrNode = new ObjectMapper().readTree(text).get("sellers");
            if (arrNode.isArray()) {
                for (final JsonNode objNode : arrNode) {
                    String code = objNode.get("code").getTextValue();
                    Integer total = objNode.get("total").getIntValue();
                    sellerMap.put(code, 0);
                }
            }
        }
        return sellerMap;
    }

    public void populateSellers() throws MalformedURLException, IOException {

        String urlProperty = propertiesHandler.getPropertyValue("remote.server.sellers.url");
        String passwordProperty = propertiesHandler.getPropertyValue("remote.server.password");
        String url = urlProperty + passwordProperty;
        URL sellerUrl = new URL(url);
        
        BufferedReader in = new BufferedReader(
                new InputStreamReader(sellerUrl.openStream()));
        String sellerString = in.readLine();
        String[] sellerCodeList = sellerString.split(",");
        
        try (FileWriter fw = new FileWriter("sellers.txt", false);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
            out.print("{\"sellers\":[");
            int i = 0;
            for (String code : sellerCodeList) {
                if (i != 0) {
                    out.print(",");
                }
                out.print("{\"code\":\"" + code + "\",\"total\":0}");

                i++;

            }
            out.print("]}");
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }

}
