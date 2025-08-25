package CustomCollections;

public class Element<T> implements Cloneable, Comparable<T>{
    
    @Override
    public Element clone(){
        Element element;
        try{
            //each object has header: metadata, class pointer and fields: primitive and non-primitive (reference)
            //primitive types are copied bit by bit
            //shallow copy
           element = (Element) super.clone();
           return element;
        }catch(Exception e){
            throw new AssertionError("Cloning not supported", e);
        }
    }

     @Override
    public int compareTo(T item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    } 
}
