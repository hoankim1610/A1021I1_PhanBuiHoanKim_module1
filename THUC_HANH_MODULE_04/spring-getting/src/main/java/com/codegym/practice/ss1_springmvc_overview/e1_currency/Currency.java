package com.codegym.practice.ss1_springmvc_overview.e1_currency;

public class Currency {
    private long usd;
    private double rate;

    public Currency() {

    }

    public Currency(long usd, double rate) {
        this.usd = usd;
        this.rate = rate;
    }

    public long getUsd() {
        return usd;
    }

    public void setUsd(long usd) {
        this.usd = usd;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}

