package com.example.beforeexam.dto;

import com.example.beforeexam.model.Instructor;
import net.bytebuddy.agent.builder.AgentBuilder;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

public class StudentDTO {

    private int id;

    @NotEmpty(message = "Thus is not empty!")
    private String name;

    @Min(value = 0, message = "This is more than 0!")
    @Max(value = 10, message = "This is less than 10!")
    private double point;

    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "This must be email!")
    private String email;

//    @Pattern(regexp = "\\d{10}", message = "must be of 10 digit")  //phone
    private int phone;

    private List<Instructor> instructors;

    public StudentDTO() {
    }

    public StudentDTO(int id, String name, double point, String email, int phone, List<Instructor> instructors) {
        this.id = id;
        this.name = name;
        this.point = point;
        this.email = email;
        this.phone = phone;
        this.instructors = instructors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }
}
