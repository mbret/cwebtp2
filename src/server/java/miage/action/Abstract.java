package miage.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.annotations.After;
import com.opensymphony.xwork2.interceptor.annotations.Before;

/**
 * Created by Maxime on 12/30/2014.
 *
 * See for interceptor http://www.tutorialspoint.com/struts_2/struts_annotations_types.htm
 * ex: isLogged etc
 *
 * Some example of annotation stackoverflow.com/questions/14805027/struts2-passing-action-member-variable-as-parameter-using-annotation
 */
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
