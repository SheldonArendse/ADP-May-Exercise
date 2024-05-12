package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.repository.IEmployeeRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    void findAllByEmployeeNumberOrderByEmployeeNumber() {
    }

    @Test
    void create() {
        for (int i = 0; i < 2; i++) {
            Employee e1 = EmployeeFactory.buildEmployee("Seth" + i, "Rogan" + i);
            assertEquals(e1, employeeService.create(e1));
            System.out.println(e1);
        }
    }

    @Test
    void read() {
        Employee e1 = employeeService.read(4658892705681067023L);
        assertNotNull(e1);
        assertEquals(4658892705681067023L, e1.getEmployeeNumber());
        System.out.println(e1);
    }

    @Test
    void update() {
        Contact c1 = new Contact.Builder().setEmail("email0@hotmail.com").build();
        Employee e1Test = employeeService.read(3655839579328825350L);
        Employee e1 = EmployeeFactory.buildEmployee(e1Test, c1);

        assertEquals(e1, employeeService.create(e1));

        System.out.println(employeeService.getAll());
    }

    @Test
    void delete() {
        Employee e1 = employeeService.read(7957868840647872384L);
        employeeService.delete(e1);
        assertNull(employeeService.read(7957868840647872384L));
        System.out.println(e1);
    }

    @Test
    void getAll() {
        List<Employee> arr = employeeService.getAll();
        assertNotNull(arr);
        System.out.println(arr);
    }
}