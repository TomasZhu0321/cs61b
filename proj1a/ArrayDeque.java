public class ArrayDeque<T> {
    private T[] items ;
    private int size;
    private int First = 3; //应该是private
    private int Last = First + size - 1;

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
            size ++;
        }
        else{
            resize(items.length * 2);
            items[Last + 1] = i;
            Last ++;
            size ++;
        }
    }
    private void resize(int cap){
        T[] a = (T[]) new Object[cap];
        if ( a.length >= items.length ){
            if(First == 0){
        System.arraycopy(items, First, a,
                a.length/2, size);
        First = a.length/2;
        Last = First + size -1;
        }
            if(Last == items.length - 1){
                System.arraycopy(items, First, a,
                        First, size);
            }
        }
        else{
            System.arraycopy(items, First, a,
                    Math.abs(Last - a.length), size);
            First = Math.abs(Last - a.length);
            Last = First + size - 1;
        }
        items = a;
    }
    public boolean isEmpty(){
        return size==0;
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
        if(size>0)
        {   T a = items[First];
            items[First] = null;
            First ++;
            size --;
            if(items.length > 16 && size == items.length/4)
            {
                resize(items.length/2);
                return a;
            }
            return a;
        }
        return null;
    }
    public T removeLast(){
        if(size>0)
        {   T a = items[Last];
            items[Last] = null;
            Last --;
            size --;
            if(items.length >= 16 && size == items.length/4)
            {
                resize(items.length/2);
                return a;
            }
            return a;
        }
        return null;
    }
}
