package com.example.Santander;

import java.sql.Timestamp;

public class Price {

    private int id;

    private String instrumentName;

    private double bid;

    private double ask;

    private Timestamp timestamp;

    public Price(int id, String instrumentName, double bid, double ask, Timestamp timestamp) {
        this.id = id;
        this.instrumentName = instrumentName;
        this.bid = bid;
        this.ask = ask;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public double getAsk() {
        return ask;
    }

    public void setAsk(double ask) {
        this.ask = ask;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString(){
        return String.format("\nID: %d\nINSTRUMENT: %s\nBID: %f\nASK: %f\nTIMESTAMP: %s", id, instrumentName, bid, ask, timestamp);
    }

    public void commissionToAsk(){
        setAsk(ask + (ask/1000)) ;
    }

    public void commissionToBid(){
        setBid(bid - (bid/1000));
    }
}
