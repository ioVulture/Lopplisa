/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Roulf
 */
public class PurchaseController {

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
                System.out.println("Purchases:" + fileNameList[0]);

            }
        }
        return resultMap;
    }
    public boolean deletePurchase(Long id, Integer total) throws IOException {
        System.out.println("Incoming vals:" + id + " and  " + total);
        String fileName = total + "-" + id + "-purchases.txt";
        String deletedFileName = "0-" + id + "-purchases.txt";
        
        File file = new File("purchases/" + fileName);
         System.out.println("Incoming vals:" + file.getPath());
        File deletedFile = new File("purchases/" + deletedFileName);
        if(file.renameTo(deletedFile)){
            System.out.println("File renamed");
        }else{
            System.out.println("Sorry! the file can't be renamed");
        }
        return true;
    }
}
