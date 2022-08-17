package ru.praktikum_services.qa_scooter.pojo;

import java.util.Objects;

public class AvailableStation {
    private String name;
    private String number;
    private String color;

    public AvailableStation(String name, String number, String color) {
        this.name = name;
        this.number = number;
        this.color = color;
    }

    public AvailableStation(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "AvailableStation{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvailableStation that = (AvailableStation) o;
        return Objects.equals(name, that.name) && Objects.equals(number, that.number) && Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number, color);
    }
}
