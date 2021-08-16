package main.java.modernjavainaction.chap05copy;

import main.java.modernjavainaction.chap04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static main.java.modernjavainaction.chap04.Dish.menu;

public class Filtering {

  public static void main(String... args) {

   List<Dish> vege = menu.stream()
           .filter(Dish::isVegetarian)
           .collect(Collectors.toList());

   vege.forEach(System.out::println);

   List<Integer> num = Arrays.asList(1,2,3,4,4);
   num.stream()
           .filter(i -> i % 2 == 0)
           .distinct()
           .forEach(System.out::println);

List<Dish> specialMenu = Arrays.asList(
  new Dish("season fruit", true, 120, Dish.Type.OTHER),
  new Dish("prawns", false, 300, Dish.Type.FISH),
  new Dish("rice", true, 350, Dish.Type.OTHER),
  new Dish("chicken", false, 400, Dish.Type.MEAT),
  new Dish("french fries", true, 530, Dish.Type.OTHER));



    List<Dish> fmenu = specialMenu.stream()
            .filter(dish -> dish.getCalories() < 320)
            .collect(Collectors.toList());
    fmenu.forEach(System.out::println);




    specialMenu.stream()
        .takeWhile(dish -> dish.getCalories() < 320)
        .collect(Collectors.toList());

    fmenu.forEach(System.out::println);
    fmenu.stream()
            .dropWhile(d -> d.getCalories() > 300)
            .collect(Collectors.toList());

    menu.stream()
            .filter(d -> d.getCalories() > 300)
            .limit(3)
            .collect(Collectors.toList());

    menu.stream().forEach(System.out::println);

    menu.stream()
            .filter(d -> d.getCalories() > 300)
            .skip(2)
            .collect(Collectors.toList());
    menu.stream().forEach(System.out::println);























  }

}
