package com.reactive.reacitveProgramming.controller;

import com.reactive.reacitveProgramming.modalEntity.Employee;
import com.reactive.reacitveProgramming.service.EmployeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeServiceImpl employeService;

    @GetMapping("/getEmployees")
    public Flux<Employee> getEmployees() {
        log.info("Inside getemployee method");
        Flux<Employee> emplist = employeService.getEmployeeList();
        return emplist;
    }

    @RequestMapping(value = "/createEmployee", method = RequestMethod.POST)
    public ResponseEntity<String> createEmployee(@RequestBody Employee emp) {
        employeService.createEmployee(emp);
        return new ResponseEntity<String>("New employee is Stored", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/deleteEmployee/{id}", method = RequestMethod.DELETE)
    public Mono<Void> deleteEmployee(@PathVariable Integer id) {
        Mono<Void> del = employeService.deleteEmployee(id);
        log.info("Employee with id " + id + " deleted");
        return del;
    }

    @PutMapping("/updateEmployee")
    public Mono<Employee> updateEmployee(@RequestBody Employee emp) {
        Mono<Employee> updateEmployee = employeService.updateEmployee(emp);
        log.info("Employee with id " + emp.getId() + " is updated");
        return updateEmployee;
    }

    @GetMapping("/findEmployee/{id}")
    public Mono<Employee> findEmployee(@PathVariable Integer id) {
        Mono<Employee> emp = employeService.findEmployee(id);
        return emp;
    }

    @GetMapping("/findEmployeebyName/{name}")
    public Flux<Employee> findEmployee(@PathVariable String name) {
        Flux<Employee> emp = employeService.findEmployeebyName(name);
        return emp;
    }
}
