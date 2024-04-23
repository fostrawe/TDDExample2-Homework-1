
// B211202011
// FURKAN ÇELEBİ
// SWE 202 SOFTWARE VERIFICATION AND VALIDATION 2023-2024 SPRING SEMESTER HOMEWORK 1
// https://github.com/fostrawe/SVV-HOMEWORK1

package org.example;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {



    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    @ParameterizedTest
    @MethodSource("divisionValues")
    void testDivision(float dividend, float divisor, float expected) {
        assertEquals(expected, Calculator.divide(dividend, divisor));
    }


    static Object[][] divisionValues() {
        return new Object[][]{
                {10f, 2f, 5f},
                {10f, 4f, 2.5f},
                {12.5f, 2.5f, 5f},
                {10f, 2.5f, 4f},
                {12.5f, 5f, 2.5f}
        };
    }



    @Test
    void testDivisionByZero() {
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> Calculator.divide(12.5f, 0),
                "IllegalArgumentException expected."
        );


        assertEquals("Illegal Argument Exception.", exception.getMessage());
    }

}
