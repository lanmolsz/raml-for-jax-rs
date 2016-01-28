package helloworld;


import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;
import java.util.Map;

@XmlRootElement(name = "CollectionEntity")
public class CollectionEntity
{
    private Collection<String> collection;
    private String[] array;
    private Map<String,String> map;

    public Collection<String> getCollection() {
        return collection;
    }

    public void setCollection(Collection<String> collection) {
        this.collection = collection;
    }

    public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}