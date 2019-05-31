package org.launchcode.models;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tracey Cannon Liftoff 0519
 */

@Entity
public class Project {

    @Id //serves as the primary key
    @GeneratedValue  //tells hibernate to generate the value
    private int id;

    @NotNull
    @Size(min=9, max=50)
    private String name;

    @OneToMany
    @JoinColumn(name = "project_id")
    private List<Instrument> instruments = new ArrayList<>();

    public Project(){}

    public Project(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
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


    public String getUsers(String users) {
        return users;
    }
}

