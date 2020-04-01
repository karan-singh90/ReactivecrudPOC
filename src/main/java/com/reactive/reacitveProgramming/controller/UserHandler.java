package com.reactive.reacitveProgramming.controller;

import com.reactive.reacitveProgramming.modalEntity.Employee;
import com.reactive.reacitveProgramming.repository.EmployeeDaoRepository;
import com.reactive.reacitveProgramming.service.EmployeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


@Component
public class UserHandler {
    @Autowired
    EmployeeDaoRepository employeeDao;

    @Autowired
    EmployeServiceImpl employeService;


    public Mono addUser(ServerRequest request) {
        Mono<Employee> employee = request.bodyToMono(Employee.class);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(employee.flatMap(emp -> employeService.savePerson(emp)), Employee.class);
    }

    public Mono getUsers(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(employeeDao.findAll(), Employee.class)
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono getUserById(ServerRequest request) {
        String id = request.pathVariable("id");
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(employeeDao.findById(Integer.parseInt(id)), Employee.class)
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono deleteUserById(ServerRequest request) {
        String id = request.pathVariable("id");
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(employeeDao.deleteById(Integer.parseInt(id)), Employee.class)
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono updateUser(ServerRequest request) {
        Mono<Employee> employeeMono = request.bodyToMono(Employee.class);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(employeeMono.flatMap(emp -> employeService.savePerson(emp)), Employee.class);
    }
}
