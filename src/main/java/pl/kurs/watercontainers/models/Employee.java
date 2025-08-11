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
    private Integer bornYear;


    public Employee(String firstName, String lastName, BigDecimal salary, Integer experienceInYears, Integer bornYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.experienceInYears = experienceInYears;
        this.bornYear = bornYear;
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

    public Integer getBornYear() {
        return bornYear;
    }

    public void setBornYear(Integer bornYear) {
        this.bornYear = bornYear;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Employee employee = (Employee) object;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName)
                && Objects.equals(salary, employee.salary) && Objects.equals(experienceInYears, employee.experienceInYears)
                && Objects.equals(bornYear, employee.bornYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, salary, experienceInYears, bornYear);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", experienceInYears=" + experienceInYears +
                ", bornYear=" + bornYear +
                '}';
    }
}
