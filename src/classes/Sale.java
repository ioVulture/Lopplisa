package classes;

import frontend.SaleJFrame;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class Sale {

    private LinkedList<SoldItem> sli;
    
    private Map<String, Integer> sellersMap = new HashMap<>();
    private SellersController sellers = new SellersController();
  
    public Sale() throws IOException {
        this.sellersMap = sellers.getSellers();
        this.sli = new LinkedList<SoldItem>();
        
    }

    public void addSoldItem(int price, String code) throws FileNotFoundException, IOException {
       /* 
       for (Map.Entry<String, Integer> entry : sellersMap.entrySet())
        {
            
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
       System.out.println("ContainsKey:" + sellersMap.containsKey(code));
               */
       if (codeMatchSellers(code.toUpperCase())) {
            sli.add(new SoldItem(price, code.toUpperCase()));
       } else {
            
            SaleJFrame sjf = new SaleJFrame();
            sjf.setErrorLabelText("Säljarkoden finns inte");
            
       }
    }
    public boolean codeMatchSellers (String code) throws IOException {
        if (sellersMap.containsKey(code.toUpperCase())) {
            return true;
        } else {
            return false;
        }
    }
    public LinkedList<SoldItem> getList() {
        return this.sli;
    }

    public int getListLength() {
        return this.sli.size();
    }

    public int getTotal() {
        double total = 0.0;
        for (Iterator<SoldItem> it = sli.iterator(); it.hasNext();) {
            SoldItem sli1 = it.next();
            total += sli1.getPrice();
        }
        return (int) Math.round(total);
    }

    public boolean resetSale() {
      
        return sli.removeAll(sli);
    }
}
