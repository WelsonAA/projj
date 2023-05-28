package System;

public class Bill {
    private Double Amount;
    private String Description;
    private Integer BillID;
    private String BillType; //possible to be enum
    static int id=0;
    public Bill(Double amount, String description, String billType) {
        Amount = amount;
        Description = description;
        BillID=id++;
        BillType = billType;
    }

    public Double getAmount() {
        return Amount;
    }

    public String getDescription() {
        return Description;
    }

    public Integer getBillID() {
        return BillID;
    }

    public String getBillType() {
        return BillType;
    }
}
