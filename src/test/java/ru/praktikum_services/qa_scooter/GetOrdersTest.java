package ru.praktikum_services.qa_scooter;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum_services.qa_scooter.pojo.Client.ApiClient;
import ru.praktikum_services.qa_scooter.pojo.Model.GetOrders;

public class GetOrdersTest {
    private ApiClient client;

    @Before
    public void setUp() {
        client = new ApiClient();
    }

    @Test
    @DisplayName("Получить список заказов")
    public void getOrderListTest() {
        final GetOrders responseAllOrders = client.getOrders()
                .then()
                .statusCode(200) //проверка, что возвращается код 200
                .extract().as(GetOrders.class);
        //Проверка, что список заказов не пустой
        Assert.assertNotNull(responseAllOrders.getOrders());
        Assert.assertNotNull(responseAllOrders.getPageInfo());
        Assert.assertNotNull(responseAllOrders.getAvailableStations());
    }
}
