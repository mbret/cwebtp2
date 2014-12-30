package miage.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import miage.util.HibernateUtil;
import org.hibernate.HibernateException;

public class AbstractSimpleGenericDao<C,I extends Serializable> {

    Class<C> entityClass;


    {
        entityClass = (Class<C>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public List<C> getAll() {
        try {
            return HibernateUtil.currentSession().createCriteria(entityClass).list();
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
            HibernateUtil.currentSession().beginTransaction();
            HibernateUtil.currentSession().saveOrUpdate(object);
            HibernateUtil.currentSession().getTransaction().commit();
        } catch (HibernateException e) {
            HibernateUtil.currentSession().getTransaction().rollback();
            e.printStackTrace();
            throw e;
        }
    }

    public void delete(I id) {
        try {
            C actual = get(id);
            HibernateUtil.currentSession().beginTransaction();
            HibernateUtil.currentSession().delete(actual);
            HibernateUtil.currentSession().getTransaction().commit();
        } catch (HibernateException e) {
            HibernateUtil.currentSession().getTransaction().rollback();
            e.printStackTrace();
            throw e;
        }
    }
}
