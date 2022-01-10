public class Palindrome {
    public Deque <Character> wordToDeque(String word){
        LinkedListDeque <Character> d = new LinkedListDeque<Character>();
        ArrayDeque<Character> a = new ArrayDeque<>();
        for (int i=0; i<word.length();i++){
            d.addLast(word.charAt(i));
            a.addLast(word.charAt(i));
        }
        return a;
    }
    public boolean isPalindrome(String word){
        Deque a = wordToDeque(word);
        for(int i = 0; i< a.size() - 1; i++){
            if (a.get(i) != a.get(a.size()-1-i)){
                return false;
            }
        }
        return true;
    }
    public boolean isPalindrome(String word, CharacterComparator cc){
        ArrayDeque<Character> b = (ArrayDeque<Character>) wordToDeque(word);
        return help(b,cc);
    }
    public boolean help(ArrayDeque<Character> b,CharacterComparator cc){
        if(b.size()==0 || b.size()==1)return true;
        if (!cc.equalChars(b.removeFirst(),b.removeLast())){
            return false;
        }
        return help(b,cc);
    }
}
