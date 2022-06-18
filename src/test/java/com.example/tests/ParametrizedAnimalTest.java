package com.example.tests;

import com.example.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class ParametrizedAnimalTest {

    //поля класса: для проверяемой строки и ожидаемого результата
    private final String animalKind;
    private final List<String> expected;

    // конструктор с двумя параметрами
    public ParametrizedAnimalTest(String animalKind, List<String> expected){
        this.animalKind = animalKind;
        this.expected = expected;
    }

    // метод для получения тестовых данных
    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
                {"Лето", List.of("Солнце", "Море", "Пляж")},
        };
    }

    //тестируем
    @Test
    public void getFoodTest() throws Exception {
        try{
            Animal animal = new Animal();
            List<String> actual = animal.getFood(animalKind);
            assertEquals(expected, actual);
        } catch (AssertionError e){
            System.out.println("AssertionError в тесте getFoodTest() класса ParametrizedAnimalTest");
        }
    }
}
