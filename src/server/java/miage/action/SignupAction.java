package miage.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;
import miage.bean.UserBean;
import miage.dao.UserDAO;
import miage.model.ModelFactory;
import miage.model.User;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import javax.jms.Session;
import java.util.Map;

/**
 * This action implement model driven interface, that way it transfer the form data into object automatically
 */
@InterceptorRef("defaultStack")
@Validations
public class SignupAction extends Abstract implements ModelDriven<UserBean>, SessionAware{

    // For ModelDriven
    private UserBean beanUser = new UserBean();
    @Override
    public UserBean getModel() {
        return beanUser;
    }

    // For SessionAware
    Map<String, Object> session;
    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    UserDAO dao = new UserDAO();

    @VisitorFieldValidator(message="Error on form: ")
    public UserBean getUser(){
        return beanUser;
    }

    /**
     * This action method only display the form
     * @return
     */
    @Action(
            value="signup",
            results = {
                    @Result(name="success", location="/WEB-INF/pages/signup.jsp"),
            }
    )
    @SkipValidation
    public String displayForm(){
        return SUCCESS;
    }

    /**
     * This action method validate the form
     * @return
     * @throws Exception
     */
    @Action(
            value = "validateSignup",
            results = {
                    @Result(name="error", location="/WEB-INF/pages/signup.jsp"),
                    @Result(name="input", location="/WEB-INF/pages/signup.jsp"),
                    @Result(name="success", type = "redirectAction", params = {
                            "namespace", "/", "actionName", "home", "message", ""
                    })
            }
    )
    public String save() throws Exception{

        // The form (bean) has been validated by struts
        // Here we just need to save it

        try {
            User user = ModelFactory.create(User.class, beanUser);
            dao.save( user );
            this.session.put("user", user.getId()); // save session (login)
            this.addActionMessage("User saved successful!");
            return SUCCESS;
        } catch (Exception e) {
            this.addActionError("Could not save User: " + e.getMessage());
            e.printStackTrace();
            return ERROR;
        }
    }


}
