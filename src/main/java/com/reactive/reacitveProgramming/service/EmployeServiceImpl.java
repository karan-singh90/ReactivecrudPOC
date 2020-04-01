package com.reactive.reacitveProgramming.service;


import com.reactive.reacitveProgramming.modalEntity.Employee;
import com.reactive.reacitveProgramming.repository.EmployeeDaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDaoRepository employeeDao;

    @Override
    public Flux<Employee> getEmployeeList() {
        return employeeDao.findAll();
    }

    @Override
    public void createEmployee(Employee emp) {
        employeeDao.save(emp).subscribe();
    }

    public Mono<Employee> savePerson(Employee emp) {
        return employeeDao.save(emp);
    }

    @Override
    public Mono<Void> deleteEmployee(Integer id) {
        return employeeDao.deleteById(id);
    }

    @Override
    public Mono<Employee> updateEmployee(Employee emp) {
        return  employeeDao.save(emp);
       // Mono<Employee> empfromDB = employeeDao.findById(emp.getId());
//
//        System.out.println("******"+empfromDB.toString());
//
//        Employee empChange = new Employee();
//        empfromDB.map((employee)->{
//            empChange.setId(employee.getId());
//            empChange.setFirst_name(employee.getFirst_name());
//            empChange.setLast_name(employee.getLast_name());
//            empChange.setAge(employee.getAge());
//            empChange.setEmail(employee.getEmail());
//            return empChange;});
//        employeeDao.save(empChange);
//        empfromDB.flatMap((employee)->{
//            Employee empChange = new Employee();
//        empChange.setFirst_name(employee.getFirst_name());
//        empChange.setLast_name(employee.getLast_name());
//        empChange.setAge(employee.getAge());
//        empChange.setEmail(employee.getEmail());
//        return empChange;});

//       return Mono.just(empChange);
    }

    @Override
    public Mono<Employee> findEmployee(Integer id) {
        return employeeDao.findById(id);
    }

    @Override

    public Flux<Employee> findEmployeebyName(String name) {
        return employeeDao.findByFirstName(name);
    }
}
