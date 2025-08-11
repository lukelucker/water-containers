package pl.kurs.watercontainers.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Employee implements Serializable {
    private static final long serialVersionUID = 42L;

    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private Integer experienceInYears;

    public Employee(String firstName, String lastName, BigDecimal salary, Integer experienceInYears) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.experienceInYears = experienceInYears;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Integer getExperienceInYears() {
        return experienceInYears;
    }

    public void setExperienceInYears(Integer experienceInYears) {
        this.experienceInYears = experienceInYears;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Employee employee = (Employee) object;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(salary, employee.salary) && Objects.equals(experienceInYears, employee.experienceInYears);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, salary, experienceInYears);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", experienceInYears=" + experienceInYears +
                '}';
    }
}
