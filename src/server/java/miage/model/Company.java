package miage.model;

/**
 * Created by Maxime on 12/30/2014.
 */
public class Company extends User{

    private String corporateName;

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }
}
