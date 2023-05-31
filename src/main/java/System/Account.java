package System;
import java.time.LocalDate;
import java.util.ArrayList;


public class Account {
    private Integer AccountNo;
    private String UserName;
    private String Password;
    private Double Balance;
    private LocalDate BirthDate;
    private String Address;
    private String ZipCode;
    static int id=0;
    private String SSN;
    private String CardNo;
    private String TelephoneNo;
    private String Email;
    ArrayList<Transaction> Transactions=new ArrayList<Transaction>();
    ArrayList<Bill> Bills=new ArrayList<Bill>();

    private void withdraw(Double amount){
        Withdraw w =new Withdraw(amount,LocalDate.now());
        Transactions.add(w);
        if(amount>Balance){
            //Error
        }else {
            this.Balance -= amount;
        }
    }
    private void deposit(Double amount){
        Deposit d =new Deposit(amount,LocalDate.now());
        Transactions.add(d);
        this.Balance+=amount;
    }

    private void transfer(Double amount,String receiverAccountNo){
        Transfer t =new Transfer(amount,LocalDate.now(),receiverAccountNo);
        Transactions.add(t);
        if(amount>Balance){
            //Error
        }else {
            this.Balance -= amount;
        }
    }
    private void payBill(Double amount, String description,String billType){
        Bill b=new Bill(amount,description,billType,LocalDate.now());
        Bills.add(b);
        if(amount>Balance){
            //Error
        }else {
            this.Balance -= amount;
        }
    }
    public Account(String userName, String password, Double balance, LocalDate birthDate) {
        UserName = userName;
        Password = password;
        Balance = balance;
        BirthDate = birthDate;
        AccountNo=id++;
    }

    public Integer getAccountNo() {
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
