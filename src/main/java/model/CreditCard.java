package model;

import java.sql.Date;

public class CreditCard {
    private Account account;
    private String cardNumber;
    private int password;
    private int cvv2;
    private Date startDate;
    private Date expiredDate;


    public CreditCard(Account account, String cardNumber, int password, int cvv2, Date startDate, Date expiredDate) {
        this.account = account;
        this.cardNumber = cardNumber;
        this.password = password;
        this.cvv2 = cvv2;
        this.startDate = startDate;
        this.expiredDate = expiredDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getCvv2() {
        return cvv2;
    }

    public void setCvv2(int cvv2) {
        this.cvv2 = cvv2;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }
}
