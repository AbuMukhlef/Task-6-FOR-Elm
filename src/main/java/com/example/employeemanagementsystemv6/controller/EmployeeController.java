package com.example.employeemanagementsystemv6.controller;

import com.example.employeemanagementsystemv6.common.EmployeeNotFoundException;
import com.example.employeemanagementsystemv6.repository.Employees;
import com.example.employeemanagementsystemv6.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/absher/api/v6/employees")
public class EmployeeController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employees> getAllEmployees() {
        log.info("getAllEmployees : Controller");
        return employeeService.findAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employees> getEmployeeById(@PathVariable int id) {
        log.info("getEmployeeById : Controller");
        Optional<Employees> employee = employeeService.findEmployeeById(id);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody Employees employee) {
        log.info("createEmployee : Controller");
        return employeeService.saveEmployee(employee);
    }

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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) throws EmployeeNotFoundException {
        log.info("deleteEmployee : Controller");
        return employeeService.deleteEmployee(id);
    }
}
