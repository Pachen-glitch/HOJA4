package service;

import domain.Stack;
import structure.ArrayListStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pruebas para PostfixEvaluator")
class PostfixEvaluatorTest {

    private Stack<Double> stack;

    @BeforeEach
    void setUp() {
        stack = new ArrayListStack<>();
    }

    @Test
    @DisplayName("Evaluación suma: 2 3 + = 5")
    void testEvaluateAddition() {
        stack = new ArrayListStack<>();
        double result = PostfixEvaluator.evaluate("2 3 +", stack);
        assertEquals(5.0, result);
    }

    @Test
    @DisplayName("Evaluación resta: 10 5 - = 5")
    void testEvaluateSubtraction() {
        stack = new ArrayListStack<>();
        double result = PostfixEvaluator.evaluate("10 5 -", stack);
        assertEquals(5.0, result);
    }

    @Test
    @DisplayName("Evaluación multiplicación: 3 4 * = 12")
    void testEvaluateMultiplication() {
        stack = new ArrayListStack<>();
        double result = PostfixEvaluator.evaluate("3 4 *", stack);
        assertEquals(12.0, result);
    }

    @Test
    @DisplayName("Evaluación división: 20 5 / = 4")
    void testEvaluateDivision() {
        stack = new ArrayListStack<>();
        double result = PostfixEvaluator.evaluate("20 5 /", stack);
        assertEquals(4.0, result);
    }

    @Test
    @DisplayName("Evaluación potencia: 2 3 ^ = 8")
    void testEvaluateExponentiation() {
        stack = new ArrayListStack<>();
        double result = PostfixEvaluator.evaluate("2 3 ^", stack);
        assertEquals(8.0, result);
    }

    @Test
    @DisplayName("Expresión: 2 3 4 * + = 14")
    void testEvaluateExpression1() {
        stack = new ArrayListStack<>();
        double result = PostfixEvaluator.evaluate("2 3 4 * +", stack);
        assertEquals(14.0, result);
    }

    @Test
    @DisplayName("Expresión: 2 3 + 4 * = 20")
    void testEvaluateExpression2() {
        stack = new ArrayListStack<>();
        double result = PostfixEvaluator.evaluate("2 3 + 4 *", stack);
        assertEquals(20.0, result);
    }

    @Test
    @DisplayName("Expresión: 10 5 - 3 * = 15")
    void testEvaluateExpression3() {
        stack = new ArrayListStack<>();
        double result = PostfixEvaluator.evaluate("10 5 - 3 *", stack);
        assertEquals(15.0, result);
    }

    @Test
    @DisplayName("Expresión: 15 7 1 1 + - / 3 * 2 1 1 + + - = 5")
    void testEvaluateComplexExpression() {
        stack = new ArrayListStack<>();
        double result = PostfixEvaluator.evaluate("15 7 1 1 + - / 3 * 2 1 1 + + -", stack);
        assertEquals(5.0, result);
    }

    @Test
    @DisplayName("Un solo número: 42 = 42")
    void testEvaluateSingleNumber() {
        stack = new ArrayListStack<>();
        double result = PostfixEvaluator.evaluate("42", stack);
        assertEquals(42.0, result);
    }

    @Test
    @DisplayName("Resultado decimal: 10 3 / ≈ 3.333")
    void testEvaluateDecimal() {
        stack = new ArrayListStack<>();
        double result = PostfixEvaluator.evaluate("10 3 /", stack);
        assertEquals(10.0 / 3.0, result, 0.0001);
    }

    @Test
    @DisplayName("Números de múltiples dígitos: 123 45 + = 168")
    void testEvaluateMultiDigitNumbers() {
        stack = new ArrayListStack<>();
        double result = PostfixEvaluator.evaluate("123 45 +", stack);
        assertEquals(168.0, result);
    }

    @Test
    @DisplayName("Expresión del ejercicio: 3 4 2 * + = 11")
    void testEvaluateExerciseExpression() {
        stack = new ArrayListStack<>();
        double result = PostfixEvaluator.evaluate("3 4 2 * +", stack);
        assertEquals(11.0, result);
    }

    @Test
    @DisplayName("Resta con números negativos: 5 5 - 3 + = 3")
    void testEvaluateNegativeResult() {
        stack = new ArrayListStack<>();
        double result = PostfixEvaluator.evaluate("5 5 - 3 +", stack);
        assertEquals(3.0, result);
    }

    @Test
    @DisplayName("Múltiples operadores: 1 2 + 3 + 4 + = 10")
    void testEvaluateMultipleAdditions() {
        stack = new ArrayListStack<>();
        double result = PostfixEvaluator.evaluate("1 2 + 3 + 4 +", stack);
        assertEquals(10.0, result);
    }
}
