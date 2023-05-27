package System;

public class Transaction {
    private Double Amount;
    private Integer TransactionID;
    static Integer id=0;
    public Transaction(){}
    public Transaction(Double amount) {
        Amount = amount;
        TransactionID =id++ ;
    }

    public Double getAmount() {
        return Amount;
    }

    public Integer getTransactionID() {
        return TransactionID;
    }
}
