package Phone.model;

public class AuthenticPhone extends Phone {
    private int warantyByYear;

    public AuthenticPhone(int id, String name, double price, int warantyByYear) {
        super(id, name, price);
        this.warantyByYear = warantyByYear;
    }

    public int getWarantyByYear() {
        return warantyByYear;
    }

    public void setWarantyByYear(int warantyByYear) {
        this.warantyByYear = warantyByYear;
    }

    public String showInfo() {
        return "AuthenticPhone e{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() + '\'' +
                "waranty ='" + warantyByYear + '\'' +
                '}';
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s, ", getId(), getName(), getPrice(), warantyByYear);
    }
}
