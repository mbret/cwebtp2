package miage.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.annotations.After;
import com.opensymphony.xwork2.interceptor.annotations.Before;
import com.opensymphony.xwork2.interceptor.annotations.BeforeResult;
import org.apache.struts2.convention.annotation.*;

/**
 * Created by Maxime on 12/30/2014.
 *
 * See for interceptor http://www.tutorialspoint.com/struts_2/struts_annotations_types.htm
 * ex: isLogged etc
 *
 * Some example of annotation stackoverflow.com/questions/14805027/struts2-passing-action-member-variable-as-parameter-using-annotation
 */
// This action extend default package
// We can then access everything defined inside default package (struts.xml)
@ParentPackage("default")
// This action set as default interceptor the authStack
// It means that all action class that will extend this class will have this stack
@InterceptorRef("authStack")
@Namespace("/")
// Here are defined the global results
// These results can be used by any action until they become overwritten
@Results({
       @Result(name = "login", type = "redirectAction", params = {
               "namespace", "/auth", "actionName", "login", "message", "already logged"
       })
})
// Here we define the global path for result
// In action we can use "signup.jsp" instead of "/WEB-INF/pages/signup"
@ResultPath("/WEB-INF/pages")
public class Abstract extends ActionSupport {

    @Before
    public void preDispatch(){
        System.out.println("PreDispatch");
    }

    @After
    public void postDispatch(){
        System.out.println("PostDispatch");
    }

}
