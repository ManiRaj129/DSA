package CustomCollections;
import java.util.Iterator;
import java.util.AbstractCollection;

class DoublyLinkedList<T> extends AbstractCollection<T> implements Comparable<T> {

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList(){

    }

    private class Node{
        private Node next;
        private Node prev;

        

    }

    public void add(){

    }

    public T delete(){

        return null;
    }

    public void insert(){

    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    @Override
    public int size() {
        return 0;
    }

    private class ListIterator implements Iterator<T>{

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }

    }

    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    } 
}

