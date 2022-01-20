package model;

import java.sql.Date;
import java.util.List;

public class Client extends Person{
    private List<Account> Accounts;
    private int clientCode;

    public Client(int id, String firstName, String lastName, String address, String username, String password, Date birthDate, int nationalCode, int phone, List<Account> accounts, int clientCode) {
        super(id, firstName, lastName, address, username, password, birthDate, nationalCode, phone);
        Accounts = accounts;
        this.clientCode = clientCode;
    }

    public List<Account> getAccounts() {
        return Accounts;
    }

    public void setAccounts(List<Account> accounts) {
        Accounts = accounts;
    }

    public int getClientCode() {
        return clientCode;
    }

    public void setClientCode(int clientCode) {
        this.clientCode = clientCode;
    }
}
