package miage.action;

import com.opensymphony.xwork2.ActionSupport;
import miage.action.Auth.*;
import org.apache.struts2.convention.annotation.*;

/**
 * Created by Maxime on 12/29/2014.
 */
@Namespace("/")
@ResultPath("/WEB-INF/pages")
@Result(name="success", location="index.jsp")
public class IndexAction extends Abstract{

    @Actions({
            @Action("home"),
            @Action("index")
    })
    public String execute() throws Exception{

        return SUCCESS;
    }
}
