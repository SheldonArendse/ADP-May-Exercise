package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.util.Objects;

@Entity
public class Employee {
    @Id
    private long employeeNumber;
    @OneToOne
    private Contact contact;
    private String firstName;
    private String lastName;

    protected Employee() {

    }

    public Employee(Builder builder) {
        this.employeeNumber = builder.employeeNumber;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.contact = builder.contact;
    }

    public long getEmployeeNumber() {
        return employeeNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Contact getContact() {
        return contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return getEmployeeNumber() == employee.getEmployeeNumber() && Objects.equals(getContact(), employee.getContact()) && Objects.equals(getFirstName(), employee.getFirstName()) && Objects.equals(getLastName(), employee.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeNumber(), getContact(), getFirstName(), getLastName());
    }

    @Override
    public String toString() {
        return "Employee" + "\n-----------------\n" +
                "Employee Number = " + employeeNumber + "\n" +
                "First Name = " + firstName + "\n" +
                "Last Name = " + lastName + "\n" + "Contact = " + contact;
    }

    public static class Builder {
        @Id
        private long employeeNumber;
        @OneToOne
        private Contact contact;
        private String firstName;
        private String lastName;

        public Builder setEmployeeNumber(long employeeNumber) {
            this.employeeNumber = employeeNumber;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public Builder copy(Employee obj) {
            this.employeeNumber = obj.employeeNumber;
            this.firstName = obj.firstName;
            this.lastName = obj.lastName;
            this.contact = obj.contact;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}
