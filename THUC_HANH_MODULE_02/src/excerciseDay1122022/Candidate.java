package excerciseDay1122022;

public class Candidate {
    private int codeStudent;
    private String name;
    private String DateOfBirth;
    private int Math = 0;
    private int Literature = 0;
    private int English = 0;

    public Candidate() {
    }

    public Candidate(int codeStudent, String name, String DateOfBirth, int Math, int Literature, int English) {
        this.codeStudent = codeStudent;
        this.name = name;
        this.DateOfBirth = DateOfBirth;
        this.Math = Math;
        this.Literature = Literature;
        this.English = English;
    }

    public int getCodeStudent() {
        return codeStudent;
    }

    public void setCodeStudent(int codeStudent) {
        this.codeStudent = codeStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public int getMath() {
        return Math;
    }

    public void setMath(int math) {
        Math = math;
    }

    public int getLiterature() {
        return Literature;
    }

    public void setLiterature(int literature) {
        Literature = literature;
    }

    public int getEnglish() {
        return English;
    }

    public void setEnglish(int english) {
        English = english;
    }

    public void Display() {
        System.out.println("StudentCode: ");
        System.out.println("Name: ");
        System.out.println("DateOfBirth: ");
        System.out.println("Math: ");
        System.out.println("Literature: ");
        System.out.println("English: ");
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "codeStudent=" + codeStudent +
                ", name='" + name + '\'' +
                ", DateOfBirth='" + DateOfBirth + '\'' +
                ", Math=" + Math +
                ", Literature=" + Literature +
                ", English=" + English +
                '}';
    }
}
