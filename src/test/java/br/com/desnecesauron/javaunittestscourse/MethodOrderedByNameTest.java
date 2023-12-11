package br.com.desnecesauron.javaunittestscourse;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

// tests will be executed in alphabetical order by default,
// but you can change this behavior by using the @TestMethodOrder annotation
@TestMethodOrder(MethodOrderer.MethodName.class)
public class MethodOrderedByNameTest {

    @Test
    void testC() {
        System.out.println("testC");
    }

    @Test
    void testB() {
        System.out.println("testB");
    }

    @Test
    void testA() {
        System.out.println("testA");
    }

}
