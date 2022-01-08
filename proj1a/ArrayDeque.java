public class ArrayDeque<T> {
    private T[] items ;
    private int size;
    int First = 3;
    int Last = First + size - 1;


    public ArrayDeque(){
        items = (T[]) new Object[8];
        size = 0;
    }

    public void addFirst(T i){
        if (First - 1 >= 0){
        items[First - 1] = i;
        First --;
        size ++;
        }
        else{
            resize(items.length * 2);
            items[ First - 1 ] = i;
            First --;
            size ++;
        }
    }
    public void addLast(T i){
        if (Last + 1 < items.length){
            items[Last + 1] = i;
            Last ++;
            size ++;}
        else{
            resize(items.length * 2);
            items[Last + 1] = i;
            Last ++;
            size ++;
        }
    }
    private void resize(int cap){
        T[] a = (T[]) new Object[cap];
        System.arraycopy(items, First, a, a.length/2, size);
        items = a;
        First = a.length/2;
        Last = a.length/2 + size - 1;
    }
    public boolean isEmpty(){
        return items[First] == null;
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        for(int i = First;i <= Last; i++){
            System.out.print(items[i]+" ");
        }
        System.out.println("");
    }
    public T get(int index){
        return items[First + index];
    }
    public T removeFirst(){
        T a = items[First];
        items[First] = null;
        First ++;
        size --;
        if(items.length > 16 && size == items.length/4) resize(items.length/2);
        return a;
    }
    public T removeLast(){
        T a = items[Last];
        items[Last] = null;
        Last --;
        size --;
        if(items.length > 16 && size == items.length/4) resize(items.length/2);
        return a;
    }
}
