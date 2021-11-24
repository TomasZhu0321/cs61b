public class SLList {
    public class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode first;

    public SLList(int x) {
        first = new IntNode(x, null);
    }

    /** Adds an item to the front of the list. */
    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    /** Retrieves the front item from the list. */
    public int getFirst() {
        return first.item;
    }

    /** Adds an item to the end of the list. */
    public void addLast(int x) {
        IntNode p = first;

        /* Advance p to the end of the list. */
        /** The idea is fairly straightforward,
         *  we create a pointer variable p
         *  and have it iterate through the list to the end.*/
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    /** Returns the number of items in the list using recursion. */
    private static int size(IntNode p) {
        if (p.next == null){
            return 1;
        }
        return 1+size(p.next);
    }
    public int size() {
        return size(first);
    }
}
