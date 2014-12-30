package miage.beans;

/**
 * Created by Maxime on 12/29/2014.
 */
public class User {

    private String id;
    private String password;
    private String login;
    private String email;

    public User() {
    }

    public static boolean isValid(User user){
        return false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
