package miage.action;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import miage.interceptor.AuthenticatedUserAware;
import miage.model.User;
import miage.util.DatabaseInitializerListener;
import org.apache.struts2.convention.annotation.*;

/**
 * Created by Maxime on 12/29/2014.
 */
@Result(name="success", location="index.jsp")
public class IndexAction extends Abstract implements AuthenticatedUserAware{

    // For AuthenticatedUserAware
    User authenticatedUser = new User();
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

        logger.debug("IndexAction: home action called");
        logger.debug(this.authenticatedUser);

        return SUCCESS;
    }


}
