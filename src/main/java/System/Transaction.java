package System;

import java.time.LocalDate;

public class Transaction {
    @Override
    public String toString() {
        return "Transaction{" +
                "TransactionAmount=" + TransactionAmount +
                ", TransactionID=" + TransactionID +
                ", TransactionDate=" + TransactionDate +
                ", BalanceBefore=" + BalanceBefore +
                ", BalanceAfter=" + BalanceAfter +
                '}'+"\n";
    }

    protected Double TransactionAmount;
    protected Integer TransactionID;
    protected LocalDate TransactionDate;
    static Integer id=0;
    protected Double BalanceBefore;
    protected Double BalanceAfter;

    public Transaction(){}

    public LocalDate getTransactionDate() {
        return TransactionDate;
    }

    public Transaction(Double amount, LocalDate TransactionDate,Double BalanceBefore) {
        TransactionAmount = amount;
        TransactionID =id++ ;
        this.TransactionDate=TransactionDate;
        this.BalanceBefore=BalanceBefore;
    }

    public Double getTransactionAmount() {
        return TransactionAmount;
    }

    public Integer getTransactionID() {
        return TransactionID;
    }
}
