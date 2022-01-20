package service;

import model.Employee;
import model.EmployeeType;
import repository.EmployeeRepository;

import java.sql.SQLException;

public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public void findByUP(String username ,String password) throws SQLException, ClassNotFoundException {
        employeeRepository = new EmployeeRepository();
        Employee employee = employeeRepository.findByUP(username,password);
        System.out.println(
                "id            : "+employee.getId()+
                "\nfirst name    : "+employee.getFirstName()+
                "\nlast name     : "+employee.getLastName()+
                "\naddress       : "+employee.getAddress()+
                "\nbirth date    : "+employee.getBirthDate()+
                "\nnational code : "+employee.getNationalCode()+
                "\nphone number  :"+employee.getPhone());
    }

}
