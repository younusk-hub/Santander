package com.example.Santander;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;


@Repository
public class PriceRepository {

    @Autowired
    PriceService priceService;

    private HashMap<String, Price> priceMap = new HashMap<String, Price>();

    public void addPriceToMap(Price price, String instrument) {
        priceMap.put(instrument, price);
    }

    public HashMap<String, Price> getPriceMap() {
        return priceMap;
    }

    public Price getPriceByName(String convertFrom, String convertTo) {
        String instrument = convertFrom.toUpperCase() + "/" + convertTo.toUpperCase();
        if (priceMap.get(instrument) == null) {
            throw new PriceNotFoundException();
        }
        return priceMap.get(instrument);

    }

    public void getNewMessage(String message){
        Price newPrice = priceService.onMessage(message);
        addPriceToMap(newPrice, newPrice.getInstrumentName());
    }
}
