package miage.dao;

//import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
//import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import miage.model.User;
import miage.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxime on 12/30/2014.
 */
public class AuthDAO {

//    @SessionTarget
//    Session session;
//
//    @TransactionTarget
//    Transaction transaction;

    public User checkAuth(miage.bean.AuthUser authUser){
        miage.model.User user = (User) HibernateUtil.currentSession().createQuery("from User where email = :email AND mdp = :password")
                .setString("email", authUser.getEmail())
                .setString("password", authUser.getPassword()).uniqueResult();
        if(user == null ) return null;
        else return user;
    }

}
