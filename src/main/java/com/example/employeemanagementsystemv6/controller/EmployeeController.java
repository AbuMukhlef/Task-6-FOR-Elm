package com.example.employeemanagementsystemv6.controller;

import com.example.employeemanagementsystemv6.common.EmployeeNotFoundException;
import com.example.employeemanagementsystemv6.repository.Employees;
import com.example.employeemanagementsystemv6.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Employee Management", description = "CRUD operations for employees")
@RestController
@RequestMapping("/absher/api/v6/employees")
public class EmployeeController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @Operation(summary = "Get all employees", description = "Fetch all employees from database")
    @GetMapping
    public List<Employees> getAllEmployees() {
        log.info("getAllEmployees : Controller");
        return employeeService.findAllEmployees();
    }

    @Operation(summary = "Get employee by ID", description = "Fetch an employee using their unique ID")
    @GetMapping("/{id}")
    public ResponseEntity<Employees> getEmployeeById(@PathVariable int id) {
        log.info("getEmployeeById : Controller");
        Optional<Employees> employee = employeeService.findEmployeeById(id);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create a new employee", description = "Add a new employee to the database")
    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody Employees employee) {
        log.info("createEmployee : Controller");
        return employeeService.saveEmployee(employee);
    }

    @Operation(summary = "Update an employee", description = "Update an existing employee using their ID")
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable int id, @RequestBody Employees updatedEmployee) {
        log.info("updateEmployee : Controller");
        try {
            ResponseEntity<?> employee = employeeService.updateEmployee(id, updatedEmployee);
            return ResponseEntity.ok(employee);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Delete an employee", description = "Remove an employee from the database using their ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) throws EmployeeNotFoundException {
        log.info("deleteEmployee : Controller");
        return employeeService.deleteEmployee(id);
    }
}
