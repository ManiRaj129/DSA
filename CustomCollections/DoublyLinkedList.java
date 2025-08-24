package CustomCollections;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.AbstractCollection;

class DoublyLinkedList<T> extends AbstractCollection<T> {

    // dummy head and tail does not contain data
    private Node head;
    private Node tail;

    private int size;

    public DoublyLinkedList() {
        head = new Node(null, null, null);
        tail = new Node(null, null, null);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    private class Node {
        public Node next;
        public Node prev;
        public T val;

        private Node(Node prev, Node next, T val) {
            this.next = next;
            this.prev = prev;
            this.val = val;
        }

    }

    private void link(Node current, Node newNode) {
        current.next.prev = newNode;
        current.next = newNode;
    }

    private void unlink(Node current) {
        current.prev.next = current.next;
        current.next.prev = current.prev;
    }

    private Node NodeAtIndex(int i) {
        Node current = head.next;

        for (int n = 0; n < i; n++) {
            current = current.next;
        }
        return current;
    }

    public void insert(T data, int i) {
        Node nodeAtIndex = NodeAtIndex(i);
        Node newNode = new Node(nodeAtIndex.prev, nodeAtIndex, data);
        link(nodeAtIndex.prev, newNode);
        size++;
    }

    public T delete(int i) {
        Node nodeAtIndex = NodeAtIndex(i);
        T val = nodeAtIndex.val;
        unlink(nodeAtIndex);
        size--;
        return val;
    }

    /**
     * prepends
     * 
     * @return
     */
    public boolean add(T data) {
        Node newNode = new Node(head, head.next, data);
        link(head, newNode);
        size++;
        return newNode.val.equals(head.next.val);
    }

    @Override
    public ListIterator<T> iterator() {
        return new LIterator();
    }

    @Override
    public int size() {
        return size;
    }

    /*
     * Allows concurrent modification while iterating which would cause error
     * with for each as the iterator is not available in that case
     * However it also creates iterator in underlying implementaion.
     */
    private class LIterator implements ListIterator<T> {

        Node pointer;
        int index;
        private static final int BEHIND = -1;
        private static final int AHEAD =1;
        private static final int NONE=0;
        int modDir;

        public LIterator(int pos) {
            if (pos < 0 && pos > size) {
                throw new IndexOutOfBoundsException();
            }
            index = pos;
            pointer = NodeAtIndex(pos);
            modDir = NONE;
        }

        public LIterator() {
            this(0);
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            if(!hasNext()){
                throw new NoSuchElementException();                
            }
            T data = pointer.val;
            pointer= pointer.next;
            index++;
            //returned element is behind the current index 
            modDir= BEHIND;
            return data;
        }

        public boolean hasPrevious() {
            return index > 0;
        }

        public T previous() {
            if(!hasPrevious()){
                throw new NoSuchElementException();
            }
            pointer=pointer.prev;
            index--;
            modDir=AHEAD;
            return pointer.val;
        }
        
        @Override
        public void remove() {
            if(modDir ==NONE){
                throw new IllegalStateException();
            }else if(modDir == AHEAD){
                Node temp = pointer.next;
                unlink(pointer);
                pointer = temp;
            }else{
                unlink(pointer.prev);
                index--;
            }
            size--;
            modDir=NONE;
        }

        @Override
        public void set(T data){
            if(modDir ==NONE){
                throw new IllegalStateException();
            }else if(modDir == AHEAD){
                pointer.val=data;
            }else{
                pointer.prev.val=data;
            }
        }
  
        @Override
        public void add(T data) {
            Node temp = new Node(pointer.prev, pointer, data);
            link(pointer.prev, temp);
            index++;
            size++;
            //since the returned element's index/pos changed
            modDir=NONE;
        }

        @Override
        public int nextIndex() {
           return index;
        }

        @Override
        public int previousIndex() {
            return index-1;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        ListIterator<Integer> iter = list.iterator();
        iter.add(1);
    }
}
