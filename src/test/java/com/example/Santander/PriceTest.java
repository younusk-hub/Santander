package com.example.Santander;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceTest {

    Price price;

    @BeforeEach
    public void init(){
        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss:SSS");
        LocalDateTime localDateTime = LocalDateTime.from(formatDateTime.parse("01-06-2020 12:01:02:110"));
        Timestamp timestamp = Timestamp.valueOf(localDateTime);

        price = new Price(110, "EUR/JPY", 119.61, 119.91, timestamp);
    }

    @Test
    public void GetAsk_AddCommission_ReturnCommissionedAsk() {
        double expectedNewAsk = price.getAsk() + price.getAsk()/1000;
        price.commissionToAsk();
        assertEquals(expectedNewAsk, price.getAsk());
    }

    @Test
    public void GetBid_AddCommission_ReturnCommissionedBid() {
        double expectedNewBid = price.getBid() - price.getBid()/1000;
        price.commissionToBid();
        assertEquals(expectedNewBid, price.getBid());
    }
}