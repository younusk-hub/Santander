package com.example.Santander;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceServiceTest {

    @Test
    public void onMessage(){
        PriceService priceService = new PriceService();

        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss:SSS");
        LocalDateTime localDateTime = LocalDateTime.from(formatDateTime.parse("01-06-2020 12:01:02:110"));
        Timestamp timestamp = Timestamp.valueOf(localDateTime);

        Price newPrice = priceService.onMessage("110, EUR/JPY, 119.61,119.91,01-06-2020 12:01:02:110");

        double commissionedBid = 119.61 - 119.61/1000;
        double commissionedAsk = 119.91 + 119.91/1000;

        assertEquals(110, newPrice.getId());
        assertEquals("EUR/JPY", newPrice.getInstrumentName());
        assertEquals(commissionedBid, newPrice.getBid());
        assertEquals(commissionedAsk, newPrice.getAsk());
        assertEquals(timestamp, newPrice.getTimestamp());
    }

}