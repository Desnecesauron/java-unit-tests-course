package br.com.desnecesauron.javaunittestscourse.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleMathTest {

    @Test
    public void sum() {
        System.out.println("sum");
        Double firstNumber = 5.0;
        Double secondNumber = 10.0;
        SimpleMath instance = new SimpleMath();
        Double expResult = 15.0;
        Double result = instance.sum(firstNumber, secondNumber);
        assertEquals(expResult, result, () -> firstNumber + "+" + secondNumber + " didn't produce " + expResult + "!");
        assertNotEquals(14.999996D, result);
        assertNotNull(result, "The sum is null!");
    }

    @Test
    public void subtraction() {
        System.out.println("subtraction");
        Double firstNumber = 5.0;
        Double secondNumber = 10.0;
        SimpleMath instance = new SimpleMath();
        Double expResult = -5.0;
        Double result = instance.subtraction(firstNumber, secondNumber);
        assertEquals(expResult, result, () -> firstNumber + "-" + secondNumber + " didn't produce " + expResult + "!");
        assertNotNull(result, "The subtraction is null!");
    }

    @Test
    public void multiplication() {
        System.out.println("multiplication");
        Double firstNumber = 5.0;
        Double secondNumber = 10.0;
        SimpleMath instance = new SimpleMath();
        Double expResult = 50.0;
        Double result = instance.multiplication(firstNumber, secondNumber);
        assertEquals(expResult, result, () -> firstNumber + "*" + secondNumber + " didn't produce " + expResult + "!");
        assertNotNull(result, "The multiplication is null!");
    }

    @Test
    public void division() {
        System.out.println("division");
        Double firstNumber = 5.0;
        Double secondNumber = 10.0;
        SimpleMath instance = new SimpleMath();
        Double expResult = 0.5;
        Double result = instance.division(firstNumber, secondNumber);
        assertEquals(expResult, result, () -> firstNumber + "/" + secondNumber + " didn't produce " + expResult + "!");
        assertNotNull(result, "The division is null!");
    }

    @Test
    public void average() {
        System.out.println("average");
        Double firstNumber = 5.0;
        Double secondNumber = 10.0;
        SimpleMath instance = new SimpleMath();
        Double expResult = 7.5;
        Double result = instance.average(firstNumber, secondNumber);
        assertEquals(expResult, result, () -> "(" + firstNumber + "+" + secondNumber + ")/2 didn't produce " + expResult + "!");
        assertNotNull(result, "The average is null!");
    }

    @Test
    public void squareRoot() {
        System.out.println("squareRoot");
        Double number = 25.0;
        SimpleMath instance = new SimpleMath();
        Double expResult = 5.0;
        Double result = instance.squareRoot(number);
        assertEquals(expResult, result, () -> "sqrt(" + number + ") didn't produce " + expResult + "!");
        assertNotNull(result, "The square root is null!");
    }
}
