package br.com.desnecesauron.javaunittestscourse.math;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Math Operations")
public class SimpleMathTest {

    SimpleMath mathInstance;

    @BeforeAll
    static void setup() {
        System.out.println("Running @BeforeAll method");
    }

    @AfterAll
    static void cleanup() {
        System.out.println("Running @AfterAll method");
    }

    @BeforeEach
    void beforeEachMethod() {
        mathInstance = new SimpleMath();
        System.out.println("Running @BeforeEach method");
    }

    @AfterEach
    void afterEachMethod() {
        System.out.println("Running @AfterEach method");
    }

    // nomenclatura
    // test[System Under Test]_[Condition or State Change]_[Expected Result]
    @Test
    @DisplayName("Test 5+10 = 15")
    public void testSum_WhenFiveIsAddedByTen_ShouldReturnFifteen() {
        // Given/Arrange, When/Act and Then/Assert -> GWT/AAA[triple A structure]
        // Given / Arrange
        System.out.println("sum");
        Double firstNumber = 5.0;
        Double secondNumber = 10.0;
        Double expResult = 15.0;
        // When / Act
        Double result = mathInstance.sum(firstNumber, secondNumber);
        // Then / Assert
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
        Double expResult = -5.0;
        Double result = mathInstance.subtraction(firstNumber, secondNumber);
        assertEquals(expResult, result, () -> firstNumber + "-" + secondNumber + " didn't produce " + expResult + "!");
        assertNotNull(result, "The subtraction is null!");
    }

    @Test
    @DisplayName("Test 5*10 = 50")
    public void testMultiplication() {
        System.out.println("multiplication");
        Double firstNumber = 5.0;
        Double secondNumber = 10.0;
        Double expResult = 50.0;
        Double result = mathInstance.multiplication(firstNumber, secondNumber);
        assertEquals(expResult, result, () -> firstNumber + "*" + secondNumber + " didn't produce " + expResult + "!");
        assertNotNull(result, "The multiplication is null!");
    }

    @Test
    @DisplayName("Test 5/10 = 0.5")
    public void testDivision() {
        System.out.println("division");
        Double firstNumber = 5.0;
        Double secondNumber = 10.0;
        Double expResult = 0.5;
        Double result = mathInstance.division(firstNumber, secondNumber);
        assertEquals(expResult, result, () -> firstNumber + "/" + secondNumber + " didn't produce " + expResult + "!");
        assertNotNull(result, "The division is null!");
    }

    @Test
    @Disabled("TODO: make this test work")
    @DisplayName("Test ignored")
    public void testIgnored() {
        System.out.println("ignored");
    }


    @Test
    @DisplayName("Test 5/0 = impossible to divide by zero!")
    public void testDivision_WhenDividingByZero_ShouldReturnNull() {
        System.out.println("division by zero");
        Double firstNumber = 5.0;
        Double secondNumber = 0.0;
        String expResult = "Impossible to divide by zero!";
        ArithmeticException result = assertThrows(ArithmeticException.class, () -> {
            mathInstance.division(firstNumber, secondNumber);
        }, firstNumber + "/" + secondNumber + " didn't produce ArithmeticException" + "!");
        assertEquals(expResult, result.getMessage(), () -> firstNumber + "/" + secondNumber + " didn't produce \"" + expResult + "\"!");
    }

    @Test
    @DisplayName("Test (5+10)/2 = 7.5")
    public void testAverage() {
        System.out.println("average");
        Double firstNumber = 5.0;
        Double secondNumber = 10.0;
        Double expResult = 7.5;
        Double result = mathInstance.average(firstNumber, secondNumber);
        assertEquals(expResult, result, () -> "(" + firstNumber + "+" + secondNumber + ")/2 didn't produce " + expResult + "!");
        assertNotNull(result, "The average is null!");
    }

    @Test
    @DisplayName("Test sqrt(25) = 5")
    public void testSquareRoot() {
        System.out.println("squareRoot");
        Double number = 25.0;
        Double expResult = 5.0;
        Double result = mathInstance.squareRoot(number);
        assertEquals(expResult, result, () -> "sqrt(" + number + ") didn't produce " + expResult + "!");
        assertNotNull(result, "The square root is null!");
    }
}
