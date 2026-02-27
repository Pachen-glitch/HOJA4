package structure;

import domain.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pruebas para ArrayListStack")
class ArrayListStackTest {

    private Stack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new ArrayListStack<>();
    }

    @Test
    @DisplayName("Nuevo stack debe estar vacío")
    void testNewStackIsEmpty() {
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    @DisplayName("Push agrega elemento al stack")
    void testPushAddElement() {
        stack.push(5);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
    }

    @Test
    @DisplayName("Peek devuelve elemento sin remover")
    void testPeekDoesNotRemove() {
        stack.push(10);
        assertEquals(10, stack.peek());
        assertEquals(1, stack.size());
    }

    @Test
    @DisplayName("Pop remueve y devuelve elemento")
    void testPopRemovesElement() {
        stack.push(20);
        stack.push(30);
        assertEquals(30, stack.pop());
        assertEquals(1, stack.size());
        assertEquals(20, stack.peek());
    }

    @Test
    @DisplayName("Stack LIFO - Last In First Out")
    void testStackLIFO() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    @DisplayName("Pop en stack vacío lanza excepción")
    void testPopEmptyStackThrowsException() {
        assertThrows(RuntimeException.class, () -> stack.pop());
    }

    @Test
    @DisplayName("Peek en stack vacío lanza excepción")
    void testPeekEmptyStackThrowsException() {
        assertThrows(RuntimeException.class, () -> stack.peek());
    }

    @Test
    @DisplayName("Size retorna cantidad correcta de elementos")
    void testSizeAccuracy() {
        assertEquals(0, stack.size());
        stack.push(1);
        assertEquals(1, stack.size());
        stack.push(2);
        assertEquals(2, stack.size());
        stack.pop();
        assertEquals(1, stack.size());
    }

    @Test
    @DisplayName("Stack maneja múltiples operaciones")
    void testMultipleOperations() {
        stack.push(100);
        stack.push(200);
        stack.push(300);
        
        assertFalse(stack.isEmpty());
        assertEquals(3, stack.size());
        assertEquals(300, stack.pop());
        assertEquals(200, stack.peek());
        assertEquals(2, stack.size());
    }

    @Test
    @DisplayName("Stack con null values")
    void testStackWithNull() {
        Stack<Integer> nullStack = new ArrayListStack<>();
        nullStack.push(null);
        assertNull(nullStack.peek());
        assertNull(nullStack.pop());
    }
}
