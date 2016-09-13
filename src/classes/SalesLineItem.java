package classes;


public class SalesLineItem {
    private int price = 0;
    private String code = "";
    
    public SalesLineItem(int price, String code) {

        this.code = code;
        this.price = price;
    }
    
    public String getCode() {
        return code;
    }
    public int getPrice() {
       return price;
    }
}
