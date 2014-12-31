package miage.bean.comparator;

import miage.bean.Directory;

import java.util.Comparator;

public class DirectoryNbUsersComparator implements Comparator<Directory> {

    @Override
    public int compare(Directory e1, Directory e2) {
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