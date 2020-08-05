package com.bhas.practice;

import java.util.*;

public class KnightMovements {

    public static void main(String[] args) {

       new KnightMovements().compare();

    }

    private void compare() {
        List<Integer> li = new ArrayList<>();
        li.add(10);li.add(20);li.add(32);li.add(54);li.add(53);
        li.add(12);li.add(14);li.add(9);li.add(5);li.add(2);
        li.add(11);li.add(51);li.add(52);li.add(44);li.add(22);
        li.add(65);li.add(67);li.add(68);li.add(63);li.add(64);
        li.add(74);li.add(73);li.add(76);li.add(66);li.add(87);


        PriorityQueue<Integer> queue = new PriorityQueue<>(new DummyComparator());
        queue.add(10);queue.add(20);queue.add(32);queue.add(54);queue.add(53);
        queue.add(12);queue.add(14);queue.add(9); queue.add(5); queue.add(2);
        queue.add(11);queue.add(51);queue.add(52);queue.add(44);queue.add(22);
        queue.add(65);queue.add(67);queue.add(68);queue.add(63);queue.add(64);
        queue.add(74);queue.add(73);queue.add(76);queue.add(66);queue.add(87);
//        queue.addAll(li);

        while(!queue.isEmpty()){
            System.out.print(queue.remove()+", ");
        }

        System.out.println();

        Collections.sort(li, new DummyComparator());

        System.out.println(li);
    }

    class DummyComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {

            return o2.compareTo(o1);
        }
    }

    /*
    *
    *   N, M, x1, y1, x2, y2
        where N and M are size of chess board
        x1, y1  coordinates of source point
        x2, y2  coordinates of destination point

    * */
    public int knight(int N, int M, int x1, int y1, int x2, int y2) {
        // The 8 positions a knight could move to for the current position.
        int[] dx = {-1, -2, -1, -2, 1, 2, 1, 2};
        int[] dy = {-2, -1, 2, 1, -2, -1, 2, 1};
        boolean[][] isVisited = new boolean[N + 1][M + 1];
        Queue<Coordinate> queue = new LinkedList<Coordinate>();
        queue.add(new Coordinate(x1, y1));
        isVisited[x1][y1] = true;
        int moveCount = 0;

        // BFS to find the minimum number of steps.
        while (!queue.isEmpty()) {
            int nodesAtCurrentBreadth = queue.size();
            // Iterate over the coordinates at current breadth, as moveCount would be
            // incremented by 1 per breadth level.
            for (int count = 0; count < nodesAtCurrentBreadth; count++) {
                Coordinate currPos = queue.remove();
                if (currPos.x == x2 && currPos.y == y2) {
                    return moveCount;
                }

                for (int i = 0; i < dx.length; i++) {
                    if (isValid(currPos.x + dx[i], currPos.y + dy[i], N, M) && isVisited[currPos.x + dx[i]][currPos.y + dy[i]] == false) {
                        queue.add(new Coordinate(currPos.x + dx[i], currPos.y + dy[i]));
                        isVisited[currPos.x + dx[i]][currPos.y + dy[i]] = true;
                    }
                }
            }
            moveCount++;
        }

        return -1;
    }

    private boolean isValid(int x, int y, int N, int M) {
        if (x <= 0 || y <= 0 || x > N || y > M) {
            return false;
        }

        return true;
    }

}

class Coordinate {
    int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
