package miage.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;
import miage.Global;
import miage.dao.UserDAO;
import miage.model.ModelFactory;
import miage.model.User;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;

import java.util.Map;

/**
 * Created by Maxime on 12/31/2014.
 *
 * Useful: http://www.journaldev.com/2203/how-to-get-servlet-session-request-response-context-attributes-in-struts-2-action
 */
@ParentPackage("default")
public class AuthenticationInterceptor implements Interceptor{

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(AuthenticationInterceptor.class);

    UserDAO userDAO = new UserDAO();

    @Override
    public void destroy() {

    }

    @Override
    public void init() {
        logger.debug("init()");
    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        System.out.println("inside auth interceptor");
        ActionSupport action = (ActionSupport) actionInvocation.getAction();
        Map<String, Object> sessionAttributes = actionInvocation.getInvocationContext().getSession();

        // For dev only
        if(Global.AUTO_AUTH){
            sessionAttributes.put("user", userDAO.get( new Long(1) ).getId() );
        }

        Long userId = (Long)sessionAttributes.get("user");


        if( userId == null ){
            return "login";
        }
        else{
            return actionInvocation.invoke();
        }
    }


}
