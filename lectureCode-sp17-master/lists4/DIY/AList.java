/** Array based list.
 *  @author Josh Hug
 */

//       0 1 2 3 4 5
//items:[6,5,4,2,3,-3.....]
//size:6

public class AList {
    int[] items;
    int size;

    /** Creates an empty list. */
    public AList() {
        items=new int[100];
        size = 0;
    }

    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        if(size==items.length){
            int [] a = new int [size +1];
            System.arraycopy(items,0,a,0,size);
            items = a;
        }
        items[size]=x;
        size=size +1;
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        return items[size-1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        return items[1];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public int removeLast() {
        int x= getLast();
        size=size-1;
        return x;
    }
} 