package miage.bean.comparator;

import miage.bean.Directory;

import java.util.Comparator;

public class DirectoryNameComparator implements Comparator<Directory> {

    @Override
    public int compare(Directory e1, Directory e2) {
        return e1.getName().toUpperCase().compareTo(e2.getName().toUpperCase());
    }

}