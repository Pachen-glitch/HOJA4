package structure;

import domain.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pruebas para VectorStack")
class VectorStackTest {

    private Stack<String> stack;

    @BeforeEach
    void setUp() {
        stack = new VectorStack<>();
    }

    @Test
    @DisplayName("Nuevo VectorStack debe estar vacío")
    void testNewStackIsEmpty() {
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    @DisplayName("Push agrega elemento al VectorStack")
    void testPushAddElement() {
        stack.push("hello");
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
    }

    @Test
    @DisplayName("Peek devuelve elemento sin remover")
    void testPeekDoesNotRemove() {
        stack.push("world");
        assertEquals("world", stack.peek());
        assertEquals(1, stack.size());
    }

    @Test
    @DisplayName("Pop remueve y devuelve elemento")
    void testPopRemovesElement() {
        stack.push("first");
        stack.push("second");
        assertEquals("second", stack.pop());
        assertEquals(1, stack.size());
        assertEquals("first", stack.peek());
    }

    @Test
    @DisplayName("VectorStack LIFO")
    void testStackLIFO() {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        
        assertEquals("C", stack.pop());
        assertEquals("B", stack.pop());
        assertEquals("A", stack.pop());
    }

    @Test
    @DisplayName("Pop en VectorStack vacío lanza excepción")
    void testPopEmptyStackThrowsException() {
        assertThrows(RuntimeException.class, () -> stack.pop());
    }

    @Test
    @DisplayName("Peek en VectorStack vacío lanza excepción")
    void testPeekEmptyStackThrowsException() {
        assertThrows(RuntimeException.class, () -> stack.peek());
    }

    @Test
    @DisplayName("Size retorna cantidad correcta")
    void testSizeAccuracy() {
        assertEquals(0, stack.size());
        stack.push("one");
        assertEquals(1, stack.size());
        stack.push("two");
        stack.push("three");
        assertEquals(3, stack.size());
        stack.pop();
        assertEquals(2, stack.size());
    }

    @Test
    @DisplayName("VectorStack con múltiples operaciones")
    void testMultipleOperations() {
        stack.push("push1");
        stack.push("push2");
        stack.push("push3");
        
        assertFalse(stack.isEmpty());
        assertEquals(3, stack.size());
        assertEquals("push3", stack.pop());
        assertEquals("push2", stack.peek());
        assertEquals(2, stack.size());
        assertEquals("push2", stack.pop());
        assertEquals("push1", stack.peek());
    }

    @Test
    @DisplayName("VectorStack con valores duplicados")
    void testDuplicateValues() {
        stack.push("duplicate");
        stack.push("duplicate");
        stack.push("duplicate");
        
        assertEquals(3, stack.size());
        assertEquals("duplicate", stack.pop());
        assertEquals("duplicate", stack.pop());
        assertEquals("duplicate", stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    @DisplayName("VectorStack con null")
    void testVectorStackWithNull() {
        stack.push(null);
        assertNull(stack.peek());
        assertNull(stack.pop());
        assertTrue(stack.isEmpty());
    }
}
