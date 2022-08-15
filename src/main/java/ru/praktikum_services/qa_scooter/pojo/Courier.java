package ru.praktikum_services.qa_scooter.pojo;

import java.util.Objects;

public class Courier {

    private String login;
    private String password;
    private String firstName;
    private Boolean ok;
    private String message;
    private Integer code;

    public Courier(String login, String password, String firstName, Boolean ok, String message, Integer code) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.ok = ok;
        this.message = message;
        this.code = code;
    }

    public Courier() {
    }

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Boolean getOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
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
        return "Courier{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", ok=" + ok +
                ", message='" + message + '\'' +
                ", code=" + code +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Courier courier = (Courier) o;
        return Objects.equals(login, courier.login) && Objects.equals(password, courier.password) && Objects.equals(firstName, courier.firstName) && Objects.equals(ok, courier.ok) && Objects.equals(message, courier.message) && Objects.equals(code, courier.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, firstName, ok, message, code);
    }
}


