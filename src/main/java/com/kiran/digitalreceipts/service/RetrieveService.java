package com.kiran.digitalreceipts.service;

import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.kiran.digitalreceipts.Util.DateParameter;
import com.kiran.digitalreceipts.model.Transactionlogs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Path("/receipts")
public class RetrieveService {
    private Logger LOG = LoggerFactory.getLogger(RetrieveService.class);

   @GET
    @Produces("application/json")
    public List<Transactionlogs> retrieveTransactionlogs(
            @QueryParam("from") @NotNull DateParameter fromDate,
            @QueryParam("to") @NotNull DateParameter toDate) {
        final Date userfromDate = fromDate.getUserDate();
        final Date usertoDate = toDate.getUserDate();
       LOG.info("date entered from: {}  to: {} ",userfromDate.toString(),usertoDate.toString());
        return Generator.getTransactionsBetweenDates(userfromDate.getTime(), usertoDate.getTime());
    }

    @GET
    @Produces("application/json")
    @Path("/all")
     public List<Transactionlogs> fetch() {
        return Generator.getTransactions();
    }
}
