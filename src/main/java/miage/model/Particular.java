package miage.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Maxime on 12/30/2014.
 */
@Entity
@Table(name="particular")
@PrimaryKeyJoinColumn(name="id")
public class Particular extends User{

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="firstname", nullable = false)
    private String firstname;

    @Temporal(TemporalType.DATE)
    @Column(name="birthday", nullable = true)
    private Date birthday;

    public Particular() {
        super();
    }

    public Particular(User user, String name, String firstname, Date birthday) {
        super( user.getEmail(), user.getPassword() );
        this.name = name;
        this.firstname = firstname;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
