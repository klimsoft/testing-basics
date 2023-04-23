package org.example.ex08;

import java.time.LocalDate;

public class AccountManager {
    private final ExchangeService exchangeService;

    public AccountManager(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    public int getCurrentValueInPLN(Account account) {
        int amountInPLN = 0;
        double exchangeRate = exchangeService.getExchangeRate(account.getCurrency());

        if (exchangeRate != 0) {
            amountInPLN = (int) Math.round(account.getAmount() * exchangeRate);
        }

        return amountInPLN;
    }
}
