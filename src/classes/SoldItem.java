package classes;


public class SoldItem {
    private int price = 0;
    private String code = "";
    
    public SoldItem(int price, String code) {

        this.code = code;
        this.price = price;
    }
    
    public String getCode() {
        return code;
    }
    public int getPrice() {
       return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}
