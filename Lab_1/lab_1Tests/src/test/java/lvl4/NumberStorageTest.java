package lvl4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberStorageTest {
    private NumberStorage storage;

    @BeforeEach
    void setUp() {
        storage = new NumberStorage();
    }

    @AfterEach
    void tearDown() {
        storage = null;
    }

    @Test
    void testAddNumber_Positive() {
        storage.addNumber(10);
        assertEquals(1, storage.getNumbers().size());
    }

    @Test
    void testRemoveNumber_Positive() {
        storage.addNumber(5);
        storage.addNumber(10);
        storage.removeNumber(10);
        assertEquals(1, storage.getNumbers().size());
    }
    @Test
    void testRemoveNumber_Negative() {
        storage.addNumber(5);
        Exception exception = assertThrows(ValueExistException.class, () ->
                storage.removeNumber(10));
        assertEquals("Такого значения нет", exception.getMessage());
    }

    @Test
    void testFindClosestNumber_Positive() {
        storage.addNumber(5);
        storage.addNumber(8);
        storage.addNumber(12);
        storage.addNumber(15);

        assertEquals(8, storage.findClosestNumber(7));
    }

    @Test
    void testFindClosestNumber_Negative() {
        Exception exception = assertThrows(ValueExistException.class, () ->
                storage.findClosestNumber(10));
        assertEquals("Список пуст", exception.getMessage());
    }

}
