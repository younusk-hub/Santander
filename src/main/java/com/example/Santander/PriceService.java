package com.example.Santander;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class PriceService implements PriceSubscriber {

    @Override
    public Price onMessage(String message) {
        String splitBy = ",";

        String[] priceStats = message.split(splitBy);

        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss:SSS");
        LocalDateTime localDateTime = LocalDateTime.from(formatDateTime.parse(priceStats[4]));
        Timestamp timestamp = Timestamp.valueOf(localDateTime);

        String instrument = priceStats[1].replace(" ", "");
        Price newPrice = new Price(Integer.valueOf(priceStats[0]), instrument, Double.valueOf(priceStats[2]), Double.valueOf(priceStats[3]), timestamp);
        newPrice.commissionToAsk();
        newPrice.commissionToBid();
        return newPrice;
    }
}
