package DesignHashMap;
import java.util.*;

class MyHashMap {
    
    private class HMNode{
        int key;
        int value;
        HMNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    LinkedList<HMNode>[] buckets;
    int size;

    public MyHashMap() {
        size=0;
        buckets= new LinkedList[5]; //we have created an array of linkedlist with null at each block
        for(int i=0;i<buckets.length;i++){ // initialized a new linkedlist on each block of buckets
            buckets[i] = new LinkedList<>();
        }
    }
    
    private int hashFunc(int key){
        Integer obj = key;
        int hcode = obj.hashCode(); //+ve,-ve,0, O(1):Integer
        int abshCode = Math.abs(hcode);
        int bi = abshCode % buckets.length;
        return bi;
    }
    
    private HMNode find(LinkedList<HMNode> l1,int key){
        for(HMNode node: l1){
            if(node.key == key) return node;
        }
        
        return null;
    }
    public void put(int key, int value) {
        int bi = hashFunc(key);
        
        HMNode node = find(buckets[bi],key);
        if(node!=null){
            node.value=value;
        }else{
            HMNode nnode = new HMNode(key,value);
            buckets[bi].addLast(nnode);
            size++;
        }
        
        double lambda = ((size*1.0)/buckets.length);
        checkLambda(lambda);
    }
    
    private void checkLambda(double lambda){
        if(lambda>2){
            LinkedList<HMNode>[] oldbuckets  = buckets;
            buckets = new LinkedList[2*buckets.length];
            for(int i=0;i<buckets.length;i++){ //initialized a new LinkedList on each block of array
                buckets[i]= new LinkedList<>();
            }
            for(LinkedList<HMNode> ll : oldbuckets){
                for(HMNode n: ll){
                    put(n.key,n.value); //Transfer nodes from old buckets to new buckets
                }
            }
        }
    }
    
    public int get(int key) {
        int bi = hashFunc(key);
        
        HMNode node = find(buckets[bi],key);
        if(node!=null){
            return node.value;
        }else{
            return -1;
        }
    }
    
    public void remove(int key) {
        int bi = hashFunc(key);
        
        HMNode node = find(buckets[bi],key);
        if(node!=null){
            buckets[bi].remove(node);
            size--;
        }
    }


    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */