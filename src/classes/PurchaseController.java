/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.List;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Roulf
 */
public class PurchaseController {
    public TreeMap <Long, Integer> getAllPurchasesMap() {
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
            System.out.println("Purchases:" + fileNameList[0]);
            
        }
    }
    return resultMap;
    }
    
}
