package service;

import model.Account;
import model.AccountType;
import org.w3c.dom.ls.LSOutput;
import repository.AccountRepository;
import repository.ClientRepository;

import java.sql.SQLException;
import java.util.AbstractCollection;

public class AccountService {
    private AccountRepository accountRepository;
    private ClientRepository clientRepository;


    public void add(String username  , AccountType accountType , double balance) throws SQLException, ClassNotFoundException {
        accountRepository = new AccountRepository();
        clientRepository = new ClientRepository();
        int id = clientRepository.findByUser(username);
        if (accountRepository.add(id , new Account(-1 ,-1 ,accountType,balance))) {
            System.out.println("The account create successfully");
        }else System.out.println("The account didn't create !!! ");
    }

    public Account find(int id) throws SQLException, ClassNotFoundException {
        accountRepository = new AccountRepository();
        return accountRepository.find(id);
    }

    public void findAll() throws SQLException, ClassNotFoundException {
        accountRepository = new AccountRepository();
        accountRepository.findAll();
    }

    public boolean update(int id_client , String account_type , double balance) throws SQLException, ClassNotFoundException {
       accountRepository = new AccountRepository();
       Account account = new Account(-1,id_client,AccountType.valueOf(account_type),balance);
       return accountRepository.update(account);
    }

    public boolean delete(int id_client) throws SQLException, ClassNotFoundException {
        accountRepository = new AccountRepository();
        return accountRepository.delete(id_client);
    }


}
