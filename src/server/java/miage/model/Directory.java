package miage.model;

import miage.bean.DirectoryBean;
import miage.model.User;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "directory" )
public class Directory extends Abstract<DirectoryBean> implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    /**
     * The LAZY fetch prevent to have multiple directories when join request (see http://stackoverflow.com/questions/1995080/hibernate-criteria-returns-children-multiple-times-with-fetchtype-eager)
     */
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_directory",
            joinColumns = {
                    @JoinColumn(name = "directory_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "user_id")
            }
    )
    private Set<User> users = new HashSet<User>();

    public Directory() {
    }

    public Directory(String name) {
        this.name = name;
    }

    public void addUser( User user ){
        this.users.add(user);
        user.getDirectories().add(this);
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

    @Override
    public void loadFromBean(DirectoryBean bean) {
        this.id = bean.getId();
        this.name = bean.getName();
    }
}
