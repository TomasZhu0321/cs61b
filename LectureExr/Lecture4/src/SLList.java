public class SLList {
    public class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }
    /** The first item(if it exits) it at sentinel.next. */
    private IntNode sentinel;
    private int size;
    /** Creates an empty SLList*/
    public SLList(){
        sentinel=new IntNode(6,null);
        size=0;
    }
    public SLList(int x) {
        sentinel = new IntNode(6, null);
        sentinel.next=new IntNode(x,null);
        size =1;
    }

    /** Adds an item to the front of the list. */
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size=size+1;
    }

    /** Retrieves the front item from the list. */
    public int getFirst() {
        return sentinel.next.item;
    }

    /** Adds an item to the end of the list. */
    public void addLast(int x) {
        size=size+1;
        IntNode p = sentinel;

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
        return size;
    }

    public static void main(String[] args) {
        SLList L=new SLList();
        L.addFirst(20);
        L.addLast(2);
        System.out.println(L.size);
    }
}
