package com.tantrakarsh.springwebflux.service;

import com.tantrakarsh.springwebflux.model.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {
    void createEmployee(Employee employee);

    Mono<Employee> findById(Integer id);

    Flux<Employee> findByName(String name);

    Flux<Employee> findAll();

    Mono<Employee> updateEmployee(Employee employee);

    Mono<Void> delete(Integer id);
}
