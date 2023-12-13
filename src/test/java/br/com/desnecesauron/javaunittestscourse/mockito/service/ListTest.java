package br.com.desnecesauron.javaunittestscourse.mockito.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturn10() {
        // Given / Arrange
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(10);
        // When / Act
        int size = listMock.size();
        // Then / Assert
        assertEquals(10, size);
    }

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturnMultipleValues() {
        // Given / Arrange
        List listMock = mock(List.class);

        // is possible to chain the when() method to return different values in different calls!
        when(listMock.size()).thenReturn(10).thenReturn(20);

        // When / Act && Then / Assert
        assertEquals(10, listMock.size());
        assertEquals(20, listMock.size());
        assertEquals(20, listMock.size());
    }

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturnCesar() {
        // Given / Arrange
        List listMock = mock(List.class);

        // is possible to chain the when() method to return different values in different calls!
        when(listMock.get(0)).thenReturn("Cesar");

        // When / Act && Then / Assert
        assertEquals("Cesar", listMock.get(0));
        assertNull(listMock.get(1));
    }

    @Test
    void testMockingList_When_GetIsCalledWithArgumentMatcher_ShouldReturnCesar() {
        // Given / Arrange
        List listMock = mock(List.class);

        // is possible to chain the when() method to return different values in different calls!
        when(listMock.get(anyInt())).thenReturn("Cesar");

        // When / Act && Then / Assert
        assertEquals("Cesar", listMock.get(anyInt()));
        assertEquals("Cesar", listMock.get(anyInt()));
    }

    @Test
    void testMockingList_When_ThrowsAnException() {
        // Given / Arrange
        List listMock = mock(List.class);

        // is possible to chain the when() method to return different values in different calls!
        when(listMock.get(anyInt())).thenThrow(new RuntimeException("Foo Bar"));

        // When / Act && Then / Assert
        assertThrows(RuntimeException.class, () -> listMock.get(anyInt()),
                () -> "Should have thrown an RuntimeException");
    }

}
