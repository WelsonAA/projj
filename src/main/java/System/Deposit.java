package System;

import java.time.LocalDate;

public class Deposit extends Transaction {
    public Deposit() {
    }

    public Deposit(Double amount, LocalDate TransactionDate) {
        super(amount, TransactionDate);
    }
}
