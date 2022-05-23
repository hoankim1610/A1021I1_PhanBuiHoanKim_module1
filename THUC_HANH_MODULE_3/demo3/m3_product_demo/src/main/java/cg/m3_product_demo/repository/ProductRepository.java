package cg.m3_product_demo.repository;

import cg.m3_product_demo.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private final String SELECT_ALL = "select * from product p join category c on p.category_id = c.id";
    private final String SELECT_BY_ID = "select * from product p join category c on p.category_id = c.id where p.id = ?";
    private final String DELETE_BY_ID = "delete from product where id = ?";
    private final String CREATE = "insert into product (`name`, `price`, `quantity`, `color`, `description`, `category_id`) values(?,?,?,?,?,?)";
    private final String UPDATE = "update product set `name`= ?, `price`= ? , `quantity`= ?, `color`= ?, `description`= ?, `category_id`=? where id=?";

    private Connection getConnection() throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/m3_product", "root", "40forever");
    }

    public int save(Product product) {
        try( PreparedStatement statement = getConnection().prepareStatement(product.getId() > 0 ? UPDATE : CREATE)){
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setString(4, product.getColor());
            statement.setString(5, product.getDescription());
            statement.setInt(6, product.getCategoryId());
            if(product.getId() > 0){
                statement.setInt(7, product.getId());
            }

            return statement.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public List findAll() {
        List result = new ArrayList();

        try(  PreparedStatement statement = getConnection().prepareStatement(SELECT_ALL)) {
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                result.add(getProduct(rs));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    public Product findById(int id){
        try(PreparedStatement statement = getConnection().prepareStatement(SELECT_BY_ID)){
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                return getProduct(rs);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public int delete(int id) {
        try(PreparedStatement statement = getConnection().prepareStatement(DELETE_BY_ID)) {
            statement.setInt(1, id);
            return statement.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public List searchByName(String name) {
        return null;
    }

    private Product getProduct(ResultSet rs) throws SQLException {
        int id = rs.getInt(1);
        String name = rs.getString(2);
        Double price = rs.getDouble(3);
        int quantity = rs.getInt(4);
        String color = rs.getString(5);
        String description = rs.getString(6);
        int categoryId= rs.getInt(7);
        String categoryName = rs.getString(9);
        return new Product(id, name, price, quantity, color, description, categoryId, categoryName);
    }
}
