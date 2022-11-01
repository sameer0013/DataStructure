import java.util.*;
public class Solution {
   
    public int solve(ArrayList<ArrayList<Integer>> A) {
        Collections.sort(A,(a,b) -> {return a.get(0)-b.get(0);});
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(A.get(0).get(1));
        for(int i=1;i<A.size();i++){
            ArrayList<Integer> interval = A.get(i);
            int sp = interval.get(0),ep = interval.get(1);
            int prevep = pq.peek();
            if(sp<prevep){
                pq.add(ep);
            }else{
                pq.remove();
                pq.add(ep);
            }
        }
        return pq.size();
    }
}
