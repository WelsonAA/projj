package System;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;


public class Account {
    private Integer AccountNo;
    private String UserName;
    private String Password;
    private Double Balance;
    private LocalDate BirthDate;

    public Account(String userName, String password) {
        UserName = userName;
        Password = password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "UserName='" + UserName + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }

    private String Address;
    private String ZipCode;
    public LocalDate getBirthDate() {
        return BirthDate;
    }
    static int id=0;
    private String SSN;
    private String CardNo;
    private String TelephoneNo;
    private String Email;
    ArrayList<Transaction> Transactions=new ArrayList<Transaction>();
    ArrayList<Bill> Bills=new ArrayList<Bill>();

    public void withdraw(Double amount)throws InsufficientBalance{
        if(amount>Balance){
            throw new InsufficientBalance();
        }else {
            Withdraw w =new Withdraw(amount,LocalDate.now(),this.getBalance());
            Transactions.add(w);
            this.Balance -= amount;
        }
    }
    public void deposit(Double amount){
        Deposit d =new Deposit(amount,LocalDate.now(),this.getBalance());
        Transactions.add(d);
        this.Balance+=amount;
    }

    public void transfer(Double amount,Integer receiverAccountNo)throws TransferExceptions{

        if(amount>Balance){
            throw new InsufficientBalance();
        }else if(Bank.check(receiverAccountNo)==null){
            throw new InvalidAccountNo();
        }
        else {
            Transfer t =new Transfer(amount,LocalDate.now(),receiverAccountNo,this.getBalance());
            Transactions.add(t);
            this.Balance -= amount;
        }
    }
    public void payBill(Double amount, BillType bt)throws InsufficientBalance{
        if(amount>Balance){
            throw new InsufficientBalance();
        }else {
            Bill b=new Bill(amount,bt,LocalDate.now(),this.getBalance());
            Bills.add(b);
            this.Balance -= amount;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(getUserName(), account.getUserName()) && Objects.equals(getPassword(), account.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName(), getPassword());
    }

    public void purchaseItem(Double amount, String storeName, String itemName)throws InsufficientBalance{
        if(amount>Balance){
            throw new InsufficientBalance();
        }else {
            Item i = new Item(amount, storeName, itemName);
            payBill(amount,BillType.PURCHASED_ITEMS);
        }
    }



    public void printBankStatement(){
    }
    public Account(String userName, String password, Double balance, LocalDate birthDate) {
        UserName = userName;
        Password = password;
        BirthDate = birthDate;
        AccountNo=id++;
        if(balance<=0.0){
            Balance=0.0;
        }else{
            this.Balance = balance;
        }
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
