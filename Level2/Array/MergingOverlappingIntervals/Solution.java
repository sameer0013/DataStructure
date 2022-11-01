// Definition for an interval.
import java.util.*;

public class Solution {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
  }
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals,(a,b) -> {return a.start - b.start;});
        ArrayList<Interval> ans = new ArrayList<>();
        Interval interval = intervals.get(0);
        ans.add(new Interval(interval.start,interval.end));
        
        for(int i=1;i<intervals.size();i++){
            Interval prev = ans.get(ans.size()-1);
            int sp1 = prev.start, ep1 = prev.end;
            Interval curr = intervals.get(i);
            int sp2 = curr.start,ep2 = curr.end;
            
            if(ep1>= sp2){
                prev.end = Math.max(ep1,ep2);
            }else{
                ans.add(curr);
            }
        }
        return ans;
    }
}
