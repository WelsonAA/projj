package System;

import java.util.Date;

public class Transaction {
    private Double TransactionAmount;
    private Integer TransactionID;
    private Date TransactionDate;
    static Integer id=0;
    public Transaction(){}

    public Date getTransactionDate() {
        return TransactionDate;
    }

    public Transaction(Double amount, Date TransactionDate) {
        TransactionAmount = amount;
        TransactionID =id++ ;
        this.TransactionDate=TransactionDate;
    }

    public Double getTransactionAmount() {
        return TransactionAmount;
    }

    public Integer getTransactionID() {
        return TransactionID;
    }
}
