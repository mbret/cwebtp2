package miage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by Maxime on 12/30/2014.
 */
@Entity
@Table(name="company")
@PrimaryKeyJoinColumn(name="id")
public class Company extends User{

    @Column(name="corporate_name", unique = true, nullable = false)
    private String corporateName;

    public Company() {
        super();
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }
}
