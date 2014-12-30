package miage.action.Auth;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import miage.bean.AuthUser;
import miage.dao.AuthDAO;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import java.util.Map;

/**
 * - This action implement model driven interface, that way it transfer the form data into object automatically
 * - SessionAware interface allow us to use session with this action
 */
public class LogoutAction extends Abstract implements ModelDriven<AuthUser>, SessionAware{

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


    public String execute() throws Exception{

        this.session.remove("user");

        return SUCCESS;
    }


}
