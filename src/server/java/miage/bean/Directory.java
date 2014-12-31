package miage.bean;

import miage.model.*;
import miage.model.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Maxime on 12/31/2014.
 */
public class Directory {

    private Long id;
    private String name;
    private Set<miage.model.User> users = new HashSet<>();
    private int nbUsers;

    public Directory( miage.model.Directory directory ) {
        this.id = directory.getId();
        this.name = directory.getName();
        this.users = directory.getUsers();
        this.nbUsers = directory.getUsers().size();
    }

    public static List<Directory> buildDirectoriesFromModel( Set<miage.model.Directory> directories ){
        List<Directory> beans = new ArrayList<>();
        for (miage.model.Directory directory : directories){
            beans.add( new Directory( directory ) );
        }
        return beans;
    }

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
}
