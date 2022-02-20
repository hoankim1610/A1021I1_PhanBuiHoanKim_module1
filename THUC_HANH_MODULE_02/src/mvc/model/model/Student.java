package mvc.model.model;

public class Student {
        private int codeStudent;
        private String nameStudent;
        private String dateOfBirth;
        private double point;

        public Student() {
        }

        public Student(int codeStudent, String nameStudent, String dateOfBirth, double point) {
            this.codeStudent = codeStudent;
            this.nameStudent = nameStudent;
            this.dateOfBirth = dateOfBirth;
            this.point = point;
        }

        public int getCodeStudent() {
            return codeStudent;
        }

        public void setCodeStudent(int codeStudent) {
            this.codeStudent = codeStudent;
        }

        public String getNameStudent() {
            return nameStudent;
        }

        public void setNameStudent(String nameStudent) {
            this.nameStudent = nameStudent;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public double getPoint() {
            return point;
        }

        public void setPoint(double point) {
            this.point = point;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "codeStudent=" + codeStudent +
                    ", nameStudent='" + nameStudent + '\'' +
                    ", dateOfBirth='" + dateOfBirth + '\'' +
                    ", point=" + point +
                    '}';
        }
    }

