package miage.bean;

import miage.model.ModelInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxime on 12/31/2014.
 */
public class BeanFactory {

    public static <H extends BeanInterface, T extends ModelInterface> H create(final Class<H> beanClass, T model) throws Exception{
        H bean = beanClass.newInstance();
        bean.loadFromModel(model);
        return bean;
    }

    public static <H extends BeanInterface, T extends ModelInterface> List<H> create(final Class<H> beanClass, List<T> models) throws Exception{
        List<H> beans = new ArrayList<>();
        for (T model : models){
            beans.add( BeanFactory.create(beanClass, model) );
        }
        return beans;
    }

}
