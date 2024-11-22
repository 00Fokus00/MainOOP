package L7;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.vsu.L7.ExampleLinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListStrTest {
    static ExampleLinkedList<String> list = new ExampleLinkedList<>();

    @BeforeAll
    static void setUp() {
        createList();
    }

    private static void createList() {
        list.add("two");
        list.add("four");
        list.add("eight");
    }

    @Test
    void addTest(){
        assertEquals(list.getSize(), 3);
        assertEquals(list.getHead().getValue(), "two");
        assertEquals(list.getTail().getValue(), "eight");
    }

    @Test
    void findByValueTest(){
        assertEquals(list.findByValue("two").getValue(), list.getHead().getValue());
        assertEquals(list.findByValue("four").getValue(), "four");
        assertEquals(list.findByValue("eight").getValue(), list.getTail().getValue());
    }

    @Test
    void deleteTest(){
        list.delete("two");
        assertEquals(list.getSize(), 2);
        assertEquals(list.getHead().getValue(), "four");
        list.delete();
        assertEquals(list.getSize(), 1);
        assertEquals(list.getTail().getValue(), "four");
    }
}
