package miage.action;

import miage.Global;
import miage.interceptor.AuthenticatedUserAware;
import miage.model.User;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;

/**
 * Created by Maxime on 12/29/2014.
 */
//@InterceptorRef("commonStack") // ne need to be auth to access index
@Result(name="success", location="/index.tiles", type="tiles")
public class IndexAction extends Abstract implements AuthenticatedUserAware{

    // For AuthenticatedUserAware
    private User authenticatedUser;
    @Override
    public void setUser(User authenticatedUser) {
        this.authenticatedUser = authenticatedUser;
    }


    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(IndexAction.class);

    @Actions({
            @Action("home"),
            @Action("index")
    })
    public String execute() throws Exception{

        // Here I get global application variable
        boolean aGlobalVar = Global.AUTO_AUTH; // ...

        logger.debug("IndexAction: home action called");
        logger.debug(this.authenticatedUser);


        return SUCCESS;
    }

    public User getAuthenticatedUser() {
        return authenticatedUser;
    }
}
