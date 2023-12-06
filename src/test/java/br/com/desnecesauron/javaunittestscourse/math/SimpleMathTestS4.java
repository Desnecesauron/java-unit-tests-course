package br.com.desnecesauron.javaunittestscourse.math;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Math Operations Section 4")
public class SimpleMathTestS4 {

    SimpleMath mathInstance;

    @BeforeEach
    void beforeEachMethod() {
        mathInstance = new SimpleMath();
        System.out.println("Running @BeforeEach method");
    }

    @DisplayName("Test double division [firstNumber, secondNumber, expected]")
    @ParameterizedTest
    //@MethodSource("testDivisionInputParameters")
    //@MethodSource()
    //@CsvSource({"5, 10, 0.5", "6.2, 2, 3.1", "71, 14, 5.07", "18.3, 3.1, 5.9", "10, 5, 2", "10, 2, 5", "10, 0.5, 20"})
    // Example of CSV passing strings
    /*@CsvSource({
            "Pelé, Football",
            "Senna, F1",
            "Falcão, ''",
    })*/
    @CsvFileSource(resources = "/testDivision.csv")
    public void testDivision(double firstNumber, double secondNumber, double expResult) {
        System.out.println("division");
        Double result = mathInstance.division(firstNumber, secondNumber);
        assertEquals(expResult, result, 1D, () -> firstNumber + "/" + secondNumber + " didn't produce " + expResult + "!");
        assertNotNull(result, "The division is null!");
    }

    //public static Stream<Arguments> testDivisionInputParameters() {
    public static Stream<Arguments> testDivision() {
        return Stream.of(
                Arguments.of(5D, 10D, 0.5D),
                Arguments.of(6.2D, 2D, 3.1D),
                Arguments.of(71D, 14D, 5.07D),
                Arguments.of(18.3D, 3.1D, 5.9D),
                Arguments.of(10D, 5D, 2D),
                Arguments.of(10D, 2D, 5D),
                Arguments.of(10D, 0.5D, 20D)
        );
    }

}
