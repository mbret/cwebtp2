package miage.action.Auth;

import com.opensymphony.xwork2.ModelDriven;
import miage.bean.AuthUserBean;
import miage.dao.AuthDAO;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * - This action implement model driven interface, that way it transfer the form data into object automatically
 * - SessionAware interface allow us to use session with this action
 */
public class LogoutAction extends Abstract implements ModelDriven<AuthUserBean>, SessionAware{

    // For ModelDriven
    private AuthUserBean authUser = new AuthUserBean();
    @Override
    public AuthUserBean getModel() {
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
