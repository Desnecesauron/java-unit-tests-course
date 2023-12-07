package br.com.desnecesauron.javaunittestscourse.math;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DemoRepeatedTest {

    SimpleMath mathInstance;

    @BeforeEach
    void beforeEachMethod() {
        mathInstance = new SimpleMath();
        System.out.println("Running @BeforeEach method");
    }

    @RepeatedTest(value = 3, name = "{displayName} - repetition {currentRepetition}/{totalRepetitions}")
    @DisplayName("Test 5/0 = impossible to divide by zero!")
    public void testDivision_WhenDividingByZero_ShouldReturnNull(RepetitionInfo repetitionInfo, TestInfo testInfo){
        System.out.println("division by zero");
        System.out.println("Current repetition: " + repetitionInfo.getCurrentRepetition() + "/" + repetitionInfo.getTotalRepetitions());
        System.out.println("Running " + testInfo.getTestMethod().get().getName() + " with tags " + testInfo.getTags());
        Double firstNumber = 5.0;
        Double secondNumber = 0.0;
        String expResult = "Impossible to divide by zero!";
        ArithmeticException result = assertThrows(ArithmeticException.class, () -> {
            mathInstance.division(firstNumber, secondNumber);
        }, firstNumber + "/" + secondNumber + " didn't produce ArithmeticException" + "!");
        assertEquals(expResult, result.getMessage(), () -> firstNumber + "/" + secondNumber + " didn't produce \"" + expResult + "\"!");
    }

}
