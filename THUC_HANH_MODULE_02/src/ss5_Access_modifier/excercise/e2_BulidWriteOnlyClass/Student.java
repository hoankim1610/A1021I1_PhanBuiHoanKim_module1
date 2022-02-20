package ss5_Access_modifier.excercise.e2_BulidWriteOnlyClass;

public class Student {
    private String name = "John";
    private String classes = "C02";

    public Student() {
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public String setClasses(String classes) {
        this.classes = classes;
        return classes;
    }

}
