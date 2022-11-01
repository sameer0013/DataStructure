package Intro;

import java.util.*;
public class Main{
    public static void maxPriorityQueue(){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        System.out.println(pq);
        pq.add(0);
        // System.out.println(pq);
        pq.add(10);
         // System.out.println(pq);
        pq.add(-1);
         // System.out.println(pq);
        pq.add(15);
         // System.out.println(pq);
        pq.add(7);
         // System.out.println(pq);
        pq.add(8);
        System.out.println(pq);

        System.out.println(pq.peek());
        System.out.println(pq.size());

        while(pq.size()>0){
            System.out.print(pq.remove()+" ");
        }
    }
    public static void minPriorityQueue(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        System.out.println(pq);
        pq.add(0);
        // System.out.println(pq);
        pq.add(10);
         // System.out.println(pq);
        pq.add(-1);
         // System.out.println(pq);
        pq.add(15);
         // System.out.println(pq);
        pq.add(7);
         // System.out.println(pq);
        pq.add(8);
        System.out.println(pq);

        System.out.println(pq.peek());
        System.out.println(pq.size());

        while(pq.size()>0){
            System.out.print(pq.remove()+" ");
        }
    }
    public static void main(String[] args) {
        System.out.println("Min Priority Queue");
        minPriorityQueue();
        System.out.println("Max Priority Queue");
        maxPriorityQueue();
    }
}