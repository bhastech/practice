package com.bhas.practice.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        List<String> collect = menu.stream().filter(dish -> dish.getCalories() > 300)
                                                            .map(Dish::getName)
                                                            .limit(3)
                                                            .collect(Collectors
                                                                    .toList());
        System.out.println(collect);
        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");
        System.out.println(words.stream()
                .map(String::length)
                .collect(Collectors.toList()));
        List<String> helloWorld = Arrays.asList("Hello","World");
        System.out.println(helloWorld.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct().collect(Collectors.toList()));

        List<Integer> num = Arrays.asList(1,2,3,4,5);
        System.out.println(num.stream().map(number -> number * number).collect(Collectors.toList()));


        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        System.out.println(numbers1
                .stream()
                .flatMap(num1 -> numbers2.stream()
                        .filter(num2 -> ((num1+num2)%3 == 0))
                        .map(num2 -> new int[]{num1,num2}))
                .collect(Collectors.toList()));

        System.out.println(menu.stream().anyMatch(Dish::isVegetarian));
        System.out.println(menu.stream().allMatch(dish -> dish.getCalories() < 600));
        System.out.println(menu.stream().noneMatch(dish -> dish.getCalories() < 10));

        System.out.println(num.stream().map(n -> n*n).filter(n -> n%3==0).findAny());
    }

}
