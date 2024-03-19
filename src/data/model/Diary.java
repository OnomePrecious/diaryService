package data.model;

import java.util.Objects;

public class Diary {
    private boolean isLocked= false;
    private String username;
    private final String password;

    public String getPassword() {
        return password;
    }

    public Diary(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public boolean unLockDiary() {
        if (Objects.equals(getPassword(), password)) {
            isLocked = true;
        }
        return true;
    }

    public boolean lockDiary() {
        if (Objects.equals(getPassword(), password)) {
            isLocked = true;
        }
        return true;
    }

    public boolean isLocked() {
        lockDiary();
        return false;
    }
}
