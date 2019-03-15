package com.kiran.digitalreceipts.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.kiran.digitalreceipts.Util.DateGenerator;
import com.kiran.digitalreceipts.model.Item;
import com.kiran.digitalreceipts.model.Transactionlogs;

public class Generator {

    private static final Random random = new Random();

    public static Integer tid = new Integer(1);

    private static SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");

    private static String[] itemList = {
            "Milk",
            "Pen",
            "Soap",
            "Bread",
            "Eggs",
            "Fish",
            "Spinach"
    };

    private static String[] CategoryList = {
            "Dairy",
            "stationary",
            "HealthCare",
            "Breab And snacks",
            "poultry",
            "seafood",
            "Vegetables"
    };

    public static List<Transactionlogs> getTransactionsBetweenDates(long from, long to) {
        int noOftransaction = random.nextInt(30);
        List<Transactionlogs> list = new ArrayList<>(noOftransaction);

        for(int j=0; j<= noOftransaction; j++){
            Transactionlogs tlogs = new Transactionlogs();
            long randomTime = DateGenerator.getRandomTimeBetweenTwoDates();
            tlogs.setBusinessDate(new Date(randomTime));
            tlogs.setId(tid);
            tlogs.setStoreId(random.nextInt(250));
            int noOfItems = random.nextInt(15);
            double netSaleAmount = 0.0;

            tlogs.setListOfItem(new ArrayList<>());

            for (int i = 0; i <= noOfItems; i++) {
                Item item = randomItem();
                tlogs
                        .getListOfItem()
                        .add(item);
                netSaleAmount = netSaleAmount + (item.getSalesUnitPrice()*item.getQuantity());
            }
            tlogs.setNetSaleAmount(netSaleAmount);
            tlogs.setPaidAmount(Math.ceil(netSaleAmount));
            tlogs.setTenderType("Cash");
            tlogs.setVoidedAmount(00);

            list.add(tlogs);
        }
        return list;
    }

    public static List<Transactionlogs> getTransactions() {
        LocalDateTime pasttwoweeks = LocalDateTime
                .now().minus(14, ChronoUnit.DAYS);
        long fromDate = Timestamp.valueOf(pasttwoweeks).getTime();
        long toDate = Timestamp.valueOf(LocalDateTime.now()).getTime();
       return getTransactionsBetweenDates(fromDate, toDate);
    }

    static Item randomItem() {
        Item item = new Item();
        int itemId = new Random().nextInt(itemList.length);
        item.setItemId(itemId);
        item.setCategory(CategoryList[itemId]);
        item.setItemName(itemList[itemId]);
        item.setQuantity(random.nextInt(5));
        item.setSalesUnitPrice(Math.round(random.nextDouble() * 100D) / 100D);
        return item;
    }
}
