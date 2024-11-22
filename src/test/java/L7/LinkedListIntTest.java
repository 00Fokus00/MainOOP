package L7;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.vsu.L7.ExampleLinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListIntTest {
    static ExampleLinkedList<Integer> list = new ExampleLinkedList<>();

    @BeforeAll
    static void setUp() {
        createList();
    }

    private static void createList() {
        list.add(2);
        list.add(4);
        list.add(8);
    }

    @Test
    void addTest(){
        assertEquals(list.getSize(), 3);
        assertEquals(list.getHead().getValue(), 2);
        assertEquals(list.getTail().getValue(), 8);
    }

    @Test
    void findByValueTest(){
        assertEquals(list.findByValue(2).getValue(), list.getHead().getValue());
        assertEquals(list.findByValue(4).getValue(), 4);
        assertEquals(list.findByValue(8).getValue(), list.getTail().getValue());
    }

    @Test
    void deleteTest(){
        list.delete(2);
        assertEquals(list.getSize(), 2);
        assertEquals(list.getHead().getValue(), 4);
        list.delete();
        assertEquals(list.getSize(), 1);
        assertEquals(list.getTail().getValue(), 4);
    }
}
