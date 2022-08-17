package ru.praktikum_services.qa_scooter.pojo.Model;

import java.util.Objects;

public class Login {
    private String login;
    private String password;
    private Integer id;
    private String message;
    private Integer code;

    public Login(String login, String password, Integer id, String message, Integer code) {
        this.login = login;
        this.password = password;
        this.id = id;
        this.message = message;
        this.code = code;
    }

    public Login(){}

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Login{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                ", message='" + message + '\'' +
                ", code=" + code +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Login login1 = (Login) o;
        return Objects.equals(login, login1.login) && Objects.equals(password, login1.password) && Objects.equals(id, login1.id) && Objects.equals(message, login1.message) && Objects.equals(code, login1.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, id, message, code);
    }
}
