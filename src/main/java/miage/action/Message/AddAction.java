package miage.action.Message;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;
import miage.action.Abstract;
import miage.bean.AuthUserBean;
import miage.bean.BeanFactory;
import miage.bean.MessageBean;
import miage.bean.UserBean;
import miage.dao.AuthDAO;
import miage.dao.MessageDAO;
import miage.dao.UserDAO;
import miage.interceptor.AuthenticatedUserAware;
import miage.model.Message;
import miage.model.ModelFactory;
import miage.model.User;
import miage.util.DatabaseInitializerListener;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Maxime on 12/31/2014.
 */
@Namespace("/messages/add")
public class AddAction extends AbstractAction implements ModelDriven<MessageBean>, AuthenticatedUserAware, SessionAware{

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(DatabaseInitializerListener.class);

    // For ModelDriven
    private MessageBean messageBean = new MessageBean();
    @Override
    public MessageBean getModel() {
        return messageBean;
    }
    @VisitorFieldValidator(message="Error on form: ")
    public MessageBean getUser(){
        return messageBean;
    }

    // For SessionAware
    Map<String, Object> session;
    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    // For AuthenticatedUserAware
    private User authenticatedUser = null;
    @Override
    public void setUser(User authenticatedUser) {
        this.authenticatedUser = authenticatedUser;
    }


    private MessageDAO messageDAO = new MessageDAO();
    private UserDAO userDAO = new UserDAO();
    private Map<Long, String> destinatorList = new HashMap();

    public AddAction() throws Exception {
        // Fill select
        // We fill select here because we need it in the two actions
        List<User> users = userDAO.getAll();
        for( User user: users){
            this.destinatorList.put(user.getId(), user.getEmail());
        }
    }

    /**
     * Display message form
     * @return
     * @throws Exception
     */
    @Action(
            value="form",
            results = {
                    @Result(name="none", location="/WEB-INF/pages/messages-add.jsp"),
                    @Result(name="error", type = "redirectAction", params = {
                            "namespace", "/", "actionName", "home"
                    })
            }
    )
    @SkipValidation
    public String display() throws Exception{
        return NONE;
    }

    /**
     * This action method validate the form
     * @return
     * @throws Exception
     *
     */
    @Action(
            value = "send",
            results = {
                    @Result(name="error", location="/WEB-INF/pages/messages-add.jsp"),
                    @Result(name="input", location="/WEB-INF/pages/messages-add.jsp"),
                    @Result(name="success", type = "redirectAction", params = {
                            "namespace", "/", "actionName", "home", "message", ""
                    })
            }
    )
    public String execute() throws Exception{

        try {
            Message message = ModelFactory.create(Message.class, this.messageBean);

            message.setTo( userDAO.get( Long.parseLong(this.messageBean.getDestinator())) );
            message.setFrom( this.authenticatedUser );

            messageDAO.save( message );

            return SUCCESS;

        } catch (Exception e) {
            this.addActionError("Could not send message: " + e.getMessage());
            e.printStackTrace();
            return ERROR;
        }

    }


    public Map<Long, String> getDestinatorList() {
        return destinatorList;
    }
}