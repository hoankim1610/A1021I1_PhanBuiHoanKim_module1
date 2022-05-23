package model;

import java.util.Date;

public class Student {
    private String id;
    private String name;
    private Date birthDay;
    private boolean sex;

    public Student() {
    }

    public Student(String id, String name, Date birthDay, boolean sex) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}
