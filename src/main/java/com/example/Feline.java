package com.example;

import java.util.List;

//класс Feline наследуется от суперкласса Animal и имплементируется от интерфейса Predator
public class Feline extends Animal implements Predator {

    Animal animal;
    public Feline(Animal animal) { this.animal = animal;}
    public Feline() {}

    @Override
    //метод объявлен в интерфейсе Predator,  переписан в Feline и зависим от Animal
    public List<String> eatMeat() throws Exception {
                return getFood("Хищник");}

    //метод объявлен в классе Animal
    @Override
    public String getFamily() {
        return "Кошачьи";
    }

    //объявлен метод, который не принимает аргументы
    public int getKittens() {
        return getKittens(1);
    }

    //объявлен метод, который принимает аргументы
    public int getKittens(int kittensCount) {
        return kittensCount;
    }

}
