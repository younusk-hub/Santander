package com.example.Santander;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceRepositoryTest {

    PriceRepository priceRepository = new PriceRepository();

    //    110, EUR/JPY, 119.61,119.91,01-06-2020 12:01:02:110
    @BeforeEach
    public void init(){
        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss:SSS");
        LocalDateTime localDateTime = LocalDateTime.from(formatDateTime.parse("01-06-2020 12:01:02:110"));
        Timestamp timestamp = Timestamp.valueOf(localDateTime);

        priceRepository.addPriceToMap(new Price(110, "EUR/JPY", 119.61,119.91, timestamp), "EUR/JPY");
    }

    @Test
    public void addPriceToMap() {
        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss:SSS");
        LocalDateTime localDateTime = LocalDateTime.from(formatDateTime.parse("01-06-2020 12:01:02:999"));
        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        Price newPrice = new Price(111, "GBP/USD", 118.12,118.51, timestamp);

        priceRepository.addPriceToMap(newPrice, "GBP/USD");
        assertEquals(newPrice, priceRepository.getPriceMap().get("GBP/USD"));
    }

    @Test
    public void updatePrice() {
        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss:SSS");
        LocalDateTime localDateTime = LocalDateTime.from(formatDateTime.parse("01-06-2020 12:01:02:999"));
        Timestamp timestamp = Timestamp.valueOf(localDateTime);

        Price newPrice = new Price(114, "EUR/JPY", 120.61,120.91, timestamp);
        priceRepository.addPriceToMap(newPrice, "EUR/JPY");
        assertEquals(newPrice, priceRepository.getPriceMap().get("EUR/JPY"));
    }

}