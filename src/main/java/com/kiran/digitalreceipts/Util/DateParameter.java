package com.kiran.digitalreceipts.Util;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateParameter implements Serializable {
    private static Logger LOG = LoggerFactory.getLogger(DateParameter.class);

    private Date userDate;
    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
    public DateParameter(Date userDate) {
        this.userDate = userDate;
    }

    public Date getUserDate() {
        return userDate;
    }
    public void setUserDate(Date userDate) {
        this.userDate = userDate;
    }

    public static DateParameter valueOf(String dateString) {
        DateParameter parameter = null;
        try {
            Date date = dateFormat.parse(dateString);
            parameter = new DateParameter(date);
        } catch(Exception e) {
        LOG.error("Unparseable Date entered ", e);
        }
        return parameter;
    }


}