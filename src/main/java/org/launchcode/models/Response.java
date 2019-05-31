package org.launchcode.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tracey Cannon Liftoff 0519
 */


@Entity
public class Response {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 30, max = 50)
    private String name;

    @ManyToMany
    private List<Instrument> instruments = new ArrayList<>();

    public Response(String name) {
        this.name = name;

    }

    public Response() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
         this.id = id;
        }

    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;

    }

    public List<Instrument> getInstruments() {
        return instruments;
    }

    public void addItem(Instrument item){
        instruments.add(item);
    }
}