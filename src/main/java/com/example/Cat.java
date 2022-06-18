package com.example;

import java.util.List;

public class Cat {

    //объявили переменную predator интерфейса Predator
   Predator predator;

    //объявили конструктор для методов, зависимых от другого класса/интерфейса
    public Cat(Feline feline) {
        this.predator = feline;
    }

    //пустой конструктор для метода, независимого от других классов/интерфейса
    public Cat(){}

    //объявили метод
    public String getSound() {
        return "Мяу";
    }

    //объявили метод
    public List<String> getFood() throws Exception {
            return predator.eatMeat();}
        }

