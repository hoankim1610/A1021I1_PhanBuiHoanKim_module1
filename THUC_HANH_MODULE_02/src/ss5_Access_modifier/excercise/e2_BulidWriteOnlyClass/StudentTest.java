package ss5_Access_modifier.excercise.e2_BulidWriteOnlyClass;

public class StudentTest {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.setClasses("C04"));
        System.out.println(student.setName("Ali"));
    }
}
