package repository;

import model.Student;
import util.ConnectDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    private static final String GET_ALL_STUDENT = "Select * from student";
    @Override
    public void create(Student student) {

    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<Student> findAll() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Student> students = new ArrayList<>();
        try {
            connection = ConnectDB.getConnection();
            statement = connection.createStatement();
            statement.executeQuery(GET_ALL_STUDENT);
            while (resultSet.next()) {
                String id = resultSet.getNString("id");
                String name = resultSet.getNString("name");
                Date birthday = new Date(resultSet.getDate("birthday").getTime());
                boolean sex = resultSet.getBoolean("sex");
                students.add(new Student(id, name, birthday, sex));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Student findById(String id) {
        return null;
    }
}
