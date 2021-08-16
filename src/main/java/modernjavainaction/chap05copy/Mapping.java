package main.java.modernjavainaction.chap05copy;

import main.java.modernjavainaction.chap04.Dish;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static main.java.modernjavainaction.chap04.Dish.menu;

public class Mapping{

  public static void main(String... args) {





   List<String> dn = menu.stream()
           .map(Dish::getName)
           .collect(Collectors.toList());

      System.out.println(dn);


      List<String> words = Arrays.asList("he", "he", "he", "he", "he");
      List<Integer> wordl = words.stream()
              .map(String::length)
              .collect(Collectors.toList());
      System.out.println(wordl);


      words.stream()
              .flatMap((String line)-> Arrays.stream(line.split("")))
              .distinct()
              .forEach(System.out::println);

      List<Integer> n1 = Arrays.asList(1,2,3);
      List<Integer> n2 = Arrays.asList(1,2,3);

      List<int[]> pairs = n1.stream()
            .flatMap((Integer i)-> n2.stream().map((Integer j)-> new int[]{i, j}))
            .filter(pair -> (pair[0] + pair[1]) % 3 == 0)
            .collect(Collectors.toList());

      pairs.forEach(pair -> System.out.println(pair[0] + pair[1]));
      pairs.stream().forEach(pair -> System.out.println(pair[0] + pair[1]));


  }

}















































































































