package br.com.desnecesauron.javaunittestscourse.mockito.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class ListBDDTest {

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturn10() {
        // Given / Arrange
        List listMock = mock(List.class);
        given(listMock.size()).willReturn(10);
        // When / Act
        int size = listMock.size();
        // Then / Assert
        assertThat(size, is(10));
    }

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturnMultipleValues() {
        // Given / Arrange
        List listMock = mock(List.class);

        // is possible to chain the when() method to return different values in different calls!
        given(listMock.size()).willReturn(10).willReturn(20);

        // When / Act && Then / Assert
        assertThat(listMock.size(), is(10));
        assertThat(listMock.size(), is(20));
        assertThat(listMock.size(), is(20));
    }

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturnCesar() {
        // Given / Arrange
        List listMock = mock(List.class);

        // is possible to chain the when() method to return different values in different calls!
        given(listMock.get(0)).willReturn("Cesar");

        // When / Act && Then / Assert
        assertThat(listMock.get(0), is("Cesar"));
        assertThat(listMock.get(1), is((String) null));
    }

    @Test
    void testMockingList_When_GetIsCalledWithArgumentMatcher_ShouldReturnCesar() {
        // Given / Arrange
        List listMock = mock(List.class);

        // is possible to chain the when() method to return different values in different calls!
        given(listMock.get(anyInt())).willReturn("Cesar");

        // When / Act && Then / Assert
        assertThat(listMock.get(anyInt()), is("Cesar"));
        assertThat(listMock.get(anyInt()), is("Cesar"));
    }

    @Test
    void testMockingList_When_ThrowsAnException() {
        // Given / Arrange
        List listMock = mock(List.class);

        // is possible to chain the when() method to return different values in different calls!
        given(listMock.get(anyInt())).willThrow(new RuntimeException("Foo Bar"));

        // When / Act && Then / Assert
        assertThrows(RuntimeException.class, () -> listMock.get(anyInt()),
                () -> "Should have thrown an RuntimeException");
    }

}
