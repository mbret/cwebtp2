package miage.bean;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import miage.model.User;

/**
 * Created by Maxime on 12/29/2014.
 */
public class AuthUserBean extends Abstract<User>{

    private String password;
    private String email;

    public AuthUserBean() {
    }

    @RequiredStringValidator(message="Supply a password")
    public String getPassword() {
        return password;
    }

    @RequiredStringValidator(message="Supply an email")
    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void loadFromModel(User model) {
        this.password = model.getPassword();
        this.email = model.getEmail();
    }
}
