package L5;

import org.junit.jupiter.api.Test;
import ru.vsu.L5.Main;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {

    @Test
    public void testFileRead() {
        Main main = new Main();
        assertThrows(IOException.class, main::fileRead);
    }

    @Test
    public void testOverflow(){
        Main main = new Main();
        assertThrows(StackOverflowError.class, main::Overflow);
    }

    @Test
    public void testArray(){
        Main main = new Main();
        assertThrows(Main.UncheckedRuntimeException.class, main::Array);
    }

}
