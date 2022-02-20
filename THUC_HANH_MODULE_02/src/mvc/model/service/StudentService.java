package mvc.model.service;

import mvc.model.model.Student;
import mvc.model.repositoty.IStudentRepository;
import mvc.model.repositoty.StudentRepository;

import java.util.Scanner;

public class StudentService<students> implements IStudentService {
        private IStudentRepository iStudentRepository = new StudentRepository();
        Scanner scanner = new Scanner(System.in);

        @Override
        public void add() {
            System.out.println("input code");
            int code = Integer.parseInt(scanner.nextLine());
            System.out.println("input name");
            String name = scanner.nextLine();
            System.out.println("input day");
            String day = scanner.nextLine();
            System.out.println("input point");
            double point = Integer.parseInt(scanner.nextLine());

            Student student1 = new Student(code, name, day, point);
            iStudentRepository.add(student1);

            System.out.println("New list after adding");

            Student[] students = iStudentRepository.getAll();
            for (Student student: students) {
                if(student == null) {
                    break;
                }
                System.out.println(student);
            }
        }


        @Override
        public void delete() {
            System.out.println("Enter student's code need to be remove: ");
            Student[] students = iStudentRepository.getAll();
            iStudentRepository.delete();
            for (Student student : students) {
                if (student == null) {
                    break;
                }
                System.out.println(student);
            }
        }

        @Override
        public void display() {
            Student[] students = iStudentRepository.getAll();
            for (Student student: students) {
                if(student == null) {
                    break;
                }
                System.out.println(student);
            }
        }
}

