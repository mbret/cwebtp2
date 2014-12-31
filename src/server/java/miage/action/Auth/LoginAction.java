package miage.action.Auth;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;
import miage.bean.AuthUserBean;
import miage.dao.AuthDAO;
import miage.model.User;
import miage.util.DatabaseInitializerListener;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.apache.struts2.convention.annotation.Action;

import java.util.Map;

/**
 * - This action implement model driven interface, that way it transfer the form data into object automatically
 * - SessionAware interface allow us to use session with this action
 */
@InterceptorRef("defaultStack")
@Validations
public class LoginAction extends Abstract implements ModelDriven<AuthUserBean>, SessionAware{

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(DatabaseInitializerListener.class);

    // For ModelDriven
    private AuthUserBean beanAuthUser = new AuthUserBean();
    @Override
    public AuthUserBean getModel() {
        return beanAuthUser;
    }

    // For SessionAware
    Map<String, Object> session;
    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    @VisitorFieldValidator(message="Error on form: ")
    public AuthUserBean getUser(){
        return beanAuthUser;
    }

    AuthDAO dao = new AuthDAO();

    /**
     * This action method only display the form
     * @return
     */
    @Action(
            value="login",
            results = {
                    @Result(name="success", location="/WEB-INF/pages/login.jsp"),
                    @Result(name="error", type = "redirectAction", params = {
                            "namespace", "/", "actionName", "home", /*"message", "already logged"*/
                    })
            }
    )
    @SkipValidation
    public String display() throws Exception{

        // Check if already auth
        if(this.session.containsKey("user")){
            logger.debug("User already logged!");
            return ERROR;
        }

        return SUCCESS;
    }

    /**
     * This action method validate the form
     * @return
     * @throws Exception
     *
     */
    @Action(
            value = "validateLogin",
            results = {
                    @Result(name="error", location="/WEB-INF/pages/login.jsp"),
                    @Result(name="input", location="/WEB-INF/pages/login.jsp"),
                    @Result(name="success", type = "redirectAction", params = {
                            "namespace", "/", "actionName", "home", "message", ""
                    })
            }
    )
    public String execute() throws Exception{

        try {
            User user = dao.checkAuth( beanAuthUser );
            if( user == null ){
                this.addActionError("Credentials invalids");
                return ERROR;
            }
            else{
                this.session.put("user", user.getId());
                this.addActionMessage("User saved successful!");
                return SUCCESS;
            }
        } catch (Exception e) {
            this.addActionError("Could not save User: " + e.getMessage());
            e.printStackTrace();
            return ERROR;
        }

    }


}
