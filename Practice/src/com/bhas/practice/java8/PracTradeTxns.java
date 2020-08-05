package com.bhas.practice.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 *
 *
 * 1 Find all transactions in the year 2011 and sort them by value (small to high).
 * 2 What are all the unique cities where the traders work?
 * 3 Find all traders from Cambridge and sort them by name.
 * 4 Return a string of all traders’ names sorted alphabetically.
 * 5 Are any traders based in Milan?
 * 6 Print the values of all transactions from the traders living in Cambridge.
 * 7 What’s the highest value of all the transactions?
 * 8 Find the transaction with the smallest value.
 *
 */
public class PracTradeTxns {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //
        System.out.println(transactions.stream()
                .filter(txn -> txn.getYear() == 2011)
                .sorted((o1, o2) -> o1.getValue() - o2.getValue())
                .collect(Collectors.toList()));
        //

        System.out.println(transactions.stream()
                .map(txn -> txn.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList()));
        //
        System.out.println(transactions.stream()
                .filter(txn -> txn.getTrader().getCity().equals("Cambridge"))
                .distinct()
                .sorted(((o1, o2) -> o1.getTrader().getName().compareTo(o2.getTrader().getName())))
                .collect(Collectors.toList()));
        //
        System.out.println(transactions.stream()
                .map(txn -> txn.getTrader().getName())
                .distinct()
                .sorted((o1,o2)->o1.compareTo(o2))
                .collect(Collectors.toList()));
        //
        System.out.println(transactions.stream()
                .map(txn -> txn.getTrader().getCity())
                .anyMatch(city -> city.equals("Milan")));
        //
        System.out.println(transactions.stream()
                .filter(txn -> txn.getTrader()
                        .getCity()
                        .equals("Cambridge"))
                .collect(Collectors.toList()));
        //
        System.out.println(transactions.stream()
                .map(txn -> txn.getValue()).max((o1,o2)->o1- o2));
        //
        System.out.println(transactions.stream()
                .map(txn -> txn.getValue()).min((o1,o2)->o1- o2));

        //

        LongStream.range(1,2).reduce(0L, Long :: sum);

        //

        System.out.println(transactions.stream().map(txn -> txn.getValue()).reduce(0, Integer :: sum));

        transactions.stream()
                .map(txn -> txn.getValue())
                .filter(txn -> txn > 100)
                .reduce( 0, Integer :: sum);
    }

}
