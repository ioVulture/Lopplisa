package classes;

public class ProductSpecification {

    private int id;
    private String name;
    private String description;
    private double price;

    public ProductSpecification(int id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public ProductSpecification(int id) {
        this.id = id;
        this.name = "";
        this.description = "";
        this.price = 0.0;
    }

    public ProductSpecification() {
    }

    public double getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public double getPrice() {
        return this.price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
