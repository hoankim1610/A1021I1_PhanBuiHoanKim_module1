package ProductManagement.model;

public class HandProduct extends Product {
    private String country;
    private String status;

    public HandProduct(int id, String name, double price, String manufacturer, String country, String status) {
        super(id, name, price, manufacturer);
        this.country = country;
        this.status = status;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String showInfo() {
        return "Hand Product{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", manufacturer='" + getManufacturer() + '\'' +
                ", country='" + country + '\'' +
                ", status='" + status + '\'' +
                '}';
    }


    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s",getId(), getName(), getPrice(), getManufacturer(), country, status);
    }
}
