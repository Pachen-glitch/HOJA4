import domain.Stack;
import service.InfixToPostfixConverter;
import service.PostfixEvaluator;
import structure.ArrayListStack;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pruebas de Integración: Conversión + Evaluación")
class IntegrationTest {

    @Test
    @DisplayName("Integración: 2+3 -> 2 3 + -> 5")
    void testIntegration1() {
        // Paso 1: Convertir infix a postfix
        Stack<Character> charStack = new ArrayListStack<>();
        String postfix = InfixToPostfixConverter.convert("2+3", charStack);
        assertEquals("2 3 +", postfix);
        
        // Paso 2: Evaluar la expresión postfix
        Stack<Double> doubleStack = new ArrayListStack<>();
        double result = PostfixEvaluator.evaluate(postfix, doubleStack);
        assertEquals(5.0, result);
    }

    @Test
    @DisplayName("Integración: 2+3*4 -> 2 3 4 * + -> 14")
    void testIntegration2() {
        Stack<Character> charStack = new ArrayListStack<>();
        String postfix = InfixToPostfixConverter.convert("2+3*4", charStack);
        assertEquals("2 3 4 * +", postfix);
        
        Stack<Double> doubleStack = new ArrayListStack<>();
        double result = PostfixEvaluator.evaluate(postfix, doubleStack);
        assertEquals(14.0, result);
    }

    @Test
    @DisplayName("Integración: (2+3)*4 -> 2 3 + 4 * -> 20")
    void testIntegration3() {
        Stack<Character> charStack = new ArrayListStack<>();
        String postfix = InfixToPostfixConverter.convert("(2+3)*4", charStack);
        assertEquals("2 3 + 4 *", postfix);
        
        Stack<Double> doubleStack = new ArrayListStack<>();
        double result = PostfixEvaluator.evaluate(postfix, doubleStack);
        assertEquals(20.0, result);
    }

    @Test
    @DisplayName("Integración: 10-5+3 = 8")
    void testIntegration4() {
        Stack<Character> charStack = new ArrayListStack<>();
        String postfix = InfixToPostfixConverter.convert("10-5+3", charStack);
        
        Stack<Double> doubleStack = new ArrayListStack<>();
        double result = PostfixEvaluator.evaluate(postfix, doubleStack);
        assertEquals(8.0, result);
    }

    @Test
    @DisplayName("Integración: 100/10*2 = 20")
    void testIntegration5() {
        Stack<Character> charStack = new ArrayListStack<>();
        String postfix = InfixToPostfixConverter.convert("100/10*2", charStack);
        
        Stack<Double> doubleStack = new ArrayListStack<>();
        double result = PostfixEvaluator.evaluate(postfix, doubleStack);
        assertEquals(20.0, result);
    }

    @Test
    @DisplayName("Integración: (5+3)*(2+1) = 24")
    void testIntegration6() {
        Stack<Character> charStack = new ArrayListStack<>();
        String postfix = InfixToPostfixConverter.convert("(5+3)*(2+1)", charStack);
        
        Stack<Double> doubleStack = new ArrayListStack<>();
        double result = PostfixEvaluator.evaluate(postfix, doubleStack);
        assertEquals(24.0, result);
    }

    @Test
    @DisplayName("Integración: 2^3+4*5 = 28")
    void testIntegration7() {
        Stack<Character> charStack = new ArrayListStack<>();
        String postfix = InfixToPostfixConverter.convert("2^3+4*5", charStack);
        
        Stack<Double> doubleStack = new ArrayListStack<>();
        double result = PostfixEvaluator.evaluate(postfix, doubleStack);
        assertEquals(28.0, result);
    }

    @Test
    @DisplayName("Integración: ((5+5)*2)+10 = 30")
    void testIntegration8() {
        Stack<Character> charStack = new ArrayListStack<>();
        String postfix = InfixToPostfixConverter.convert("((5+5)*2)+10", charStack);
        
        Stack<Double> doubleStack = new ArrayListStack<>();
        double result = PostfixEvaluator.evaluate(postfix, doubleStack);
        assertEquals(30.0, result);
    }
}
