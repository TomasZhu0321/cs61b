import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    static CharacterComparator offByOne = new OffByOne();
    @Test
    public void testEqualChars(){
        assertTrue(offByOne.equalChars('a','b'));
        assertTrue(offByOne.equalChars('r','q'));
        assertTrue(offByOne.equalChars('&','%'));
    }

}
