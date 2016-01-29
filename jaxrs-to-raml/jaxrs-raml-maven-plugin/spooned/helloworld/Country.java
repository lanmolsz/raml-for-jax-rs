package helloworld;


@javax.xml.bind.annotation.XmlRootElement(name = "country")
@javax.xml.bind.annotation.XmlAccessorType(value = javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(propOrder = { "id" })
public class Country {
    @javax.xml.bind.annotation.XmlElement(name = "id", required = false, type = java.lang.Integer.class)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

