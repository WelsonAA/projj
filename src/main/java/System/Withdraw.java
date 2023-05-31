package System;

import java.time.LocalDate;

public class Withdraw extends Transaction{
    public Withdraw() {
    }

    public Withdraw(Double amount, LocalDate TransactionDate) {
        super(amount, TransactionDate);
    }
}
