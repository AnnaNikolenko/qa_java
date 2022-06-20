package com.example;

import java.util.List;

public class Animal {

    //объявили метод getFood + возможен Exception
    public List<String> getFood(String animalKind) throws Exception {

        try{
            //если травоядное
            if ("Травоядное".equals(animalKind)) {
                //возвращаем травку
                return List.of("Трава", "Различные растения");
                //если хищник
            } else if ("Хищник".equals(animalKind)) {
                //возвращаем рыбку
                return List.of("Животные", "Птицы", "Рыба");
                //если иное, выдаем исключение
            } else {
                throw new Exception();
            }
            //ловим и обрабатываем исключение
        } catch(Exception e){
            System.out.println("Неизвестный вид животного, используйте значение Травоядное или Хищник");
            return null;
        }
    }

    //унаследоан и переписан в классе Feline
    public String getFamily() {
        return "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
    }
}