package structure;

import domain.ListADT;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pruebas para DoublyLinkedList")
class DoublyLinkedListTest {

    private ListADT<String> list;

    @BeforeEach
    void setUp() {
        list = new DoublyLinkedList<>();
    }

    @Test
    @DisplayName("Nueva DoublyLinkedList debe estar vacía")
    void testNewListIsEmpty() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    @DisplayName("Add agrega elemento a la lista")
    void testAddElement() {
        list.add("primero");
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
    }

    @Test
    @DisplayName("GetLast devuelve último elemento")
    void testGetLastElement() {
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals("C", list.getLast());
    }

    @Test
    @DisplayName("RemoveLast remueve y devuelve último")
    void testRemoveLastElement() {
        list.add("uno");
        list.add("dos");
        list.add("tres");
        assertEquals("tres", list.removeLast());
        assertEquals(2, list.size());
        assertEquals("dos", list.getLast());
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
        list.add("x");
        assertEquals(1, list.size());
        list.add("y");
        list.add("z");
        assertEquals(3, list.size());
        list.removeLast();
        assertEquals(2, list.size());
    }

    @Test
    @DisplayName("Múltiples adiciones")
    void testMultipleAdditions() {
        for (int i = 0; i < 10; i++) {
            list.add("elemento" + i);
        }
        assertEquals(10, list.size());
        assertEquals("elemento9", list.getLast());
    }

    @Test
    @DisplayName("Remover todos elementos")
    void testRemoveAllElements() {
        list.add("1");
        list.add("2");
        list.add("3");
        
        list.removeLast();
        list.removeLast();
        list.removeLast();
        
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    @DisplayName("Un solo elemento")
    void testSingleElement() {
        list.add("único");
        assertEquals(1, list.size());
        assertEquals("único", list.getLast());
        assertEquals("único", list.removeLast());
        assertTrue(list.isEmpty());
    }

    @Test
    @DisplayName("DoublyLinkedList con null")
    void testListWithNull() {
        list.add(null);
        assertNull(list.getLast());
        assertNull(list.removeLast());
        assertTrue(list.isEmpty());
    }
}
