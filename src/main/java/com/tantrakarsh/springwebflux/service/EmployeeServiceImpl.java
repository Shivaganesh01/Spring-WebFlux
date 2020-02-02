package com.tantrakarsh.springwebflux.service;

import com.tantrakarsh.springwebflux.model.Employee;
import com.tantrakarsh.springwebflux.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee).subscribe();
    }

    @Override
    public Mono<Employee> findById(Integer id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Flux<Employee> findByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public Flux<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Mono<Employee> updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Mono<Void> delete(Integer id) {
        return employeeRepository.deleteById(id);
    }
}
