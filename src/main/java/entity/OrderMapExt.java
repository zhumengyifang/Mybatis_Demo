package entity;

import java.util.List;

public class OrderMapExt extends Orders {
    private String username;
    private String sex;
    private User user;
    private List<OrderDeteil> orderdetails;

    public List<OrderDeteil> getOrderdetails() {
        return orderdetails;
    }

    public void setOrderdetails(List<OrderDeteil> orderdetails) {
        this.orderdetails = orderdetails;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "OrderMapExt{" + "username='" + username + '\'' + ", sex='" + sex + '\'' + ", user=" + user + ", orderdetails=" + orderdetails + '}';
    }
}