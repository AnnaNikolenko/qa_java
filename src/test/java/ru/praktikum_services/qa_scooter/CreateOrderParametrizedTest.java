package ru.praktikum_services.qa_scooter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum_services.qa_scooter.pojo.ApiClient;
import ru.praktikum_services.qa_scooter.pojo.CreateOrder;

import java.util.List;

@RunWith(Parameterized.class)
public class CreateOrderParametrizedTest {

    private ApiClient client;

    @Before
    public void setUp(){
        client = new ApiClient();

    }

    //поля класса: для проверяемой строки и ожидаемого результата
    private final String firstName;
    private final String lastName;
    private final String address;
    private final Integer metroStation;
    private final String phone;
    private final Integer rentTime;
    private final String deliveryDate;
    private final String comment;
    private final List<String> color;
    private final Integer track;

    // конструктор с параметрами
    public CreateOrderParametrizedTest(String firstName, String lastName, String address, Integer metroStation, String phone, Integer rentTime, String deliveryDate, String comment, List<String> color, Integer track) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
        this.color = color;
        this.track = track;
    }


    // метод для получения тестовых данных
    @Parameterized.Parameters(name = "{index} ==> Тестовые данные: {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}")
    public static Object[][] getTestData(){
        return new Object[][]{
                {"Mia", "Zaiceva", "Test address", 4, "+79500116129", 1, "2020-06-06", "Mia, come back to Konoha!", List.of("BLACK"), null},
                {"Mia", "Zaiceva", "Test address", 4, "+79500116129", 1, "2020-06-06", "Mia, come back to Konoha!", List.of("GREY"), null},
                {"Mia", "Zaiceva", "Test address", 4, "+79500116129", 1, "2020-06-06", "Mia, come back to Konoha!", List.of("BLACK", "GREY"), null},
                {"Mia", "Zaiceva", "Test address", 4, "+79500116129", 1, "2020-06-06", "Mia, come back to Konoha!", null, null}
        };
    }


    /** Тестируем */
    @Test
    public void createOrder() {
        //параметры заказа
        final CreateOrder order = new CreateOrder(firstName, lastName, address, metroStation, phone, rentTime, deliveryDate, comment, color, track);

        final CreateOrder responseOrder = client.createOrder(order)
                .then()
                .statusCode(201) //проверка, что возвращается код 201
                .extract().as(CreateOrder.class);
        //Проверка, что поле "track" не пустое
        Assert.assertNotNull(responseOrder.getTrack());
    }



}
