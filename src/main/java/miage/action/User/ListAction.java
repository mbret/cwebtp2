package miage.action.User;

import miage.action.Abstract;
import miage.bean.BeanFactory;
import miage.bean.UserBean;
import miage.dao.UserDAO;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import java.util.List;

/**
 * Created by Maxime on 12/31/2014.
 */
@Namespace("/users")
@Result(name="success", location="/users.tiles", type="tiles")
public class ListAction extends Abstract{

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ListAction.class);

    UserDAO dao = new UserDAO();

    List<UserBean> users;

    public List<UserBean> getUsers() {
        return users;
    }

    public void setUsers(List<UserBean> users) {
        this.users = users;
    }

    @Actions({
            @Action(""),
            @Action("list"),
    })
    public String execute() throws Exception{

        this.users = BeanFactory.create( UserBean.class, dao.getAll());

        return SUCCESS;
    }
}
