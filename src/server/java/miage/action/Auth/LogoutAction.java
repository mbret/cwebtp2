package miage.action.Auth;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * - This action implement model driven interface, that way it transfer the form data into object automatically
 * - SessionAware interface allow us to use session with this action
 */
public class LogoutAction extends AbstractAction implements SessionAware{

    // For SessionAware
    Map<String, Object> session;
    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    @Action(
            value="logout",
            results = {
                    @Result(name="none", type = "redirectAction", params = {
                            "namespace", "/", "actionName", "home"
                    })
            }
    )
    public String execute() throws Exception{

        this.session.remove("user");

        return NONE;
    }


}
