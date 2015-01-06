package miage.bean;

import com.opensymphony.xwork2.validator.annotations.*;
import miage.model.ModelInterface;
import miage.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxime on 12/29/2014.
 */
@Validations
public class UserBean extends Abstract<User>{

    private Long id;
    private String password;
    private String email;

    public UserBean() {

    }

    public UserBean(Long id, String password, String email) {
        this.id = id;
        this.password = password;
        this.email = email;
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
    @RegexFieldValidator( regexExpression = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}$", message = "Password invalid")
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
    }
}
