package com.example.customer.repository;

import com.example.customer.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    private final String SELECT_ALL = "select * from customer c join payment p on c.payment_id = p.id";
    private final String SELECT_BY_ID = "select * from customer c join payment p on c.payment_id = p.id where c.id = ?";
    private final String DELETE_BY_ID = "delete from customer where id = ?";
    private final String CREATE = "insert into customer (`name`, `phone`, `date`, `payment_id`) values(?,?,?,?)";
    private final String UPDATE = "update customer set `name`= ?, `phone`= ? , `date`= ?, `payment_id`= ? where id=?";

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydb","root","12345");
    }

    public List findAll() {
        List result = new ArrayList();

        try(PreparedStatement statement = getConnection().prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                result.add(getResultSet(resultSet));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    public Customer findById(int id){
        try(PreparedStatement statement = getConnection().prepareStatement(SELECT_BY_ID)){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                return getResultSet(resultSet);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public int save(Customer customer) {
        try( PreparedStatement statement = getConnection().prepareStatement(customer.getId() > 0 ? UPDATE : CREATE)){
            statement.setString(1, customer.getName());
            statement.setDouble(2, customer.getPhone());
            statement.setString(3, customer.getDate());
            statement.setInt(4, customer.getPaymentId());
            if(customer.getId() > 0){
                statement.setInt(5, customer.getId());
            }

            return statement.executeUpdate();
        }
        catch (Exception e) {
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

    private Customer getResultSet (ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        String name = resultSet.getString(2);
        int phone = resultSet.getInt(3);
        String date = resultSet.getString(4);
        String payment = resultSet.getString(5);
        int paymentId = resultSet.getInt(7);
        String paymentName = resultSet.getString(8);
        return new Customer(id,name, phone, date, payment, paymentId, paymentName);
    }
}
