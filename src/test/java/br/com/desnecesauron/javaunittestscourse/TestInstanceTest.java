package br.com.desnecesauron.javaunittestscourse;

import org.junit.jupiter.api.*;


//@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestInstanceTest {

    StringBuilder actualValue = new StringBuilder();

    @AfterEach
    void afterEachMethod() {
        System.out.println("The actual value is: " + actualValue);
    }

    @Test
    @Order(3)
    void testC() {
        System.out.println("testC");
        actualValue.append("C");
    }

    @Test
    @Order(1)
    void testB() {
        System.out.println("testB");
        actualValue.append("B");
    }

    @Test
    @Order(2)
    void testA() {
        System.out.println("testA");
        actualValue.append("A");
    }

}
