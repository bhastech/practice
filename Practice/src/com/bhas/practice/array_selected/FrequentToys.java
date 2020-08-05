package com.bhas.practice.array_selected;

import java.util.*;

public class FrequentToys {

    public static void main(String[] args) {
        String[] quotes = new String[]{"Elmo is the hottest toy of the season! Elmo will be on every kid's whitelist",
                "The new Elmo dolls are super high quality", "Except the Elsa doll to be very popular this year", "Elsa and Elmo are the toys I will be buying",
                "For parents older kids, look into buying them a drone", "Warcarft is slowly rising popularty","Elsa quality is good"};

        String[] toys = new String[]{"Elsa", "Elmo", "drone", "legos", "warcraft", "tablet"};

        int topToys = 2;

        List<String> topToysList = getTopToys(quotes, toys, topToys);

        System.out.println(topToysList);

        String[] excludeWords = new String[]{"be","is","are","will"};


    }

    private static List<String> getTopToys(String[] quotes, String[] toys, int topToys) {
        List<String> topToysList = new ArrayList<>();
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String quote : quotes) {
            String[] str = quote.split(" ");
            for (String word : str) {
                if (word != null && frequencyMap.containsKey(word)) {
                    Integer integer = frequencyMap.get(word);
                    frequencyMap.put(word, ++integer);
                } else {
                    frequencyMap.put(word, 1);
                }
            }
        }

        System.out.println(frequencyMap);

        PriorityQueue<Tuple<String, Integer>> pairs = filterMap(frequencyMap, toys);
        System.out.println(pairs);
        int i = 0;
        while (!pairs.isEmpty()) {
            if (i == topToys) {
                break;
            }
            topToysList.add(pairs.poll().getKey());
            i++;
        }

        return topToysList;
    }

    private static PriorityQueue<Tuple<String, Integer>> filterMap(Map<String, Integer> frequencyMap, String[] toys) {
        PriorityQueue<Tuple<String, Integer>> pq = new PriorityQueue<>(new Comparator<Tuple<String, Integer>>() {
            @Override
            public int compare(Tuple<String, Integer> o1, Tuple<String, Integer> o2) {
                if (o1.getValue() != o2.getValue()) {
                    return o2.getValue().compareTo(o1.getValue());
                }
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        for (String toy : toys) {
            if (frequencyMap.containsKey(toy)) {
                pq.add(new Tuple<>(toy, frequencyMap.get(toy)));
            }
        }
        return pq;
    }


}

class Tuple<K, V> {
    private K key;
    private V value;

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public Tuple(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return key + " = " + value;
    }

    @Override
    public int hashCode() {
        return 13 * key.hashCode() + (value == null ? 0 : value.hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Tuple) {
            Tuple tuple = (Tuple) o;
            if (key != null ? !key.equals(tuple.getKey()) : tuple.key != null) return false;
            if (value != null ? !value.equals(tuple.getValue()) : tuple.value != null) return false;
        }
        return true;
    }
}
