package miage.action.Auth;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import miage.bean.AuthUser;
import miage.dao.AuthDAO;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.apache.struts2.convention.annotation.Action;

import java.util.Map;

/**
 * - This action implement model driven interface, that way it transfer the form data into object automatically
 * - SessionAware interface allow us to use session with this action
 */
public class LoginAction extends Abstract implements ModelDriven<AuthUser>, SessionAware{

    // For ModelDriven
    private AuthUser authUser = new AuthUser();
    @Override
    public AuthUser getModel() {
        return authUser;
    }

    // For SessionAware
    Map<String, Object> session;
    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    AuthDAO dao = new AuthDAO();

    /**
     * This action method only display the form
     * @return
     */
    @Action(
            value="login",
            results = {
                    @Result(name="success", location="/WEB-INF/pages/login.jsp")
            }
    )
    @SkipValidation
    public String display() throws Exception{

        // Check if already auth
        if(this.session.containsKey("user")){
            return SUCCESS;
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

//        miage.model.User user = this.dao.checkAuth( authUser );
//
//        if( user == null ){
//            this.addActionError("Credentials invalids");
//            return ERROR;
//        }
//        else{
//            // Save user to session
//            this.session.put("user", "oneID");
            return SUCCESS;
//        }
    }


}
