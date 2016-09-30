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
         System.out.println("addSoldItemCalled");
        if (codeMatchSellers(code.toUpperCase())) {
            sli.add(new SoldItem(price, code.toUpperCase()));
        } else {

            SaleJFrame sjf = new SaleJFrame();
            sjf.setErrorLabelText("Säljarkoden finns inte");

        }
    }

    public void updateSoldItem(int price, String code, Integer newPrice) {
        int i = 0;
      //  System.out.println("price:" + price +"______code" + code);
        for (Iterator<SoldItem> it = sli.iterator(); it.hasNext();) {

            SoldItem sli1 = it.next();
//.out.println(sli1.getCode() +"::::::::."+ sli1.getPrice());
            if (sli1.getCode().equalsIgnoreCase(code) && sli1.getPrice() == price) {
          
                sli1.setPrice(newPrice);
                sli.set(i, sli1);
                //System.out.println(sli1.getCode() +"::::::::."+ sli1.getPrice());
                break;
            }
            i++;

        }

    }

    public boolean codeMatchSellers(String code) throws IOException {
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
            //System.out.println("Ssli1.getPrice():" + sli1.getPrice());
        }
        //System.out.println("total in grand total:" + total);
        return (int) Math.round(total);
    }

    public boolean resetSale() {

        return sli.removeAll(sli);
    }
}
