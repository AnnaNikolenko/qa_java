package com.example;

import java.util.List;

public class Lion {
    boolean hasMane;
    Feline feline;

    //Создан конструктор с тремя параметрами
    public Lion(String sex, Feline feline) throws Exception {
        try {
            boolean hasMane;
            if ("Самец".equals(sex)) {
                hasMane = true;
            } else if ("Самка".equals(sex)) {
                hasMane = false;
            } else {
                throw new Exception();
            }
            this.feline = feline;
            this.hasMane = hasMane;

        } catch (Exception e) {
            System.out.println("Используйте допустимые значения пола животного - самец или самка");
        }

    }

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
            return feline.getFood("Хищник");
    }
}