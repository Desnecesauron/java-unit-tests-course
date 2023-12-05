package br.com.desnecesauron.javaunittestscourse;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArraysCompareTest {

    @Test
    void testArraySort_RandomArray() {
        int[] numbers = {12, 3, 4, 1};
        int[] expected = {1, 3, 4, 12};
        Arrays.sort(numbers);
        assertArrayEquals(expected, numbers);
    }

    @Test
//    @Timeout(1)
    @Timeout(value = 15, unit = TimeUnit.MILLISECONDS)
    void testSortPerformance() {
        int[] array = {12, 23, 4};
        for (int i = 0; i < 1000000000; i++) {
            array[0] = i;
            Arrays.sort(array);
        }

    }
}
