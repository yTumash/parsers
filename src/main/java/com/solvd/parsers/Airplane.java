package com.solvd.parsers;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "airplane")
@XmlAccessorType(XmlAccessType.FIELD)
public class Airplane {

    @XmlAttribute(name = "id")
    private String id;
    private Model model;
    private Integer capacity;
    @XmlElementWrapper
    private List<Seat> seats;

    public Airplane() {

    }

    public Airplane(String id, Integer capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    public enum Model {
        AIRBUS("airbus"),
        BOING("boing");

        private String name;

        Model(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}


