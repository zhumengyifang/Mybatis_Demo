package entity;

import java.awt.*;
import java.io.Serializable;

public class OrdersExt extends Orders implements Serializable {
    private String username;

    private String sex;

    private User user;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "id:" + getId() + ",user_id:" + getUserId() + ",number:" + getNumber() + "," + user.toString();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
