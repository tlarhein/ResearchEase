package org.launchcode.models;

import org.springframework.data.annotation.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tracey Cannon Liftoff 0519
 */

@Entity
public class User extends org.apache.tomcat.jni.User {

    @Id //serves as the primary key
    @GeneratedValue  //tells hibernate to generate the value
    private int id;

    @NotNull
    @Size(min=9, max=50)
    private String name;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<User> users = new ArrayList<>();

    public User(int id){
        this.id = id;
    }

    public User() {
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

    public List<User> getUsers() {
        return users;
    }


    public void setProject(Project pro) {
    }
}
