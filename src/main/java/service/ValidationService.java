package service;

import model.Client;
import model.Employee;
import model.Person;
import repository.EmployeeRepository;
import repository.PersonRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationService {
    private PersonRepository personRepository;
    private EmployeeRepository employeeRepository;

    public boolean isEmployee(String username , String password) throws SQLException, ClassNotFoundException {
        employeeRepository = new EmployeeRepository();
        Employee employee = employeeRepository.findByUP(username, password);
        if (employee.getId()!=0) return true;
        return false;
    }




}
