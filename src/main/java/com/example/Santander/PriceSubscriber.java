package com.example.Santander;

public interface PriceSubscriber {
    Price onMessage(String message);
}
