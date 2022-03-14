package Phone.model;

public class HandPhone extends  Phone {
    private String status;

    public HandPhone(int id, String name, double price, String status) {
        super(id, name, price);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String showInfo() {
        return "HandPhone {" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() + '\'' +
                "status='" + status + '\'' +
                '}';
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s, ", getId(), getName(), getPrice(), status);
    }
}
