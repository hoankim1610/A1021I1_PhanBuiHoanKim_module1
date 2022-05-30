package com.codegym.repository.impl;

import com.codegym.model.Student;
import com.codegym.repository.IStudentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Repository
public class StudentRepository implements IStudentRepository {

    static Map<Integer, Student> studentMap;

    static {
        studentMap = new TreeMap<>();
        studentMap.put(235, new Student(235, "Nguyen Van A", "2000-05-03"));
        studentMap.put(743, new Student(743, "Nguyen Van B", "1999-03-02"));
        studentMap.put(124, new Student(124, "Le Van D", "2000-12-11"));
    }

    @Override
    public Student findById(Integer id) {
        return studentMap.get(id);
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(studentMap.values());
    }

    @Override
    public void save(Student studentObj) {
        int id = (int) (Math.random() * 100);
        studentObj.setId(id);

        studentMap.put(studentObj.getId(), studentObj);
    }
}
