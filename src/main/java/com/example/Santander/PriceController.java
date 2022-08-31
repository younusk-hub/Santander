package com.example.Santander;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PriceController {

    @Autowired
    PriceRepository priceRepository;

    @ExceptionHandler
    public ResponseEntity<String> handleExceptions(Exception exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @GetMapping("/{convertFrom}/{convertTo}")
    public ResponseEntity<Price> getPriceByName(@PathVariable String convertFrom, @PathVariable String convertTo){
        Price price = priceRepository.getPriceByName(convertFrom, convertTo);
        System.out.println(price);
        return ResponseEntity.status(HttpStatus.FOUND).body(price);
    }

    @PostMapping("/price")
    public ResponseEntity<String> createPrice(@RequestBody NewPrice newPrice) {
        priceRepository.getNewMessage(newPrice.getNewPrice());
        System.out.println(priceRepository.getPriceMap());
        return ResponseEntity.status(HttpStatus.CREATED).body("Price has been added.");
    }
}
