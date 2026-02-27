package structure;

import domain.ListADT;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pruebas para SinglyLinkedList")
class SinglyLinkedListTest {

    private ListADT<Integer> list;

    @BeforeEach
    void setUp() {
        list = new SinglyLinkedList<>();
    }

    @Test
    @DisplayName("Nueva lista debe estar vacía")
    void testNewListIsEmpty() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    @DisplayName("Add agrega elemento a la lista")
    void testAddElement() {
        list.add(5);
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
    }

    @Test
    @DisplayName("GetLast devuelve último elemento")
    void testGetLastElement() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.getLast());
    }

    @Test
    @DisplayName("RemoveLast remueve y devuelve último")
    void testRemoveLastElement() {
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(30, list.removeLast());
        assertEquals(2, list.size());
        assertEquals(20, list.getLast());
    }

    @Test
    @DisplayName("RemoveLast en lista vacía lanza excepción")
    void testRemoveLastEmptyListThrowsException() {
        assertThrows(RuntimeException.class, () -> list.removeLast());
    }

    @Test
    @DisplayName("GetLast en lista vacía lanza excepción")
    void testGetLastEmptyListThrowsException() {
        assertThrows(RuntimeException.class, () -> list.getLast());
    }

    @Test
    @DisplayName("Size retorna cantidad correcta")
    void testSizeAccuracy() {
        assertEquals(0, list.size());
        list.add(1);
        assertEquals(1, list.size());
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
        list.removeLast();
        assertEquals(2, list.size());
    }

    @Test
    @DisplayName("Lista maneja múltiples adiciones")
    void testMultipleAdditions() {
        for (int i = 1; i <= 5; i++) {
            list.add(i * 10);
        }
        assertEquals(5, list.size());
        assertEquals(50, list.getLast());
    }

    @Test
    @DisplayName("Remover todos los elementos")
    void testRemoveAllElements() {
        list.add(1);
        list.add(2);
        list.add(3);
        
        list.removeLast();
        list.removeLast();
        list.removeLast();
        
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    @DisplayName("Lista con un solo elemento")
    void testSingleElement() {
        list.add(99);
        assertEquals(1, list.size());
        assertEquals(99, list.getLast());
        assertEquals(99, list.removeLast());
        assertTrue(list.isEmpty());
    }

    @Test
    @DisplayName("Lista con valores null")
    void testListWithNull() {
        list.add(null);
        assertNull(list.getLast());
        assertNull(list.removeLast());
        assertTrue(list.isEmpty());
    }
}
