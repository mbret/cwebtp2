package miage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.*;
import java.io.Serializable;

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

    private String password;

    @Column(name="email", unique = true, nullable = false)
    private String email;

    public User() {

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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
