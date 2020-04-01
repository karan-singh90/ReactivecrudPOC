package com.reactive.reacitveProgramming.repository;

import com.reactive.reacitveProgramming.modalEntity.Employee;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface EmployeeDaoRepository extends ReactiveCassandraRepository<Employee, Integer> {
    @AllowFiltering
    @Query("SELECT * FROM employee WHERE first_name=?1")
    Flux<Employee> findByFirstName(String name);
}
