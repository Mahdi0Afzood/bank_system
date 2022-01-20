package model;

import java.sql.Date;

public class Employee extends Person{
    private EmployeeType employeeType;

    public Employee(int id, String firstName, String lastName, String address, String username, String password, Date birthDate, int nationalCode, int phone, EmployeeType employeeType) {
        super(id, firstName, lastName, address, username, password, birthDate, nationalCode, phone);
        this.employeeType = employeeType;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }
}
