package System;

import java.util.ArrayList;
import java.util.Date;

public class Account {
    private String AccountNo;
    private String UserName;
    private String Password;
    private Double Balance;
    private Date BirthDate;
    private String Address;
    private String ZipCode;
    private String SSN;
    private String CardNo;
    private String TelephoneNo;
    private String Email;
    ArrayList<Transaction> Transactions=new ArrayList<Transaction>();

    public Account(String userName, String password, Double balance, Date birthDate) {
        UserName = userName;
        Password = password;
        Balance = balance;
        BirthDate = birthDate;
    }

    public String getAccountNo() {
        return AccountNo;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }

    public Double getBalance() {
        return Balance;
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    public String getAddress() {
        return Address;
    }

    public String getZipCode() {
        return ZipCode;
    }

    public String getSSN() {
        return SSN;
    }

    public String getCardNo() {
        return CardNo;
    }

    public String getTelephoneNo() {
        return TelephoneNo;
    }

    public String getEmail() {
        return Email;
    }
}
