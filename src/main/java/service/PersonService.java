package service;

import model.Person;
import repository.ClientRepository;
import repository.PersonRepository;

import java.sql.Date;
import java.sql.SQLException;

public class PersonService {
    private PersonRepository personRepository;

    public void add(String firstName , String lastName , String address, String username, String password , Date birthDate , int nationalCode, int phone) throws SQLException, ClassNotFoundException {
        personRepository = new PersonRepository();
        Person person = new Person(-1 ,firstName,lastName,address ,username , password ,birthDate,nationalCode,phone);
        if (personRepository.add(person)) {
            System.out.println("person sets successfully");
        }
    }
}
