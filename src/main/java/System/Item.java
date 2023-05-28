package System;

public class Item {
    private Double price;
    private String name;
    private String description;
    private String itemType; //

    public Item(Double price, String name, String description, String itemType) {
        this.price = price;
        this.name = name;
        this.description = description;
        this.itemType = itemType;
    }
}
