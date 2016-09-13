package classes;

import frontend.SaleJFrame;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class Sale {

    private LinkedList<SalesLineItem> sli;
    
    private Map<String, Integer> sellersMap = new HashMap<>();
    private Sellers sellers = new Sellers();
  
    public Sale() {
         
        this.sli = new LinkedList<SalesLineItem>();
        
    }

    public void addSaleLineItem(int price, String code) throws FileNotFoundException, IOException {
       this.sellersMap = sellers.getSellers();
   
       this.sellersMap =  sellersMap;
        
       for (Map.Entry<String, Integer> entry : sellersMap.entrySet())
        {
            
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
       System.out.println("ContainsKey:" + sellersMap.containsKey(code));
       if (sellersMap.containsKey(code.toUpperCase())) {
        sli.add(new SalesLineItem(price, code.toUpperCase()));
       } else {
            
            SaleJFrame sjf = new SaleJFrame();
            sjf.setErrorLabelText("Säljarkoden finns inte");
            
       }
    }

    public LinkedList<SalesLineItem> getList() {
        return this.sli;
    }

    public int getListLength() {
        return this.sli.size();
    }

    public int getTotal() {
        double total = 0.0;
        for (Iterator<SalesLineItem> it = sli.iterator(); it.hasNext();) {
            SalesLineItem sli1 = it.next();
            total += sli1.getPrice();
        }
        return (int) Math.round(total);
    }

    public boolean resetSale() {
      
        return sli.removeAll(sli);
    }
}
