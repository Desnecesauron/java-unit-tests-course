package br.com.desnecesauron.javaunittestscourse;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.Random.class)
public class MethodOrderedRandonlyTest {

    @Test
    void testA() {
        System.out.println("testA");
    }

    @Test
    void testB() {
        System.out.println("testB");
    }

    @Test
    void testC() {
        System.out.println("testC");
    }
}
