package xyz.leeyangy.pojo;

/**
 * @Author liyangyang
 * @Date: 2023/05/14 16:34
 * @Package xyz.leeyangy.pojo
 * @Version 1.0
 * @Description: 登录用户实体类
 */


public class LoginUser {

    private String username;
    private String password;

    public LoginUser() {
    }

    public LoginUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
