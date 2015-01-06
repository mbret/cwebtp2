package miage.action.Message;

import miage.bean.BeanFactory;
import miage.bean.MessageBean;
import miage.bean.UserBean;
import miage.dao.MessageDAO;
import miage.dao.UserDAO;
import miage.interceptor.AuthenticatedUserAware;
import miage.model.User;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;

import java.util.List;

/**
 * Created by Maxime on 12/31/2014.
 */
@Result(name="none", location="/messages-list.tiles", type="tiles")
public class ListAction extends AbstractAction implements AuthenticatedUserAware{

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ListAction.class);

    // For AuthenticatedUserAware
    private User authenticatedUser = null;
    @Override
    public void setUser(User authenticatedUser) {
        this.authenticatedUser = authenticatedUser;
    }

    UserDAO dao = new UserDAO();
    private MessageDAO messageDAO = new MessageDAO();

    List<UserBean> users;
    List<MessageBean> messagesSent;
    List<MessageBean> messagesReceived;
    private UserBean userBean;
    public List<UserBean> getUsers() {
        return users;
    }

    public void setUsers(List<UserBean> users) {
        this.users = users;
    }

    @Actions({
            @Action(""),
            @Action("list"),
            @Action("see")
    })
    public String execute() throws Exception{

        // Just get authenticated user and get its messages
        this.messagesSent = BeanFactory.create(MessageBean.class, this.authenticatedUser.getMessagesSent());
        this.messagesReceived = BeanFactory.create(MessageBean.class, this.authenticatedUser.getMessagesReceived());
        this.userBean = BeanFactory.create(UserBean.class, this.authenticatedUser);
        return NONE;
    }

    public List<MessageBean> getMessagesSent() {
        return messagesSent;
    }

    public List<MessageBean> getMessagesReceived() {
        return messagesReceived;
    }

    public User getAuthenticatedUser() {
        return authenticatedUser;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }
}
