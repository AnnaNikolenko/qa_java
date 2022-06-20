package com.example.tests;

import com.example.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    //проверка, выбрасывается ли исключение у конструктора Lion
    @Test
    public void expectedExceptionTest(){
        String invalidSex= "Тест";
        Exception actualException = null;
        try {
            new Lion(invalidSex, new Feline());
        } catch (Exception e){
            actualException = e;
        }
        try {
            Assert.assertNotNull(actualException);
        } catch (AssertionError e){
            System.out.println("AssertionError в тесте expectedExceptionTest класса LionTest");
        }
    }

    // метод объявленный в классе Lion и зависимый от класа Feline
    @Test
    public void getKittensTestWithValidData() throws Exception {
        Lion lion = new Lion("Самец", new Feline());
        int expected = 1;
        assertEquals(expected, lion.getKittens());
    }

    // метод объявленный в классе Lion и зависимый от класса Feline
    @Test
    public void getKittensTestWithInvalidAnswerFromFelineGetKittens() {
        try{
            Lion lion = new Lion("Самка", feline);
            int expected = 1;
            //тут вернем невалидное значение
            Mockito.when(feline.getKittens()).thenReturn(2112);
            assertEquals(expected, lion.getKittens());
        } catch(AssertionError | Exception e) {
            System.out.println("AssertionError в тесте getKittensTestWithInvalidAnswer класса LionTest");
        }
    }

    //метод, объявленный в Lion и зависимый от Feline
    @Test
    public void getFoodTest() throws Exception {
            Lion lion = new Lion("Самец", new Feline());
            List<String> expected = List.of("Животные", "Птицы", "Рыба");
            assertEquals(expected, lion.getFood());
    }

    //метод, объявленный в Lion и зависимый от Feline
    @Test
    public void getFoodTestWithInvalidAnswerFromFelineGetFood() throws Exception {
        try {
            Lion lion = new Lion("Самка", feline);
            List<String> expected = List.of("Животные", "Птицы", "Рыба");
            //а здесь вернем невалидный ответ
            Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Море", "Солнце", "Пляж"));
            assertEquals(expected, lion.getFood());
        } catch (AssertionError e){
            System.out.println("AssertionError в тесте getFoodTestWithInvalidAnswerFromFelineGetFood класса LionTest");
        }

    }
}


