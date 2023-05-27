package System;

import java.util.Date;

public class Deposit extends Transaction {
    public Deposit() {
    }

    public Deposit(Double amount, Date TransactionDate) {
        super(amount, TransactionDate);
    }
}
