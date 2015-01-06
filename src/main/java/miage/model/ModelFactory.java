package miage.model;

import miage.bean.BeanInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxime on 12/31/2014.
 */
public class ModelFactory {

    /**
     * Create a model with a bean
     * @param modelClass
     * @param bean
     * @param <H>
     * @return
     * @throws Exception
     */
    public static <H extends ModelInterface, T extends BeanInterface> H create(final Class<H> modelClass, T bean) throws Exception{
        H model = modelClass.newInstance();
        model.loadFromBean( bean );
        return model;
    }

    public static <H extends ModelInterface, T extends BeanInterface> List<H> create(final Class<H> modelClass, List<T> beans) throws Exception{
        List<H> models = new ArrayList<>();
        for (T bean : beans){
            models.add( ModelFactory.create(modelClass, bean) );
        }
        return models;
    }

}
