package System;

import java.time.LocalDate;

public class Transfer extends Transaction{
    private String ReceiverAccountNo;

    public Transfer(Double amount, LocalDate TransactionDate, String receiverAccountNo) {
        super(amount, TransactionDate);
        ReceiverAccountNo = receiverAccountNo;
    }

    public String getReceiverAccountNo() {
        return ReceiverAccountNo;
    }
}
