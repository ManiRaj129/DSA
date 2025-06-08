package CustomCollections;
import java.util.Iterator;
import java.util.AbstractCollection;
import java.util.Comparator;

class CustomLinkedList<T> extends AbstractCollection<T> implements Comparable {

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