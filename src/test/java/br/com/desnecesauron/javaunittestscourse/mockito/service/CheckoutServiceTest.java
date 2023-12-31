package br.com.desnecesauron.javaunittestscourse.mockito.service;

import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;


import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.when;

public class CheckoutServiceTest {

    @Test
    void testMockObjectConstruction() {
        try (MockedConstruction<PaymentProcessor> mocked = mockConstruction(PaymentProcessor.class, (mock, context) -> {
            when(mock.chargeCustomer(anyString(), any(BigDecimal.class))).thenReturn(BigDecimal.TEN);
        })) {
            CheckoutService checkoutService = new CheckoutService();
            BigDecimal result = checkoutService.purchaseProduct("Macbook", "42");

            assertEquals(BigDecimal.TEN, result);
            assertEquals(1, mocked.constructed().size());
        }

    }

}
