package com.example.employeemanagementsystemv6.repository;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employees implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier for the employee", required = true)
    private int id;

    @Column(name = "name")
    @Schema(description = "Full name of the employee", example = "Abdullah", required = true)
    private String name;

    @Column(name = "gender")
    @Schema(description = "Gender of the employee", example = "Male", required = true)
    private String gender;

    @Column(name = "dob")
    @Schema(description = "Date of birth", example = "1989/11/16", required = true)
    private String dob;

    @Column(name = "phone_number", nullable = true)
    @Schema(description = "Employee's contact number", example = "0544948800")
    private String phoneNumber;

    @Column(name = "hobbies", nullable = true)
    @Schema(description = "List of hobbies", example = "[\"Programming\", \"Reading\"]")
    private List<String> hobbies;


    public Employees() {}

    public Employees(int id, String name, String gender, String dob, String phoneNumber, List<String> hobbies) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.hobbies = hobbies;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", dob='" + dob + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", hobbies=" + hobbies +
                '}';
    }
}
