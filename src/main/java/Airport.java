import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.*;
import java.util.List;

@JsonRootName(value = "airport")
@XmlRootElement(name = "airport")
@XmlAccessorType(XmlAccessType.FIELD)
public class Airport {

    @XmlAttribute(name = "id")
    private String id;
    private String name;
    @XmlElementWrapper
    private List<Airline> airlines;

    public Airport() {

    }

    public Airport(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Airline> getAirlines() {
        return airlines;
    }

    public void setAirlines(List<Airline> airlines) {
        this.airlines = airlines;
    }

}
