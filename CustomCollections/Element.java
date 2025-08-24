package CustomCollections;

public class Element<T> implements Cloneable, Comparable<T>{
    
    @Override
    public Element clone(){
        Element element;
        try{
           element = (Element) super.clone();
           return element;
        }catch(Exception e){
            throw new AssertionError("Cloning not supported", e);
        }
    }

     @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    } 
}
