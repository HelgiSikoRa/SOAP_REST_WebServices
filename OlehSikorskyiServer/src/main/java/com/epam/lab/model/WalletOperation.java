package com.epam.lab.model;

public class WalletOperation {
    Wallet wallet;

    public WalletOperation() {
        wallet = new Wallet();
    }

    public Double checkBalance() {
        return wallet.getMoneyCount();
    }

    public Double withdrawMoney(Double transferAmount) {
        return wallet.getMoneyCount() - transferAmount;
    }

    public Double refillAccount(Double transferAmount) {
        return wallet.getMoneyCount() + transferAmount;
    }
}
