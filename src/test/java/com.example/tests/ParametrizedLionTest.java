package com.example.tests;

import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParametrizedLionTest {

    //поля класса: для проверяемой строки и ожидаемого результата
    private final String sex;
    private final boolean expected;

    // конструктор с двумя параметрами
    public ParametrizedLionTest(String sex, boolean expected){
        this.sex = sex;
        this.expected = expected;
    }

    // метод для получения тестовых данных
    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][]{
                {"Самец", true },
                {"Самка", false },
                {"?", false },
        };
    }

    // тестируем метод doesHaveMane, объявленный в Lion + конструктор Lion
    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(sex, new Feline());
            boolean actual = lion.doesHaveMane();
            assertEquals(expected, actual);
    }
}
