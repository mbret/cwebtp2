package miage.bean;

import miage.model.ModelInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Maxime on 12/31/2014.
 */
public abstract interface BeanInterface<T extends ModelInterface> {

    public abstract void loadFromModel( T model );


}
