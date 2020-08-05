package com.bhas.practice.Array;

import javafx.util.Pair;

import java.io.IOException;
import java.util.*;

class Main
{
	// Utility function to insert <key, value> into the Multimap
	private static<K,V> void insert(Map<K, List<V>> hashMap, K key, V value)
	{
		// if the key is seen for the first time, initialize the list
		if (!hashMap.containsKey(key)) {
			hashMap.put(key, new ArrayList<>());
		}

		hashMap.get(key).add(value);
	}

	// Function to print all sub-arrays with 0 sum present
	// in the given array
	public static void printallSubarrays(int[] A)
	{
		// create an empty Multi-map to store ending index of all
		// sub-arrays having same sum
		Map<Integer, List<Integer>> hashMap = new HashMap<>();

		// insert (0, -1) pair into the map to handle the case when
		// sub-array with 0 sum starts from index 0
		insert(hashMap, 0, -1);

		int sum = 0;

		// traverse the given array
		for (int i = 0; i < A.length; i++)
		{
			// sum of elements so far
			sum += A[i];

			// if sum is seen before, there exists at-least one 
			// sub-array with 0 sum
			if (hashMap.containsKey(sum))
			{
				List<Integer> list = hashMap.get(sum);

				// find all sub-arrays with same sum
				for (Integer value: list) {
					System.out.println("Subarray [" + (value + 1) + ".." +
												i + "]");
				}
			}

			// insert (sum so far, current index) pair into the Multi-map
			insert(hashMap, sum, i);
		}
	}

	// main function
	public static void main (String[] args)
	{
		int[] A = { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 };

//		printallSubarrays(A);
//		String[] words = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
		String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
//		String[] words = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
//		new Main().topKFrequent(words, 4);
//		ArrayList<String> strings = new Main().mostFrequentWords(words,2);
//		System.out.println(strings);


		double[] probabilities = new double[]{0.25,0.75,0.75,0.75};
		System.out.println(Math.abs(Arrays.binarySearch(probabilities, Math.random())) - 1);


	}


	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> frequencyMap = createFrequencyMap(words);
		System.out.println(frequencyMap);
		return null;
	}

	private Map<String, Integer> createFrequencyMap(String[] words){

		Map<String,Integer> m = new HashMap<>();

		for(String word : words){
			if(m.containsKey(word)){
				int count = m.get(word);
				m.put(word, ++count);
			}else{
				m.put(word, 1);
			}
		}

		return m;
	}

	public ArrayList<String> mostFrequentWords(String[] words, int n){
		ArrayList<String> topWords = new ArrayList<>();

		//			HashMap<String, Integer> wordMap = readFile(fileName);
		Map<String, Integer> wordMap = createFrequencyMap(words);
		System.out.println(wordMap);
		PriorityQueue<Pair<String, Integer>> pq =
				new PriorityQueue<>(n, new Comparator<Pair<String, Integer>>() {
					@Override
					public int compare(Pair<String, Integer> o1, Pair<String, Integer> o2) {
						if(o1.getValue() != o2.getValue()){
							return o2.getValue().compareTo(o1.getValue());
						}
						return o1.getKey().compareTo(o2.getKey());
					}
				});

		int i = 0;
		Iterator it = wordMap.entrySet().iterator();
            /*
                Get first n words on heap
            */
		while(it.hasNext()){
//			if(i == n) break;
			HashMap.Entry<String, Integer> entry =
					(HashMap.Entry<String, Integer>)it.next();
			pq.add(new Pair<>(entry.getKey(), entry.getValue()));
//			it.remove();
			i++;
		}

            /*
                Check all other words, if anyone more than least
                remove the least and add the new word.
            */
//		for (String key : wordMap.keySet()){
//			if(pq.peek().getValue() < wordMap.get(key)){
//				pq.poll();
//				pq.add(new Pair<>(key, wordMap.get(key)));
//			}
//		}
		while(!pq.isEmpty()){
			topWords.add(pq.poll().getKey());
		}
		return topWords;
	}
}

class Test{

	String paymentMode;

	int subscriptionCharge;

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public int getSubscriptionCharge() {
		return subscriptionCharge;
	}

	public void setSubscriptionCharge(int subscriptionCharge) {
		this.subscriptionCharge = subscriptionCharge;
	}

	@Override
	public String toString() {
		return "Test{" +
				"paymentMode='" + paymentMode + '\'' +
				", subscriptionCharge=" + subscriptionCharge +
				'}';
	}
}

class SuperTest {
	Test test;

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	@Override
	public String toString() {
		return "SuperTest{" +
				"test=" + test +
				'}';
	}
}

class Solution {
	private double[] probabilities;

	public Solution(int[] w) {
		double sum = 0;
		this.probabilities = new double[w.length];
		for(int weight : w)
			sum += weight;
		for(int i = 0; i < w.length; i++){
			w[i] += (i == 0) ? 0 : w[i - 1];
			probabilities[i] = w[i]/sum;
		}
	}

	public int pickIndex() {
		return Math.abs(Arrays.binarySearch(this.probabilities, Math.random())) - 1;
	}
}