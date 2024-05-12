package za.ac.cput.service;

import za.ac.cput.domain.Employee;

import java.util.List;

public interface IEmployeeService extends ImplService<Employee, Long> {
    public List<Employee> findAllByEmployeeNumberOrderByEmployeeNumber(Long id);
}
