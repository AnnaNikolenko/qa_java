package ru.praktikum_services.qa_scooter.pojo.Client;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import ru.praktikum_services.qa_scooter.pojo.Model.Courier;
import ru.praktikum_services.qa_scooter.pojo.Model.CreateOrder;
import ru.praktikum_services.qa_scooter.pojo.Model.Login;

public class ApiClient {
    public static final String BASE_URL = "https://qa-scooter.praktikum-services.ru";
    private final Filter requestFilter = new RequestLoggingFilter();
    private final Filter responseFilter = new ResponseLoggingFilter();

    @Step("Объявлен метод создания курьера, отправляющий запрос на сервер")
    public Response createCourier(Courier courier) {
        return RestAssured.with()
                .filters(requestFilter, responseFilter)
                .baseUri(BASE_URL)
                .body(courier)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .post("/api/v1/courier");
    }

    @Step("Объявлен метод логина курьера в системе, отправляющий запрос на сервер")
    public Response loginCourier(Login login) {
        return RestAssured.with()
                .filters(requestFilter, responseFilter)
                .baseUri(BASE_URL)
                .body(login)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .post("/api/v1/courier/login");
    }

    @Step("Объявлен метод удаления созданного курьера, отправляющий запрос на сервер")
    public void deleteCourier(Integer id) {
        RestAssured.with()
                .filters(requestFilter, responseFilter)
                .baseUri(BASE_URL)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .delete("/api/v1/courier/" + id);
    }

    @Step("Объявлен метод создания заказа, отправляющий запрос на сервер")
    public Response createOrder(CreateOrder order) {
        return RestAssured.with()
                .filters(requestFilter, responseFilter)
                .baseUri(BASE_URL)
                .body(order)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .post("/api/v1/orders");
    }

    @Step("Объявлен метод получения списка заказов, отправляющий запрос на сервер")
    public Response getOrders() {
        return RestAssured.with()
                .filters(requestFilter, responseFilter)
                .baseUri(BASE_URL)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .get("/api/v1/orders");
    }
}
