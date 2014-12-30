package miage.dao;

import miage.model.User;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

//import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
//import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

/**
 * Created by Maxime on 12/30/2014.
 */
public class UserDAO extends AbstractSimpleGenericDao<User, Long>{

//    @SessionTarget
//    Session session;
//
//    @TransactionTarget
//    Transaction transaction;

//    @SuppressWarnings("unchecked")
//    public List<User> getUsers()
//    {
//        List<User> users = new ArrayList<User>();
//        try
//        {
//            users = session.createQuery("from User").list();
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
//        return users;
//    }

//    public void addUser(User user)
//    {
//        System.out.println(session);
//        session.save(user);
//    }
}
