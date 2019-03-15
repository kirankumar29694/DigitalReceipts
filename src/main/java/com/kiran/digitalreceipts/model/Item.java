package com.kiran.digitalreceipts.model;

public class Item {

    private long itemId;

    private String itemName;

    private double quantity;

    private double salesUnitPrice;

    private String Category;

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getSalesUnitPrice() {
        return salesUnitPrice;
    }

    public void setSalesUnitPrice(double salesUnitPrice) {
        this.salesUnitPrice = salesUnitPrice;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }
}
