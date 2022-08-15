package ru.praktikum_services.qa_scooter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum_services.qa_scooter.pojo.ApiClient;
import ru.praktikum_services.qa_scooter.pojo.GetOrders;

public class GetOrdersTest {
    private ApiClient client;
    private Integer clientId;

    @Before
    public void setUp(){
        client = new ApiClient();
    }

    /** Получить список заказов */
    @Test
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
