package ss12_CollectionFrameWork.excercise.e1_usingArrayList_LinkedList.ProductManagement.model;

import ProductManagement.model.Product;

public class AuthenticProduct extends Product {
    private int exprired_period_year;

    public AuthenticProduct(int id, String name, double price, String manufacturer, int exprired_period_year) {
        super(id, name, price, manufacturer);
        this.exprired_period_year = exprired_period_year;
    }

    public int getExprired_period_year() {
        return exprired_period_year;
    }

    public void setExprired_period_year(int exprired_period_year) {
        this.exprired_period_year = exprired_period_year;
    }

    public String showInfo() {
        return "Authentic Product{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", manufacturer='" + getManufacturer() + '\'' +
                ", expired period='" + exprired_period_year + '\'' +
                '}';
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s",getId(), getName(), getPrice(), getManufacturer(), exprired_period_year);
    }
}
