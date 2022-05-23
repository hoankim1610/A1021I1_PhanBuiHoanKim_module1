package service;

import model.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class StudentServiceImpl implements StudentService {
    private static Map<String, Student> studentMap;

    static {
        studentMap = new HashMap<>();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            studentMap.put("SV001", new Student("SV001", "Lan",
                    format.parse("10/02/1999"), false));
            studentMap.put("SV002", new Student("SV002", "Tuấn",
                    format.parse("10/04/1998"), true));
            studentMap.put("SV003", new Student("SV003", "Hùng",
                    format.parse("10/02/2000"), true));
            studentMap.put("SV004", new Student("SV004", "Hiếu",
                    format.parse("17/02/1999"), true));
            studentMap.put("SV005", new Student("SV005", "Ha",
                    format.parse("10/02/1999"), false));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void create(Student student) {
        if (!studentMap.containsKey(student.getId())) {
            studentMap.put(student.getId(), student);
        }
    }

    @Override
    public void update(Student student) {
        if (studentMap.containsKey(student.getId())) {
            studentMap.put(student.getId(), student);
        }
    }

    @Override
    public void delete(String id) {
        if (studentMap.containsKey(id)) {
            studentMap.remove(id);
        }
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(studentMap.values());
    }

    @Override
    public Student findById(String id) {
        if (studentMap.containsKey(id)) {
            return studentMap.get(id);
        } else {
            return null;
        }
    }
}
