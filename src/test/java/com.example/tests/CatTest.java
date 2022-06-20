package com.example.tests;

import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline feline;

    //метод, объявленный в классе Cat
    @Test
    public void getSoundTest() {
        Cat cat = new Cat();
        String expected = "Мяу";
        assertEquals(expected, cat.getSound()); }

    //метод, объявленный в классе Cat, зависимый от класса Feline
    @Test
    public void getFoodTest() throws Exception {
        //внедрили зависимость через конструктор
        Cat cat = new Cat(new Feline());
        //объявили ожидаемый результат
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        //сверили результат с ожидаемым
        assertEquals(expected, cat.getFood()); }

    @Test
    public void getFoodTestWithInvalidAnswerFromFelineEatMeat() throws Exception {
            try{
                //использовали мок
                Cat cat = new Cat(feline);
                //объявили ожидаемый результат
                List<String> expected = List.of("Животные", "Птицы", "Рыба");
                //задали НЕвалидный ответ при вызове функции eatMeat
                Mockito.when(feline.eatMeat()).thenReturn(List.of("Тут", "невалидные", "данные"));
                //сверили результат с ожидаемым
                assertEquals(expected, cat.getFood());
            } catch (AssertionError e){
                System.out.println("Ошибка AssertionError в тесте getFoodTestWithInvalidAnswerFromFelineEatMeat класса CatTest");
            }

    }

}
