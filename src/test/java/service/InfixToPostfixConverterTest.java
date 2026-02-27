package service;

import domain.Stack;
import structure.ArrayListStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pruebas para InfixToPostfixConverter")
class InfixToPostfixConverterTest {

    private Stack<Character> stack;

    @BeforeEach
    void setUp() {
        stack = new ArrayListStack<>();
    }

    @Test
    @DisplayName("Conversión simple: 2+3")
    void testSimpleAddition() {
        String result = InfixToPostfixConverter.convert("2+3", stack);
        assertEquals("2 3 +", result);
    }

    @Test
    @DisplayName("Conversión simple: 2*3")
    void testSimpleMultiplication() {
        stack = new ArrayListStack<>();
        String result = InfixToPostfixConverter.convert("2*3", stack);
        assertEquals("2 3 *", result);
    }

    @Test
    @DisplayName("Precedencia: 2+3*4 = 2 3 4 * +")
    void testOperatorPrecedence() {
        stack = new ArrayListStack<>();
        String result = InfixToPostfixConverter.convert("2+3*4", stack);
        assertEquals("2 3 4 * +", result);
    }

    @Test
    @DisplayName("Precedencia: 2*3+4 = 2 3 * 4 +")
    void testOperatorPrecedenceMultFirst() {
        stack = new ArrayListStack<>();
        String result = InfixToPostfixConverter.convert("2*3+4", stack);
        assertEquals("2 3 * 4 +", result);
    }

    @Test
    @DisplayName("Paréntesis: (2+3)*4 = 2 3 + 4 *")
    void testParentheses() {
        stack = new ArrayListStack<>();
        String result = InfixToPostfixConverter.convert("(2+3)*4", stack);
        assertEquals("2 3 + 4 *", result);
    }

    @Test
    @DisplayName("Paréntesis anidados: ((2+3)*4)")
    void testNestedParentheses() {
        stack = new ArrayListStack<>();
        String result = InfixToPostfixConverter.convert("((2+3)*4)", stack);
        assertEquals("2 3 + 4 *", result);
    }

    @Test
    @DisplayName("Números de múltiples dígitos: 12+34")
    void testMultiDigitNumbers() {
        stack = new ArrayListStack<>();
        String result = InfixToPostfixConverter.convert("12+34", stack);
        assertEquals("12 34 +", result);
    }

    @Test
    @DisplayName("Resta: 10-5")
    void testSubtraction() {
        stack = new ArrayListStack<>();
        String result = InfixToPostfixConverter.convert("10-5", stack);
        assertEquals("10 5 -", result);
    }

    @Test
    @DisplayName("División: 20/5")
    void testDivision() {
        stack = new ArrayListStack<>();
        String result = InfixToPostfixConverter.convert("20/5", stack);
        assertEquals("20 5 /", result);
    }

    @Test
    @DisplayName("Potencia: 2^3")
    void testExponentiation() {
        stack = new ArrayListStack<>();
        String result = InfixToPostfixConverter.convert("2^3", stack);
        assertEquals("2 3 ^", result);
    }

    @Test
    @DisplayName("Expresión compleja: 3+4*2/(1-5)")
    void testComplexExpression() {
        stack = new ArrayListStack<>();
        String result = InfixToPostfixConverter.convert("3+4*2/(1-5)", stack);
        assertEquals("3 4 2 * 1 5 - / +", result);
    }

    @Test
    @DisplayName("Con espacios: 2 + 3 * 4")
    void testWithSpaces() {
        stack = new ArrayListStack<>();
        String result = InfixToPostfixConverter.convert("2 + 3 * 4", stack);
        assertEquals("2 3 4 * +", result);
    }

    @Test
    @DisplayName("Un solo número: 42")
    void testSingleNumber() {
        stack = new ArrayListStack<>();
        String result = InfixToPostfixConverter.convert("42", stack);
        assertEquals("42", result);
    }

    @Test
    @DisplayName("Múltiples operadores iguales: 1+2+3")
    void testMultipleSameOperators() {
        stack = new ArrayListStack<>();
        String result = InfixToPostfixConverter.convert("1+2+3", stack);
        assertEquals("1 2 + 3 +", result);
    }

    @Test
    @DisplayName("Expresión con todas las operaciones: 5+3*2-8/4^2")
    void testAllOperations() {
        stack = new ArrayListStack<>();
        String result = InfixToPostfixConverter.convert("5+3*2-8/4^2", stack);
        assertEquals("5 3 2 * + 8 4 2 ^ / -", result);
    }
}
