package com.kiran.digitalreceipts.Util;

import java.sql.Timestamp;

public class DateGenerator {

    private static final long beginTime = Timestamp
            .valueOf("2018-10-01 00:00:00")
            .getTime();

    private static final long endTime = Timestamp
            .valueOf("2019-03-06 00:58:00")
            .getTime();

    public static long getRandomTimeBetweenTwoDates() {
        return getRandomTimeBetweenTwoDates(beginTime,endTime );
    }

    public static long getRandomTimeBetweenTwoDates(long fromDate, long toDate) {
        long diff = toDate - fromDate + 1;
        return beginTime + (long) (Math.random() * diff);
    }
}
