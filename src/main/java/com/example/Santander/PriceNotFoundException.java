package com.example.Santander;

import javax.persistence.EntityNotFoundException;

public class PriceNotFoundException extends EntityNotFoundException {
    public PriceNotFoundException() {
        super("Price instrument name has not been found");
    }
}
