package ExamModule2.model;

public class ExportProduct extends Product {
    private double exportPrice;
    private String exportCountry;

    public ExportProduct(int id, int code, String name, double price, int amount, String manufacturer, double exportPrice, String exportCountry) {
        super(id, code, name, price, amount, manufacturer);
        this.exportPrice = exportPrice;
        this.exportCountry = exportCountry;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getExportCountry() {
        return exportCountry;
    }

    public void setExportCountry(String exportCountry) {
        this.exportCountry = exportCountry;
    }

    public String showInfo() {
        return "Export Product {" +
                ", id=" + getId() +
                ", code=" + getCode() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() + '\'' +
                ", amount=" + getAmount() + '\'' +
                ", manufacturer=" + getManufacturer() + '\'' +
                "export price='" + exportPrice + '\'' +
                "export country='" + exportCountry + '\'' +
                '}';
    }

    public String toString() {
        return String.format("%s, %s, %s, %s, %s, %s, %s, %s, ", getId(), getCode(), getName(), getPrice(), getAmount(), getManufacturer(), exportPrice, exportCountry);
    }
}

