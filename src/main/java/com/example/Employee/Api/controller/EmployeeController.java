package com.example.Employee.Api.controller;


import com.example.Employee.Api.entity.Employee;
import com.example.Employee.Api.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Employee Controller", description = "Employee CRUD operations")
@RestController
@RequestMapping("/api")
public class EmployeeController {

    EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @Operation(summary = "Get all employees", description = "Returns list of all employees in the database")
    @GetMapping("/get")
    public List<Employee>  allEmployee(){
         return service.getAll();

    }

    @PostMapping("/create")
    public Employee createEmp(@RequestBody  Employee employee){
       return service.addEmployee(employee);
    }

    @GetMapping("/get/{id}")
    public Employee findByEmployeeWithId(@PathVariable long id){
        return  service.employeeById(id);
    }

    @PutMapping("/put/{id}")
    public Employee update(@PathVariable long id,@RequestBody Employee employee){
        return service.updateEmployee(id,employee);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteEmployeeById(id);  // Calls service method to delete
        return ResponseEntity.ok("Employee deleted successfully.");
    }

}
