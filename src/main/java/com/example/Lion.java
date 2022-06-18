package com.example;

import java.util.List;

public class Lion {
    boolean hasMane;
    Feline feline;
    Animal animal;

    List<String> result;

    //Создан конструктор с двумя параметрами
    public Lion(String sex, Feline feline) throws Exception {
        try {
            if ("Самец".equals(sex)) {
                hasMane = true;
            } else if ("Самка".equals(sex)) {
                hasMane = false;
            } else {
                throw new Exception();
            }
            this.feline = feline;

        } catch (Exception e) {
            System.out.println("Используйте допустимые значения пола животного - самец или самка");
        }

    }

    //внедрение зависимости feline через конструктор
    public Lion(Feline feline) {
        this.feline = feline;
    }

    public Lion() {}

    //объявили метод
    public int getKittens() {
        return feline.getKittens();
    }

    //объявили метод
    public boolean doesHaveMane() {
        return hasMane;
    }

    //объявили метод
    public List<String> getFood() throws Exception {
        try {
            return feline.getFood("Хищник");
        }
        catch (Exception e){
            System.out.println("Ошибка при вызове функции getFood в классе Lion");
            return null;
        }

    }
}