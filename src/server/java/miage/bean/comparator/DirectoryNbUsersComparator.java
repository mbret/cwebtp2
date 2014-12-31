package miage.bean.comparator;

import miage.bean.DirectoryBean;

import java.util.Comparator;

public class DirectoryNbUsersComparator implements Comparator<DirectoryBean> {

    @Override
    public int compare(DirectoryBean e1, DirectoryBean e2) {
        if ( e1.getUsers().size() > e2.getUsers().size() ){
            return 1;
        }
        else if ( e1.getUsers().size() < e2.getUsers().size() ){
            return -1;
        }
        else{
            return 0;
        }
    }

}