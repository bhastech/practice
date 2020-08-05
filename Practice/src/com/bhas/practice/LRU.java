package com.bhas.practice;

import java.util.HashMap;

public class LRU {

    public static void main(String[] args) {

    }

    class Entry {
        Entry prev;
        Entry next;
        int key;
        int value;
    }

    class LRUCache{

        HashMap<Integer, Entry> map;
        Entry start, end;
        int THRESHOLD = 4;

        public LRUCache(){
            map = new HashMap<>();
        }

        public void putEntry(int key, int value){

            if(map.containsKey(key)){
                //key already exists ,, upadte the value and move it to top
                Entry entry = map.get(key);
                entry.value = value;
                removeNode(entry);
                addToTop(entry);
            }else{
                Entry newNode = new Entry();
                newNode.prev = null;
                newNode.next = null;
                newNode.value = value;
                newNode.key = key;

                if(map.size() > THRESHOLD){
                    map.remove(end.key);
                    removeNode(end);
                    addToTop(newNode);
                }
                else{
                    addToTop(newNode);
                }
                map.put(key, newNode);
            }
        }

        public int get(int key){
            if(map.containsKey(key)){
                Entry entry  = map.get(key);
                removeNode(entry);
                addToTop(entry);
                return entry.value;
            }
            return -1;
        }

        private void addToTop(Entry entry) {
            entry.next = start;
            entry.prev = null;

            if(start != null){
                start.prev = entry;
            }
            start = entry;
            if(end == null){
                end = start;
            }
        }

        private void removeNode(Entry entry) {

            if(entry.prev != null){
                entry.prev.next = entry.next;
            }else{
                start = entry.next;
            }

            if(entry.next != null){
                entry.next.prev = entry.prev;
            }else{
                end = entry.prev;
            }

        }

    }

}
