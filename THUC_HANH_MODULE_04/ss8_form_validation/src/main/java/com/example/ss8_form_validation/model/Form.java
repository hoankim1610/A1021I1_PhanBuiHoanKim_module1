package com.example.ss8_form_validation.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Data
public class Form {
    @Length(min = 5, max= 30, message = "length from 5 to 45")
    private String firstName;
    @Length(min = 3, max= 30, message = "length from 3 to 25")
    private String lastName;
    @Pattern(regexp = "\\d{10}", message = "must be of 10 digit")
    private String phone;

    @Min(value = 18, message = "min 18")
    private int age;
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "must be email")
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
