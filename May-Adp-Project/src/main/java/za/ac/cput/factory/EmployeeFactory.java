package za.ac.cput.factory;

import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Employee;
import za.ac.cput.utils.Helper;

public class EmployeeFactory {

    public static Employee buildEmployee(Long employeeNumber, String firstName, String lastName, Contact contact) {
        if (Helper.testLong(employeeNumber)
                && Helper.testString(firstName)
                && Helper.testString(lastName)
                && Helper.testContact(contact)) {

            return new Employee.Builder()
                    .setEmployeeNumber(employeeNumber)
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setContact(contact)
                    .build();
        }
        return null;
    }

    public static Employee buildEmployee(String firstName, String lastName, Contact contact) {
        if (Helper.testString(firstName)
                && Helper.testString(lastName)
                && Helper.testContact(contact)) {

            return new Employee.Builder()
                    .setEmployeeNumber(Helper.generateId())
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setContact(contact)
                    .build();
        }
        return null;
    }

    public static Employee buildEmployee(Long employeeNumber, String firstName, String lastName) {
        if (Helper.testString(firstName)
                && Helper.testString(lastName) && Helper.testLong(employeeNumber)) {

            return new Employee.Builder()
                    .setEmployeeNumber(employeeNumber)
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .build();
        }
        return null;
    }

    public static Employee buildEmployee(String firstName, String lastName) {
        if (Helper.testString(firstName)
                && Helper.testString(lastName)) {

            return new Employee.Builder()
                    .setEmployeeNumber(Helper.generateId())
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .build();
        }
        return null;
    }

    public static Employee buildEmployee(Long employeeNumber, Contact contact) {
        if (Helper.testLong(employeeNumber)) {

            return new Employee.Builder()
                    .setEmployeeNumber(employeeNumber)
                    .setContact(contact)
                    .build();
        }
        return null;
    }

    public static Employee buildEmployee(Employee emp, Contact con) {
        if (Helper.testContact(con)
                && Helper.testEmployee(emp)) {

            return new Employee.Builder().copy(emp).setContact(con).build();
        }
        return null;
    }
}
