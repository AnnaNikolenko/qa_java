package com.example.tests;

import com.example.Animal;
import com.example.Feline;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FelineTest {

    //метод объявлен в интерфейсе Predator, переписан в Feline и зависим от Animal
    @Test
    public void EatMeatTest() throws Exception {
        Feline animal = new Feline(new Animal());
        Feline feline = new Feline();
        assertEquals(animal.getFood("Хищник"), feline.eatMeat()); }

    //метод объявлен в интерфейсе Predator,  переписан в Feline и зависим от Animal
    @Test(expected = AssertionError.class)
    public void EatMeatTestWithInvalidArgumentInGetFood() throws Exception {
        //try {
            Feline animal = new Feline(new Animal());
            Feline feline = new Feline();
            //здесь невалидный аргумент в функции getFood
            assertEquals(animal.getFood("Лето"), feline.eatMeat());
    }

        // метод объявлен в классе Animal и переписан в Feline
        @Test
        public void getFamilyTest() {
            Feline feline = new Feline();
            String expected = "Кошачьи";
            assertEquals(expected, feline.getFamily());
        }

        //метод, объявленный в  Feline, не принимает аргументы
        @Test
        public void getKittensTestWithoutArguments () {
            Feline feline = new Feline();
            int expected = 1;
            assertEquals(expected, feline.getKittens());
        }

        //метод, объявленный в  Feline, принимает аргументы
        @Test
        public void getKittensTestWithArguments () {
            Feline feline = new Feline();
            int expected = 5;
            assertEquals(expected, feline.getKittens(5));
        }
    }






