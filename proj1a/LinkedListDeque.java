public class LinkedListDeque<T>{
    private Node sentinel;
    private int size;

    public class Node {
        public Node prev;
        public T item;
        public Node next;

        public Node(Node prev, T item, Node next){
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }
    /**
     * Creates empty linked list deque
     * just point to the address, not concrete content in the prev/next box
     */
    public LinkedListDeque() {
        sentinel = new Node(null,null ,null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }
    public void addFirst(T item){
        sentinel.next = new Node(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size ++;
    }
    public void addLast(T item){
       sentinel.prev = new Node(sentinel.prev,item,sentinel);
       sentinel.prev.prev.next = sentinel.prev;
       size ++;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        Node ptr = sentinel.next;
        while(ptr.item != null){
            System.out.print(" " + ptr.item);
            ptr = ptr.next;
        }
        System.out.println("");
    }
    public T removeFirst(){
        while(sentinel.next.item != null){
            T x = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size = size -1;
            return x;
        }
        return null;
    }

    public T removeLast(){
        while(sentinel.prev.item != null){
            T x = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size = size -1;
            return x;
        }
        return null;
    }
    public T get(int index){
        if (index < size) {
            Node ptr = sentinel;
            for (int i = 0; i <= index; i++) {
                ptr = ptr.next;
            }return ptr.item;
        }else
            return null;
    }
    public T getRecursive(int index){
        return getRecHelper(index,sentinel.next);
    }
    private T getRecHelper(int index, Node p){

        if (index >= size) return null;
        if (index == 0){
            return p.item;
        }
        return getRecHelper(index - 1, p.next);
    }



}
