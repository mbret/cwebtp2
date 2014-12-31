package miage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Maxime on 12/29/2014.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="user")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="email", unique = true, nullable = false)
    private String email;

    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "to_user")
    private List<Message> messagesReceived = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "from_user")
    private List<Message> messagesSent = new ArrayList();

    @ManyToMany(mappedBy = "users")
    private Set<Directory> directories = new HashSet<Directory>();

    public User() { }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String email, String password, List<Message> messagesReceived, List<Message> messagesSent) {
        this.email = email;
        this.password = password;
        this.messagesReceived = messagesReceived;
        this.messagesSent = messagesSent;
    }

    public User(miage.bean.User userBean ){
        this.id = userBean.getId();
        this.password = userBean.getPassword();
        this.email = userBean.getPassword();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Message> getMessagesReceived() {
        return messagesReceived;
    }

    public void setMessagesReceived(List<Message> messagesReceived) {
        this.messagesReceived = messagesReceived;
    }

    public List<Message> getMessagesSent() {
        return messagesSent;
    }

    public void setMessagesSent(List<Message> messagesSent) {
        this.messagesSent = messagesSent;
    }

    public Set<Directory> getDirectories() {
        return directories;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
