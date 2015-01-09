package miage.action.Directory;

import miage.action.Abstract;
import miage.bean.BeanFactory;
import miage.bean.DirectoryBean;
import miage.dao.DirectoryDAO;
import org.apache.struts2.convention.annotation.*;
import org.apache.struts2.util.SubsetIteratorFilter.Decider;

import java.util.List;

/**
 * Created by Maxime on 12/31/2014.
 */
@Namespace("/directories")
@Result(name="success", location="/directories.tiles", type = "tiles")
public class ListAction extends Abstract{

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ListAction.class);

    DirectoryDAO dao = new DirectoryDAO();

    List<DirectoryBean> directories;

    public List<DirectoryBean> getDirectories() {
        return directories;
    }

    public void setDirectories(List<DirectoryBean> directories) {
        this.directories = directories;
    }

    @Actions({
            @Action(""),
            @Action("list"),
    })
    public String execute() throws Exception{

        this.directories = BeanFactory.create( DirectoryBean.class, dao.getAll() );

        return SUCCESS;
    }

    /**
     * Return a decider for all directories that have more than 2 users
     * @return
     */
    public Decider getUsersDecider(){
        return new Decider() {
            @Override
            public boolean decide(Object o) throws Exception {
                DirectoryBean directory = (DirectoryBean)o;
                System.out.println(directory);
                return directory.getNbUsers() > 2;
            }
        };
    }
}
