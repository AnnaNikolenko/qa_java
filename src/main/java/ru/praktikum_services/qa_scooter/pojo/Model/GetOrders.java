package ru.praktikum_services.qa_scooter.pojo.Model;

import ru.praktikum_services.qa_scooter.pojo.Util.AvailableStation;
import ru.praktikum_services.qa_scooter.pojo.Util.Order;
import ru.praktikum_services.qa_scooter.pojo.Util.PageInfo;

import java.util.List;
import java.util.Objects;

public class GetOrders {
    private List<Order> orders;
    private PageInfo pageInfo;
    private List<AvailableStation> availableStations;
    private String message;

    public GetOrders(List<Order> orders, PageInfo pageInfo, List<AvailableStation> availableStations, String message) {
        this.orders = orders;
        this.pageInfo = pageInfo;
        this.availableStations = availableStations;
        this.message = message;
    }

    public GetOrders(){}

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<AvailableStation> getAvailableStations() {
        return availableStations;
    }

    public void setAvailableStations(List<AvailableStation> availableStations) {
        this.availableStations = availableStations;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "GetOrders{" +
                "orders=" + orders +
                ", pageInfo=" + pageInfo +
                ", availableStations=" + availableStations +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetOrders getOrders = (GetOrders) o;
        return Objects.equals(orders, getOrders.orders) && Objects.equals(pageInfo, getOrders.pageInfo) && Objects.equals(availableStations, getOrders.availableStations) && Objects.equals(message, getOrders.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orders, pageInfo, availableStations, message);
    }
}
