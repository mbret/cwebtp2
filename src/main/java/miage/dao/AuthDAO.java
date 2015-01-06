package miage.dao;

//import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
//import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import miage.bean.AuthUserBean;
import miage.model.User;
import miage.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxime on 12/30/2014.
 */
public class AuthDAO extends AbstractSimpleGenericDao<User, Long>{


    /**
     *
     * @param authUser
     * @return
     */
    public User checkAuth(AuthUserBean authUser){

        try {
           return (User) HibernateUtil.currentSession().createQuery("from User where email = :email AND password = :password")
                    .setString("email", authUser.getEmail())
                    .setString("password", authUser.getPassword()).uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw e;
        }

    }

}
