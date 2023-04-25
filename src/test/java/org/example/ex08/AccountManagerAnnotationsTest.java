package org.example.ex08;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountManagerAnnotationsTest {
    @Mock
    private ExchangeService exchangeService;
    @InjectMocks
    private AccountManager accountManager;

    @Test
    public void testGetCurrentValueInPLN() {
        Account account = new Account(100, "USD");

        when(exchangeService.getExchangeRate("USD")).thenReturn(4.2);

        int expectedValue = 420;
        int actualValue = accountManager.getCurrentValueInPLN(account);

        assertEquals(expectedValue, actualValue);
    }
}
