package data.model;

public class Diary {
    private boolean isLocked = true;
    private String username;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }
public Diary(String username, String password){
        this.username = username;
        this.password = password;
}
public Diary(){

}
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean setLocked(boolean status) {
        this.isLocked = status;

        return status;
    }
    public boolean lockStatus(){
        return isLocked;
    }
}
