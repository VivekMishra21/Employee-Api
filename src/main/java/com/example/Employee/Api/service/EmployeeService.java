package com.example.Employee.Api.service;


import com.example.Employee.Api.entity.Employee;
import com.example.Employee.Api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    public Employee employeeById(long id){
        return employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee not fot found with id:"+ id));
    }
    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(long id,Employee employee){
        Employee existEmployee=employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Employee not found with this id"+id));

        existEmployee.setFirstName(employee.getFirstName());
        existEmployee.setLastName(employee.getLastName());
        existEmployee.setEmail(employee.getEmail());
        existEmployee.setCity(employee.getCity());

        return employeeRepository.save(existEmployee);
    }

    public void deleteEmployeeById(Long id) {
        // Check if the employee exists before attempting to delete
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);  // Delete employee by ID
    }


}
