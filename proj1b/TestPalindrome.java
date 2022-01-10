import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    @Test
    public void testIsPalidrome(){
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("aca"));
        assertTrue(palindrome.isPalindrome("aaaa"));
        assertTrue(palindrome.isPalindrome("a"));
        assertFalse(palindrome.isPalindrome("acee"));
    }
    @Test
    public void testIsPalindromecc(){
        assertTrue(palindrome.isPalindrome("acdb",offByOne));

    }
}
