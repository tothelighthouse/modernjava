package main.java.modernjavainaction.chap05copy;

import java.awt.image.AreaAveragingScaleFilter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BuildingStreams {

    public static void main(String... args) throws Exception {


        Stream<String> stream = Stream.of("lkjlj", "ldkjlj");
        stream.map(String::toUpperCase).forEach(System.out::println);


        Stream<String> emptySt = Stream.empty();


        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.stream(nums).sum());


       Stream.iterate(0, n -> n + 2)
               .limit(10)
               .forEach(System.out::println);
       Stream.iterate(new int[]{0, 1}, t->new int[]{t[1], t[0] + t[1]});

       Stream.generate(Math::random)
               .limit(10)
               .forEach(System.out::println);
       IntStream.generate(()->1)
               .limit(5)
               .forEach(System.out::println);
       IntStream.generate(new IntSupplier() {
           @Override
           public int getAsInt() { return 0; }
       }).limit(5).forEach(System.out::println);

       IntSupplier fib = new IntSupplier() {

           private int previous = 0;
           private int current = 1;

           @Override
           public int getAsInt() {
               int nextValue = previous + current;
               previous = current;
               current = nextValue;
               return previous;
           }

       };
       IntStream.generate(fib)
               .limit(10)
               .forEach(System.out::println);
       long uniqu = Files.lines(Paths.get("ldjdlj"), Charset.defaultCharset())
               .flatMap(line -> Arrays.stream(line.split(" ")))
               .distinct()
               .count();

    }


}




































































































