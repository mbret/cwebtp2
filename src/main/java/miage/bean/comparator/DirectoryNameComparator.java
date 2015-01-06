package miage.bean.comparator;

import miage.bean.DirectoryBean;

import java.util.Comparator;

public class DirectoryNameComparator implements Comparator<DirectoryBean> {

    @Override
    public int compare(DirectoryBean e1, DirectoryBean e2) {
        return e1.getName().toUpperCase().compareTo(e2.getName().toUpperCase());
    }

}