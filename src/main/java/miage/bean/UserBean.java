package miage.bean;

import com.opensymphony.xwork2.validator.annotations.*;
import miage.model.Company;
import miage.model.ModelInterface;
import miage.model.Particular;
import miage.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Maxime on 12/29/2014.
 */
@Validations
public class UserBean extends Abstract<User>{

    // User
    // Fields with validations
    private Long id;
    private String password;
    private String email;

    // These fields below are not validated by bean, they are handled by action
    // company
    private String corporateName;

    // particular
    private String firstName;
    private String lastName;
    private Date birthday;

    // proxy for radio (particular/company)
    // can take value "Company" or "Particular"
    private String type = "None";

    public UserBean() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Password matching expression. Password must be at least 8 characters, no more than 16 characters, and must include at least one upper case letter, one lower case letter, and one numeric digit.
     * @return
     */
    @RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "password", message="Supply password")
//    @RegexFieldValidator( regexExpression = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}$", message = "Password invalid")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "email", message="Supply an email")
    @EmailValidator(type = ValidatorType.SIMPLE, fieldName = "email", message = "You must enter a valid email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public void loadFromModel(User model) {
        this.id = model.getId();
        this.password = model.getPassword();
        this.email = model.getEmail();
        if( model instanceof Company ){
            this.corporateName = ((Company) model).getCorporateName();
        }
        if( model instanceof Particular ){
            this.firstName = ((Particular) model).getFirstname();
            this.lastName = ((Particular) model).getName();
            this.birthday = ((Particular) model).getBirthday();
        }
    }
}
