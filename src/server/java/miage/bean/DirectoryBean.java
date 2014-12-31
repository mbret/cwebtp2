package miage.bean;

import miage.model.Directory;
import miage.model.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Maxime on 12/31/2014.
 */
public class DirectoryBean extends Abstract<Directory>{

    private Long id;
    private String name;
    private Set<miage.model.User> users = new HashSet<>();
    private int nbUsers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public int getNbUsers() {
        return nbUsers;
    }

    public void setNbUsers(int nbUsers) {
        this.nbUsers = nbUsers;
    }

    @Override
    public String toString() {
        return "Directory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", users=" + users +
                ", nbUsers=" + nbUsers +
                '}';
    }

    @Override
    public void loadFromModel(Directory model) {
        this.id = model.getId();
        this.name = model.getName();
    }
}
