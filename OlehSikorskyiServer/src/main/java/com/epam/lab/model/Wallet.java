package com.epam.lab.model;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Wallet")
public class Wallet {
    public static final Double DEFAULT_MONEY_AMOUNT = 100.0;
    public static final Double MAX_MONEY_AMOUNT= 1000.0;
    public static final Double CREDIT_LIMIT = -50.0;

    private Double moneyCount;

    public Wallet() {
        this.moneyCount = DEFAULT_MONEY_AMOUNT;
    }

    public Double getMoneyCount() {
        return moneyCount;
    }

    public void setMoneyCount(Double moneyCount) {
        this.moneyCount = moneyCount;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "moneyCount=" + moneyCount +
                '}';
    }
}