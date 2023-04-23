package org.example.ex08;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountManagerTest {
    private ExchangeService exchangeService;
    private AccountManager accountManager;

    @BeforeEach
    public void setUp() {
        exchangeService = mock();
        accountManager = new AccountManager(exchangeService);
    }

    @Test
    public void testGetCurrentValueInPLN() {
        Account account = new Account(100, "USD");

        when(exchangeService.getExchangeRate("USD")).thenReturn(4.2);

        int expectedValue = 420;
        int actualValue = accountManager.getCurrentValueInPLN(account);

        assertEquals(expectedValue, actualValue);
    }
}
