package com.reactive.reacitveProgramming.service;


import com.reactive.reacitveProgramming.modalEntity.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {

    Flux<Employee> getEmployeeList();

    void createEmployee(Employee emp);

    Mono<Void> deleteEmployee(Integer id);

    Mono<Employee> updateEmployee(Employee emp);

    Mono<Employee> findEmployee(Integer id);

    Flux<Employee> findEmployeebyName(String name);
    
}
