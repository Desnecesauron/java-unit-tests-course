package br.com.desnecesauron.javaunittestscourse.mockito.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;

public class OrderServiceTest {

    OrderService orderService = new OrderService();
    UUID defaultUUID = UUID.fromString("c9a646d7-ff7f-4a9e-8e1c-5d8c0f1c94a3");

    @DisplayName("Should include random orderId when no orderId exists")
    @Test
    void testShouldIncludeRandomOrderId_When_NoOrderIdExists() {
        // Given / Arrange
//        OrderService orderService = new OrderService();

        try (MockedStatic<UUID> mockedUUIDstatic = mockStatic(UUID.class)) {
            mockedUUIDstatic.when(UUID::randomUUID).thenReturn(defaultUUID);

            // When / Act
            Order order = orderService.createOrder("Macbook", 1L, null);

            // Then / Assert
            assertEquals(defaultUUID.toString(), order.getId());
        }


    }
}
