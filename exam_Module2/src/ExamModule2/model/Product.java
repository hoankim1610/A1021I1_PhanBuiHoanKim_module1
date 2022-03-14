package ExamModule2.model;

public abstract class Product {
    private int id;
    private int code;
    private String name;
    private double price;
    private int amount;
    private String manufacturer;

    public Product(int id, int code, String name, double price, int amount, String manufacturer) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.manufacturer = manufacturer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
