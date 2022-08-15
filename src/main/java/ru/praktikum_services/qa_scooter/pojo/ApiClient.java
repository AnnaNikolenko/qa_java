package ru.praktikum_services.qa_scooter.pojo;

import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ApiClient {
    public static final String BASE_URL = "https://qa-scooter.praktikum-services.ru";
    private final Filter requestFilter = new RequestLoggingFilter();
    private final Filter responseFilter = new ResponseLoggingFilter();

    /**
     * Объявлен метод создания курьера, отправляющий запрос на сервер
     */
    public Response createCourier(Courier courier) {
        return RestAssured.with()
                .filters(requestFilter, responseFilter)
                .baseUri(BASE_URL)
                .body(courier)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .post("/api/v1/courier");
    }

    /**
     * Объявлен метод логина курьера в системе, отправляющий запрос на сервер
     */
    public Response loginCourier(Login login) {
        return RestAssured.with()
                .filters(requestFilter, responseFilter)
                .baseUri(BASE_URL)
                .body(login)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .post("/api/v1/courier/login");
    }

    /**
     * Объявлен метод удаления созданного курьера, отправляющий запрос на сервер
     */

    public Response deleteCourier(Integer id) {
        return RestAssured.with()
                .filters(requestFilter, responseFilter)
                .baseUri(BASE_URL)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .delete("/api/v1/courier/" + id);
    }

    /**
     * Объявлен метод создания заказа, отправляющий запрос на сервер
     */

    public Response createOrder(CreateOrder order) {
        return RestAssured.with()
                .filters(requestFilter, responseFilter)
                .baseUri(BASE_URL)
                .body(order)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .post("/api/v1/orders");
    }

    /**
     * Объявлен метод получения списка заказов, отправляющий запрос на сервер
     */

    public Response getOrders() {
        return RestAssured.with()
                .filters(requestFilter, responseFilter)
                .baseUri(BASE_URL)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .get("/api/v1/orders");
    }
}
