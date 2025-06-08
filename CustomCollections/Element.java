package CustomCollections;

public class Element implements Cloneable {
    
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
}
