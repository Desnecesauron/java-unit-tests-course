package br.com.desnecesauron.javaunittestscourse.mockito.service;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MockitoSpyTest {

    // Spy is a partial mock, it will call the real methods of the class unless we specify otherwise
    // Difference between Mock and Spy
    // Mock: does not call the real methods of the class
    // Spy: calls the real methods of the class unless we specify otherwise

    @Test
    void testV1() {
        // Given / Arrange
        List<String> mockArrayList = mock(ArrayList.class);

        // When / Act && Then / Assert
        assertEquals(0, mockArrayList.size());

        when(mockArrayList.size()).thenReturn(5);
        mockArrayList.add("Cesar");
        assertEquals(5, mockArrayList.size());
    }

    @Test
    void testV2() {
        // Given / Arrange
        List<String> spyArrayList = spy(ArrayList.class);

        // When / Act && Then / Assert
        assertEquals(0, spyArrayList.size());

        spyArrayList.add("Cesar");
        assertEquals(1, spyArrayList.size());

        spyArrayList.remove("Cesar");
        assertEquals(0, spyArrayList.size());
    }

    @Test
    void testV3() {
        // Given / Arrange
        List<String> spyArrayList = spy(ArrayList.class);

        // When / Act && Then / Assert
        assertEquals(0, spyArrayList.size());

        when(spyArrayList.size()).thenReturn(5);
        assertEquals(5, spyArrayList.size());
    }

    @Test
    void testV4() {
        // Given / Arrange
        List<String> spyArrayList = spy(ArrayList.class);

        spyArrayList.add("Cesar");

        verify(spyArrayList).add("Cesar");
        verify(spyArrayList, never()).remove("Cesar");
        verify(spyArrayList, never()).remove(anyString());
        verify(spyArrayList, never()).clear();

        assertEquals(1, spyArrayList.size());
    }
}
