package br.com.desnecesauron.javaunittestscourse.math;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleMathTest {

    // nomenclatura
    // test[System Under Test]_[Condition or State Change]_[Expected Result]
    @Test
    @DisplayName("Test 5+10 = 15")
    public void testSum_WhenFiveIsAddedByTen_ShouldReturnFifteen() {
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
    @DisplayName("Test 5-10 = -5")
    public void testSubtraction() {
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
    @DisplayName("Test 5*10 = 50")
    public void testMultiplication() {
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
    @DisplayName("Test 5/10 = 0.5")
    public void testDivision() {
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
    @DisplayName("Test 5/0 = null")
    public void testeDivision_WhenDividingByZero_ShouldReturnNull() {
        System.out.println("division");
        Double firstNumber = 5.0;
        Double secondNumber = 0.0;
        SimpleMath instance = new SimpleMath();
        Double expResult = null;
        Double result = instance.division(firstNumber, secondNumber);
        assertEquals(expResult, result, () -> firstNumber + "/" + secondNumber + " didn't produce " + expResult + "!");
        assertNull(result, "The division is not null!");
    }

    @Test
    @DisplayName("Test (5+10)/2 = 7.5")
    public void testAverage() {
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
    @DisplayName("Test sqrt(25) = 5")
    public void testSquareRoot() {
        System.out.println("squareRoot");
        Double number = 25.0;
        SimpleMath instance = new SimpleMath();
        Double expResult = 5.0;
        Double result = instance.squareRoot(number);
        assertEquals(expResult, result, () -> "sqrt(" + number + ") didn't produce " + expResult + "!");
        assertNotNull(result, "The square root is null!");
    }
}
