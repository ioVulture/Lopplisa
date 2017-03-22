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
    private SellersController sellers = new SellersController();
    
    public ProcessSaleController() throws IOException {
    
        sale = new Sale();
   
       }
    public void updateRow (Integer price, String code, Integer newPrice) {
        sale.updateSoldItem(price, code, newPrice);
    }
    public void makeNewSale(int total, long time, String purchaseType) throws IOException {
 
    
        String fileName =  total + "-" + time + "-purchases.txt";
        try(FileWriter fw = new FileWriter("purchases/" + fileName, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw))
        {
            out.print("{\"purchase\":[");
            int i = 0;
            for (SoldItem soldItem : sale.getList()) {
            
                if (i != 0) {
                    out.print(",");
                }
                out.print("{\"code\":\"" + soldItem.getCode() + "\",\"price\":" + soldItem.getPrice() + "}");
                i++;
            }
            out.print("]} , {\"purchaseType\":\"" + purchaseType + "\"}");
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
        sale.addSoldItem(price, code);
    }

    public Sale getSale() {
        return this.sale;
    }

}
