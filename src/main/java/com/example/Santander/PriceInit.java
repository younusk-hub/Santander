package com.example.Santander;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class PriceInit {
    private final PriceRepository priceRepository;

    @Autowired
    public PriceInit(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @PostConstruct
    public void init() throws IOException {
        String line = "";
        String splitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/prices"));
            while ((line = br.readLine()) != null) {
                String[] priceStats = line.split(splitBy);

                DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss:SSS");
                LocalDateTime localDateTime = LocalDateTime.from(formatDateTime.parse(priceStats[4]));
                Timestamp timestamp = Timestamp.valueOf(localDateTime);

                String instrument = priceStats[1].replace(" ", "");
                Price newPrice = new Price(Integer.valueOf(priceStats[0]), instrument, Double.valueOf(priceStats[2]), Double.valueOf(priceStats[3]), timestamp);
                newPrice.commissionToBid();
                newPrice.commissionToAsk();
                priceRepository.addPriceToMap(newPrice, instrument);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        System.out.println(priceRepository.getPriceMap());
    }
}
