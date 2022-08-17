package ru.praktikum_services.qa_scooter.pojo.Model;

import java.util.Objects;

public class DeleteCourier {
    private Integer id;
    private Boolean ok;

    public DeleteCourier(Integer id, Boolean ok) {
        this.id = id;
        this.ok = ok;
    }

    public DeleteCourier(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeleteCourier that = (DeleteCourier) o;
        return Objects.equals(id, that.id) && Objects.equals(ok, that.ok);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ok);
    }
}
