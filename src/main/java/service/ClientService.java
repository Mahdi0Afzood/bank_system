package service;

import model.Client;
import model.Person;
import repository.ClientRepository;
import repository.PersonRepository;

import java.sql.Date;
import java.sql.SQLException;

public class ClientService {
    private ClientRepository clientRepository;
    private PersonRepository personRepository;

    public void add(String username) throws SQLException, ClassNotFoundException {
        clientRepository = new ClientRepository();
        personRepository = new PersonRepository();
        int id = personRepository.findByUser(username).getId();
        if (clientRepository.add(id)) {
            System.out.println("The client add successfully");
        }else{
            System.out.println("The client did't add !!! ");
        }
    }

    public int findByUser(String username) throws SQLException, ClassNotFoundException {
        clientRepository = new ClientRepository();
        return clientRepository.findByUser(username);
    }

}
