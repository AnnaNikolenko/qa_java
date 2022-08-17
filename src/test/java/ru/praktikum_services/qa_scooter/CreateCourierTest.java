package ru.praktikum_services.qa_scooter;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum_services.qa_scooter.pojo.Client.ApiClient;
import ru.praktikum_services.qa_scooter.pojo.Model.Courier;
import java.util.Random;

public class CreateCourierTest {
    private ApiClient client;

    @Before
    public void setUp() {
        client = new ApiClient();
    }

    @Test
    @DisplayName("Курьера можно создать")
    public void createCourierTest() {
        final Courier courier = new Courier("Anna" + new Random().nextInt(500), "1234", "saske", null, null, null);
        final Courier responseCourier = client.createCourier(courier)
                .then()
                .statusCode(201) //проверка, что возвращается код 201
                .extract().as(Courier.class);
        //Проверка, что поле ок возвращает true
        Assert.assertEquals(true, responseCourier.getOk());
    }

    @Test
    @DisplayName("Нельзя создать двух одинаковых курьеров")
    public void createCourierWithNonUniqueLogin() {
        //Задаем параметры курьера с неуникальным логином
        final Courier courier = new Courier("ninja", "1234", "saske", null, null, null);
        final Courier responseCourier = client.createCourier(courier)
                .then()
                .statusCode(409) //проверка, что возвращается код 409
                .extract().as(Courier.class);
        //Проверка, что текст поля "message" соответствует документации
        Assert.assertEquals("Этот логин уже используется", responseCourier.getMessage());
        //Проверка поля "code"
        Assert.assertEquals("409", responseCourier.getCode().toString());
    }

    @Test
    @DisplayName("Запрос без логина")
    public void createCourierWithoutLoginTest() {
        final Courier courier = new Courier(null, "1234", "saske", null, null, null);
        final Courier responseCourier = client.createCourier(courier)
                .then()
                .statusCode(400) //проверка, что возвращается код 400
                .extract().as(Courier.class);
        //Проверка, что текст поля "message" соответствует документации
        Assert.assertEquals("Недостаточно данных для создания учетной записи", responseCourier.getMessage());
        //Проверка поля "code"
        Assert.assertEquals("400", responseCourier.getCode().toString());
    }

    @Test
    @DisplayName("Запрос без пароля")
    public void createCourierWithoutPasswordTest() {
        final Courier courier = new Courier("Anna" + new Random().nextInt(50), "", "saske", null, null, null);
        final Courier responseCourier = client.createCourier(courier)
                .then()
                .statusCode(400) //проверка, что возвращается код 400
                .extract().as(Courier.class);
        //Проверка, что текст поля "message" соответствует документации
        Assert.assertEquals("Недостаточно данных для создания учетной записи", responseCourier.getMessage());
        //Проверка поля "code"
        Assert.assertEquals("400", responseCourier.getCode().toString());
    }
}