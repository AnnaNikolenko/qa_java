package com.example;

import java.util.List;

//есть интерфейс Предатор и от него имплементируется класс Feline
public interface Predator {

    //объявлен метод + у метода возможен Exception
    List<String> eatMeat() throws Exception;

}
