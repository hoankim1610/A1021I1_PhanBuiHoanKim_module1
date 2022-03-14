package mvc.model.repositoty;

import mvc.model.model.Student;

public interface IStudentRepository {
    Student[] getAll();
    void add(Student student);
    void delete();
    void search();
}

