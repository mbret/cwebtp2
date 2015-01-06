package miage.interceptor;

import miage.bean.AuthUserBean;
import miage.model.User;

/**
 * Created by Maxime on 12/31/2014.
 */
public interface AuthenticatedUserAware {

    public void setUser(User authenticatedUser);

}
