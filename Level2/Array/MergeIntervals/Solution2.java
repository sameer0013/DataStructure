import java.util.*;
class Solution2 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> {return a[0]-b[0];});//lambda expression
        
        ArrayList<int[]> list = new ArrayList<>();
        
        list.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int[] interval = intervals[i];
            int[] lastinterval = list.get(list.size()-1);
            if(interval[0]<=lastinterval[1]){
                lastinterval[1] = Math.max(interval[1],lastinterval[1]);
            }else{
                list.add(interval);
            }
        }
        
        return list.toArray(new int[list.size()][]);
    }
}