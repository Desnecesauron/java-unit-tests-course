package br.com.desnecesauron.javaunittestscourse.mockito.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mockStatic;

public class MyUtilsTest {

    @Test
    void shouldMockStaticMethodWithParams() {
        // Given / Arrange
        // When / Act
        // Then / Assert
        try (MockedStatic<MyUtils> mocked = mockStatic(MyUtils.class)) {
            mocked.when(() -> MyUtils.getWelcomeMessage(eq("Cesar"), anyBoolean())).thenReturn("Welcome Cesar");

            String welcomeMessage = MyUtils.getWelcomeMessage("Cesar", false);
            Assertions.assertEquals("Welcome Cesar", welcomeMessage);
        }
    }
}
