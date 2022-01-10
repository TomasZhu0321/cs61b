import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    static CharacterComparator offByOne = new OffByOne();
    @Test
    public void testEqualChars(){
        assertTrue(offByOne.equalChars('%', '&'));
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('x', 'y'));
        assertFalse(offByOne.equalChars('x', 'x'));
        assertFalse(offByOne.equalChars('a', 'x'));
        assertFalse(offByOne.equalChars('a', 'B'));
    }

}

