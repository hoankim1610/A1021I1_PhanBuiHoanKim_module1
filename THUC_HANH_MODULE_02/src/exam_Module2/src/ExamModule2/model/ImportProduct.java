package ExamModule2.model;

public class ImportProduct extends Product {
    private double importPrice;
    private String importPlace;
    private int importDuty;

    public ImportProduct(int id, int code, String name, double price, int amount, String manufacturer, double importPrice, String importPlace, int importDuty) {
        super(id, code, name, price, amount, manufacturer);
        this.importPrice = importPrice;
        this.importPlace = importPlace;
        this.importDuty = importDuty;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public String getImportPlace() {
        return importPlace;
    }

    public void setImportPlace(String importPlace) {
        this.importPlace = importPlace;
    }

    public int getImportDuty() {
        return importDuty;
    }

    public void setImportDuty(int importDuty) {
        this.importDuty = importDuty;
    }

    public String showInfo() {
        return "Import Product {" +
                "id=" + getId() +
                ", code=" + getCode() +
                ", name ='" + getName() + '\'' +
                ", price=" + getPrice() + '\'' +
                ", amount=" + getAmount() + '\'' +
                ", manufacturer=" + getManufacturer() + '\'' +
                ", import price='" + importPrice + '\'' +
                ", import place='" + importPlace + '\'' +
                ", import duty='" + importDuty + '\'' +
                '}';
    }

    public String toString() {
        return String.format("%s, %s, %s, %s, %s, %s, %s, %s, ", getId(), getCode(), getName(), getPrice(), getAmount(), getManufacturer(), importPrice, importPlace, importDuty);
    }

}
