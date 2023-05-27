package System;

import java.util.Date;

public class Transfer extends Transaction{
    private String ReceiverAccountNo;

    public Transfer(Double amount, Date TransactionDate, String receiverAccountNo) {
        super(amount, TransactionDate);
        ReceiverAccountNo = receiverAccountNo;
    }

    public String getReceiverAccountNo() {
        return ReceiverAccountNo;
    }
}
