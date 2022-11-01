import java.util.*;
class Solution {
    public class Sort implements Comparator<int[]>{
        public int compare(int[] a,int[] b){
            return a[0] - b[0];
        }
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length + 1;
        int m = 2;
        int[][] newIntervals = new int[n][m];
        newIntervals[0] = newInterval;
        for(int i=1;i<newIntervals.length;i++){
        
            newIntervals[i]=intervals[i-1];
        }
        
        Arrays.sort(newIntervals,new Sort());
        ArrayList<int[]> ans = new ArrayList<>();
        ans.add(newIntervals[0]);
        for(int i=1;i<newIntervals.length;i++){
            int[] prev = ans.get(ans.size()-1);
            int sp1= prev[0],ep1=prev[1];
            int sp2 = newIntervals[i][0],ep2 = newIntervals[i][1];
            
            if(ep1>=sp2){
                prev[1] = Math.max(ep1,ep2);
            }else{
                ans.add(new int[]{sp2,ep2});
            }
        }
        
        return ans.toArray(new int[ans.size()][]);
    }
    
}