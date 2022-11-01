import java.util.*;
class Solution {
    public class Pair implements Comparable<Pair>{
        int sp,ep;
        Pair(int sp,int ep){
            this.sp = sp;
            this.ep = ep;
        }
        
        public int compareTo(Pair o){
            return this.sp - o.sp;
        }
        
        public String toString(){
            return "["+sp+","+ep+"]";
        }
    }
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Pair[] pairs = new Pair[n];
        int i=0;
        for(int[] interval: intervals){
            pairs[i] = new Pair(interval[0],interval[1]);
            i++;
        }
        
        Arrays.sort(pairs);
        // System.out.println(Arrays.toString(pairs));
        
        ArrayList<Pair> list = new ArrayList<>();
        list.add(pairs[0]);
        
        for(i=1;i<n;i++){
            Pair lastInterval = list.get(list.size()-1);
            int inter1sp =lastInterval.sp,inter1ep=lastInterval.ep;
            int inter2sp =pairs[i].sp,inter2ep=pairs[i].ep;
            
            if(inter1ep>=inter2sp){
                //merge
                lastInterval.ep = Math.max(inter1ep,inter2ep);
            }else{
                list.add(pairs[i]);
            }
        }
        return ans(list);
    }
    
    public int[][] ans(ArrayList<Pair> list){
        int[][] res = new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            Pair interval = list.get(i);
            res[i][0] = interval.sp;
            res[i][1] = interval.ep;
        }
        return res;
    }
}
