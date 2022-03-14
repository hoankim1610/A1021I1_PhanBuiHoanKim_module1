package mvc.model.repositoty;

import mvc.model.model.Student;

import java.util.Scanner;

public class StudentRepository implements IStudentRepository {
    private static Student[] students = new Student[20];

    static {
        students[0] = new Student(1, "HaiTT", "1998-01-01", 9);
        students[1] = new Student(2, "TrungDP", "1998-01-01", 9);
        students[2] = new Student(3, "TrungDC", "1998-01-01", 9);
    }

    @Override
    public Student[] getAll() {
        return students;
    }

    @Override
    public void add(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                break;
            }
        }
    }

    @Override
    public void delete() {
        Scanner scanner = new Scanner(System.in);
        int codeStudent = Integer.parseInt(scanner.nextLine());
        int count = search(students, codeStudent);
        int i = count;
        if (i != 1) {
            for (; i<students.length; i++) {
                if (students[i] == null) {
                    break;
                }
                students[i] = students[i + 1];
            }
            System.out.println(students[count].getNameStudent() + "is removed");
        }
    }

    @Override
    public void search() {

    }

    private int search(Student[] students, int codeStudent) {
        boolean check = false;
        int count = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                break;
            }
            if (students[i].getCodeStudent() == codeStudent) {
                check = true;
                count = i;
            }
        }

        if (!check) {
            System.out.println("Student is not found");
            return -1;
        }
        return count;
    }

}

