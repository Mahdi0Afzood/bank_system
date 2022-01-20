package model;

public class Account {
    private int id ;
    private int id_client ;
    private AccountType accountType;
    private Double Balance;

    public Account(int id, int id_client, AccountType accountType, Double balance) {
        this.id = id;
        this.id_client = id_client;
        this.accountType = accountType;
        Balance = balance;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getBalance() {
        return Balance;
    }

    public void setBalance(Double balance) {
        Balance = balance;
    }
}
