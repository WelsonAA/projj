package System;

import java.time.LocalDate;

public class Transaction {
    private Double TransactionAmount;
    private Integer TransactionID;
    private LocalDate TransactionDate;
    static Integer id=0;
    public Transaction(){}

    public LocalDate getTransactionDate() {
        return TransactionDate;
    }

    public Transaction(Double amount, LocalDate TransactionDate) {
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
