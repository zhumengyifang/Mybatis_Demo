package entity;

public class OrdersExt extends Orders {
    private String username;

    private String sex;

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
        return "OrdersExt{" + "username='" + username + '\'' + ", sex='" + sex + '\'' + '}';
    }
}
