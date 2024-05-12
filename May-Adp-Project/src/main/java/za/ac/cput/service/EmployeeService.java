package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Employee;
import za.ac.cput.repository.IEmployeeRepository;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{
    private IEmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAllByEmployeeNumberOrderByEmployeeNumber(Long id) {
        return employeeRepository.findAllByEmployeeNumberOrderByEmployeeNumber(id);
    }

    @Override
    public Employee create(Employee obj) {
        return employeeRepository.save(obj);
    }

    @Override
    public Employee read(Long aLong) {
        return employeeRepository.findById(aLong).orElse(null);
    }

    @Override
    public Employee update(Employee obj) {
        return employeeRepository.save(obj);
    }

    @Override
    public void delete(Employee obj) {
        employeeRepository.delete(obj);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}