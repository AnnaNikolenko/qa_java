package com.example.tests;

import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AnimalTest {

    //проверка, выбрасывается ли исключение для метода getFood
    @Test
    public void expectedExceptionTest(){
        Exception actualException = null;
        try {
            Animal animal = new Animal();
            animal.getFood("Лето");
        } catch (Exception e){
            actualException = e;
        }
        try {
            Assert.assertNotNull(actualException);
        } catch (AssertionError e){
            System.out.println("Ожидаемое исключение AssertionError в тесте expectedExceptionTest");
        }

    }

    //тестируем метод, объявленный в Animal
    @Test
    public void getFamilyTest() {
        Animal animal = new Animal();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, animal.getFamily());
    }
}
