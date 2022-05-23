package cg.test.repository;

import cg.test.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private final String SELECT_ALL = "select * from product p join category c on p.category_id = c.id";
    private final String INSERT = "INSERT INTO product (`name`, `price`, `quantity`, `color`, `description`, `category_id`) VALUES (?, ?, ?, ?, ?, ?)";
    private final String UPDATE = "update product set `name`=?, `price`=?, `quantity`=?, `color`=?, description=?, category_id=? where id= ?";
    private final String SELECT_BY_ID = "select * from product p join category c on p.category_id = c.id where p.id =?";
    private final String DELETE_BY_ID = "delete from product where id = ?";

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test",
                "root", "40forever");
    }

    public List findAll(){
        List result = new ArrayList();

        try(PreparedStatement statement = getConnection().prepareStatement(SELECT_ALL)){
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                result.add(getResultSet(resultSet));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public Product findById(int id){
        try(PreparedStatement statement = getConnection().prepareStatement(SELECT_BY_ID)){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
               return getResultSet(resultSet);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public int save(Product product){
        try(PreparedStatement statement = getConnection().prepareStatement(product.getId() > 0 ? UPDATE :INSERT)){
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setString(4, product.getColor());
            statement.setString(5, product.getDescription());
            statement.setInt(6, product.getCategoryId());

            if(product.getId() >0){
                statement.setInt(7, product.getId());
            }

            return statement.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return 0;
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

    private Product getResultSet(ResultSet resultSet){
        try{
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            Double price = resultSet.getDouble(3);
            int quantity = resultSet.getInt(4);
            String color = resultSet.getString(5);
            int categoryId = resultSet.getInt(8);
            String categoryName = resultSet.getString(9);
            return new Product(id, name, price, quantity, color, "", categoryId, categoryName);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
