package model;

import java.sql.Date;

public class Transaction {
    private TransactionType transactionType ;
    private Account accountFrom ;
    private Account accountTo ;
    private Status status ;
    private Date transactionDate ;
    private final double interestRate = 600;

    public Transaction(TransactionType transactionType, Account accountFrom, Account accountTo, Status status, Date transactionDate) {
        this.transactionType = transactionType;
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.status = status;
        this.transactionDate = transactionDate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Account getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(Account accountFrom) {
        this.accountFrom = accountFrom;
    }

    public Account getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(Account accountTo) {
        this.accountTo = accountTo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
