package miage.action;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;
import miage.bean.UserBean;
import miage.dao.AbstractSimpleGenericDao;
import miage.dao.CompanyDAO;
import miage.dao.ParticularDAO;
import miage.model.Company;
import miage.model.ModelFactory;
import miage.model.Particular;
import miage.model.User;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This action implement model driven interface, that way it transfer the form data into object automatically
 */
@InterceptorRef("commonStack")
@Validations
public class SignupAction extends Abstract implements ModelDriven<UserBean>, SessionAware{

    // For ModelDriven
    private UserBean beanUser = new UserBean();
    @Override
    public UserBean getModel() {
        return beanUser;
    }

    // For SessionAware
    Map<String, Object> session;
    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    private List<String> types = new ArrayList<>(); // particular / company

    @VisitorFieldValidator(message="Error on form: ")
    public UserBean getUser(){
        return beanUser;
    }

    public List<String> getTypes() {
        return types;
    }

    public SignupAction() {
        types.add("Company");
        types.add("Particular");
    }

    /**
     * This action method only display the form
     * @return
     */
    @Action(
            value="signup",
            results = {
                    @Result(name="none", location="/signup.tiles", type="tiles"),
            }
    )
    @SkipValidation
    public String displayForm(){
        return NONE;
    }

    /**
     * This action method validate the form
     * @return
     * @throws Exception
     */
    @Action(
            value = "validateSignup",
            results = {
                    @Result(name="error", location="/signup.tiles", type="tiles"),
                    @Result(name="input", location="/signup.tiles", type="tiles"),
                    @Result(name="success", type = "redirectAction", params = {
                            "namespace", "/", "actionName", "home", "message", ""
                    })
            }
    )
    public String save() throws Exception{

        // The form (bean) has been validated by struts
        // Here we just need to save it

        try {
            AbstractSimpleGenericDao dao;
            User user;
            switch( this.beanUser.getType() ){

                case "Particular":
                    user = ModelFactory.create(Particular.class, beanUser);
                    dao = new ParticularDAO();
                    break;

                case "Company":
                    if( this.beanUser.getCorporateName().isEmpty() ){
                        this.addActionError("Please write a corporate name");
                        return ERROR;
                    }
                    user = ModelFactory.create(Company.class, beanUser);
                    dao = new CompanyDAO();
                    break;

                default:
                    this.addActionError("You have to choose a type");
                    return ERROR;
            }
            dao.save( user );
            this.session.put("user", user.getId()); // save session (login)
            this.addActionMessage("User saved successful!");
            return SUCCESS;
        } catch (Exception e) {
            this.addActionError("Could not save User: " + e);
            e.printStackTrace();
            return ERROR;
        }
    }


}
