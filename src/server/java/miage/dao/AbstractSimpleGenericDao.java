package miage.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import miage.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

public class AbstractSimpleGenericDao<C,I extends Serializable> {

    public static boolean autoTransaction = true;

    Class<C> entityClass;

    {
        entityClass = (Class<C>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Transaction getTransaction(){
        return HibernateUtil.currentSession().getTransaction();
    }

    public List<C> getAll() {
        try {
            List<C> result;
            result = HibernateUtil.currentSession().createCriteria(entityClass).list();
            return result;
        } catch (HibernateException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public C get(I id) {
        try {
            return (C) HibernateUtil.currentSession().get(entityClass, id);
        } catch (HibernateException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void save(C object) {
        try {
            if( autoTransaction ){
                this.getTransaction().begin();
            }
            HibernateUtil.currentSession().saveOrUpdate(object);
            if( autoTransaction ){
                this.getTransaction().commit();
            }
        } catch (HibernateException e) {
            HibernateUtil.currentSession().getTransaction().rollback();
            e.printStackTrace();
            throw e;
        }
    }

    public void delete(I id) {
        try {
            if( autoTransaction ){
                this.getTransaction().begin();
            }
            C actual = get(id);
            HibernateUtil.currentSession().delete(actual);
            if( autoTransaction ){
                this.getTransaction().commit();
            }
        } catch (HibernateException e) {
            HibernateUtil.currentSession().getTransaction().rollback();
            e.printStackTrace();
            throw e;
        }
    }


}
