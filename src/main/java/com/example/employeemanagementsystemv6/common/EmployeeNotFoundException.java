package com.example.employeemanagementsystemv6.common;

public class EmployeeNotFoundException extends Exception {

    public EmployeeNotFoundException() {}

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
