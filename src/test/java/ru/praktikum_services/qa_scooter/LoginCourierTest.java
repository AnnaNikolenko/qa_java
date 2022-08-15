package ru.praktikum_services.qa_scooter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum_services.qa_scooter.pojo.ApiClient;
import ru.praktikum_services.qa_scooter.pojo.Courier;
import ru.praktikum_services.qa_scooter.pojo.Login;

public class LoginCourierTest {
    private ApiClient client;
    private Integer clientId;

    /** Перед запуском каждого теста создаем курьера */
    @Before
    public void setUp(){
        client = new ApiClient();
        final Courier courier = new Courier("Mia", "1234", "saske", null, null, null);
        client.createCourier(courier);
    }

    /** Курьер может авторизоваться */
    @Test
    public void loginTest(){
        //передаем параметры для авторизации
       final Login login = new Login("Mia", "1234", null, null, null);

        //авторизуемся
       final Login responseLogin = client.loginCourier(login)
               .then()
               .statusCode(200)//проверка, что возвращается код 200
               .extract().as(Login.class);
       //получаем сгенерированный айдишник
       clientId = responseLogin.getId();
        //проверяем, что сгенерировался id
        Assert.assertNotNull(clientId);
    }

    /** Авторизация без логина (обязательное поле) */
    @Test
    public void loginIsNotEnteredTest(){
        //передаем параметры для авторизации
        final Login login = new Login("", "1234", null, null, null);

        //логинимся
        final Login responseLogin = client.loginCourier(login)
                .then()
                .statusCode(400)//проверка, что возвращается код 400
                .extract().as(Login.class);
       //проверяем сообщение об ошибке
        Assert.assertEquals("Недостаточно данных для входа", responseLogin.getMessage());
        //проверка поля "code"
        Assert.assertEquals("400", responseLogin.getCode().toString());
    }

    /** Авторизация без пароля (обязательное поле) */
    @Test
    public void passwordIsNotEnteredTest(){
        //передаем параметры авторизации
        final Login login = new Login("Mia", "", null, null, null);

        //логинимся
        final Login responseLogin = client.loginCourier(login)
                .then()
                .statusCode(400)//проверка, что возвращается код 400
                .extract().as(Login.class);
        //проверяем сообщение об ошибке
        Assert.assertEquals("Недостаточно данных для входа", responseLogin.getMessage());
        //проверка поля "code"
        Assert.assertEquals("400", responseLogin.getCode().toString());
    }

    /** Система вернёт ошибку, если неправильно указать логин */
    @Test
    public void enterInvalidLoginTest(){
        //передаем параметры авторизации
        final Login login = new Login("Miiii", "1234", null, null, null);

        //логинимся
        final Login responseLogin = client.loginCourier(login)
                .then()
                .statusCode(404)//проверка, что возвращается код 404
                .extract().as(Login.class);
        //проверяем сообщение об ошибке
        Assert.assertEquals("Учетная запись не найдена", responseLogin.getMessage());
        //Проверка, поля "code"
        Assert.assertEquals("404", responseLogin.getCode().toString());
    }

    /** Система вернёт ошибку, если неправильно указать пароль */
    @Test
    public void enterInvalidPasswordTest(){
        //передаем параметры авторизации
        final Login login = new Login("Mia", "12345678", null, null, null);

        //логинимся
        final Login responseLogin = client.loginCourier(login)
                .then()
                .statusCode(404)//проверка, что возвращается код 404
                .extract().as(Login.class);
        //проверяем сообщение об ошибке
        Assert.assertEquals("Учетная запись не найдена", responseLogin.getMessage());
        //Проверка поля "code"
        Assert.assertEquals("404", responseLogin.getCode().toString());
    }

    /** Авторизоваться под несуществующим пользователем */
    @Test
    public void enterNonexistentLoginAndPasswordTest(){
        //передаем параметры авторизации
        final Login login = new Login("Qaqaqa", "4321", null, null, null);

        //логинимся
        final Login responseLogin = client.loginCourier(login)
                .then()
                .statusCode(404)//проверка, что возвращается код 404
                .extract().as(Login.class);
        //проверяем сообщение об ошибке
        Assert.assertEquals("Учетная запись не найдена", responseLogin.getMessage());
        //Проверка поля "code"
        Assert.assertEquals("404", responseLogin.getCode().toString());
    }


    /** После каждого теста удаляем созданного курьера */
    @After
    public void deleteOfCreatedCourierById(){
        client.deleteCourier(clientId);
    }

}
