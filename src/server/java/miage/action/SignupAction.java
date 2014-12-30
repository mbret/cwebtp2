package miage.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import miage.beans.User;

/**
 * This action implement model driven interface, that way it transfer the form data into object automatically
 */
public class SignupAction extends ActionSupport implements ModelDriven{

    private User user = new User();

    @Override
    public Object getModel() {
        return user;
    }

    public String display(){
        return SUCCESS;
    }

    public String execute() throws Exception{

        User newUser = (User) this.getModel();
        if( User.isValid( newUser ) == false ){

            this.addActionError( "Please verify your form, some fields are incorrect");
            this.addFieldError( "password", "Password invalid" );
            return INPUT;
        }
        else{


            return SUCCESS;
        }
    }
}
