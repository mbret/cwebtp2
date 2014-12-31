package miage.model;
import miage.bean.BeanInterface;

/**
 * Created by Maxime on 12/31/2014.
 */
public interface ModelInterface<T extends BeanInterface> {

    public abstract void loadFromBean( T bean );
}
