package br.com.desnecesauron.javaunittestscourse;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

// used to define the order of execution of the tests
// the order is defined by the value of the @Order annotation
// if the @Order annotation is not present, the test will be executed last
// this annotation is commonly used in integration tests
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodOrderedByOrderTest {

    @Test
    @Order(3)
    void testC() {
        System.out.println("testC");
    }

    @Test
    @Order(1)
    void testB() {
        System.out.println("testB");
    }

    @Test
    @Order(2)
    void testA() {
        System.out.println("testA");
    }

}
