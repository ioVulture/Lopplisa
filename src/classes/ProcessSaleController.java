package classes;

import frontend.SaleJFrame;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ProcessSaleController {

    private Sale sale;
    private Map<String, Integer> sellersMap = new HashMap<>();
    private Sellers sellers = new Sellers();
    
    public ProcessSaleController() {
        System.out.println("1111");
        sale = new Sale();
   
       }

    public void makeNewSale() throws IOException {
 
        Date time = new Date();
        String fileName =  time.getTime() + "-purchases.txt";
        try(FileWriter fw = new FileWriter(fileName, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw))
        {
            out.print("{\"purchase\":[");
            for (SalesLineItem soldItem: sale.getList()) {
                out.print("{\"code:\"" + soldItem.getCode() + ",\"price:\"" + soldItem.getPrice() + "}");
            }
            out.print("]}");
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }


        
        sale.resetSale();
    }
    
    public Map<String, Integer> getSellers () throws IOException {
       
       return sellers.getSellers();
   
     
    }
    public boolean codeExist(String code) throws IOException {
        return getSellers().containsKey(code);
    }
    
    public void addItem(int price, String code) throws FileNotFoundException, IOException {
        sale.addSaleLineItem(price, code);
    }

    public Sale getSale() {
        return this.sale;
    }

}
