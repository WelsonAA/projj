package System;

import java.util.Date;

public class Withdraw extends Transaction{
    public Withdraw() {
    }

    public Withdraw(Double amount, Date TransactionDate) {
        super(amount, TransactionDate);
    }
}
