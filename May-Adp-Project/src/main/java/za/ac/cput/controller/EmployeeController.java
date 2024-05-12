package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/create")
    public Employee create(@RequestBody Employee obj) {
        Contact c1 = ContactFactory.buildContact(obj.getContact().getEmail());
        Employee e1 = EmployeeFactory.buildEmployee(obj.getEmployeeNumber(), obj.getFirstName(), obj.getLastName(), c1);

        return employeeService.create(e1);
    }

    @GetMapping("/read/{aLong}")
    public Employee read(@PathVariable Long aLong) {
        return employeeService.read(aLong);
    }

    @PostMapping("/update")
    public Employee update(@RequestBody Employee obj) {
        Contact c1 = ContactFactory.buildContact(obj.getContact().getEmail());

        return employeeService.update(obj);
    }

//    @PostMapping("/delete/{id}")
//    public void delete(@PathVariable Long id) {
//        Employee e1 = EmployeeFactory.buildEmployee(id);
//        employeeService.delete(e1);
//    }

    @GetMapping("/getAll")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/idsAfter/{id}")
    public List<Employee> findAllByEmployeeNumberOrderByEmployeeNumber(@PathVariable Long id) {
        return employeeService.findAllByEmployeeNumberOrderByEmployeeNumber(id);
    }
}
