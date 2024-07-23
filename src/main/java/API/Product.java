package API;
public class Product {

    private Integer id;
    private String title;
    private Double price;
    private String description;
    private String category;

    public Product() {

    }
    public Product(Integer id, String title, Double price, String description, String category) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.category = category;
    }
}
