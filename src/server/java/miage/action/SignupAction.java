package miage.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;
import miage.bean.User;
import miage.dao.UserDAO;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.interceptor.validation.SkipValidation;

/**
 * This action implement model driven interface, that way it transfer the form data into object automatically
 */
@Validations
public class SignupAction extends ActionSupport implements ModelDriven<miage.bean.User>{

    // For ModelDriven
    private User beanUser = new User();
    @Override
    public User getModel() {
        return beanUser;
    }

    UserDAO dao = new UserDAO();

    @VisitorFieldValidator(message="Error on form: ")
    public User getUser(){
        return beanUser;
    }

    /**
     * This action method only display the form
     * @return
     */
    @SkipValidation
    public String displayForm(){
        return SUCCESS;
    }

    /**
     * This action method validate the form
     * @return
     * @throws Exception
     */
//    @RequiredStringValidator(fieldName = "password", message = "Name required ")
    public String save() throws Exception{

        // The form (bean) has been validated by struts
        // Here we just need to save it

        miage.model.User user = new miage.model.User( beanUser );
        System.out.println(user);
        System.out.println(beanUser);
//        dao.addUser( user );
//
//        return SUCCESS;

        try {
            dao.save( user );
            this.addActionMessage("User saved successful!");
            return SUCCESS;
        } catch (Exception e) {
            this.addActionError("Could not save User: " + e.getMessage());
            e.printStackTrace();
            return ERROR;
        }
    }
}
