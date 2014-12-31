package miage.action;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import org.apache.struts2.convention.annotation.*;

/**
 * Created by Maxime on 12/29/2014.
 */
@Namespace("/")
@ResultPath("/WEB-INF/pages")
@Result(name="success", location="index.jsp")
public class IndexAction extends Abstract{

    private static final Logger LOG = LoggerFactory.getLogger(IndexAction.class);

    @Actions({
            @Action("home"),
            @Action("index")
    })
    public String execute() throws Exception{

        LOG.debug("IndexAction: home action called");

        return SUCCESS;
    }
}
