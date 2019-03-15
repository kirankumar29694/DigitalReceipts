package com.kiran.digitalreceipts.model;

import java.util.Date;
import java.util.List;

public class Transactionlogs {

    private long id;

    private Date businessDate;

    private long receiptNumber;

    private int storeId;

    private List<Item> listOfItem;

    private double paidAmount;

    private double NetSaleAmount;

    private double voidedAmount;

    private String tenderType;

    public Date getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(Date businessDate) {
        this.businessDate = businessDate;
    }

    public long getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(long receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public List<Item> getListOfItem() {
        return listOfItem;
    }

    public void setListOfItem(List<Item> listOfItem) {
        this.listOfItem = listOfItem;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public double getNetSaleAmount() {
        return NetSaleAmount;
    }

    public void setNetSaleAmount(double netSaleAmount) {
        NetSaleAmount = netSaleAmount;
    }

    public double getVoidedAmount() {
        return voidedAmount;
    }

    public void setVoidedAmount(double voidedAmount) {
        this.voidedAmount = voidedAmount;
    }

    public String getTenderType() {
        return tenderType;
    }

    public void setTenderType(String tenderType) {
        this.tenderType = tenderType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
