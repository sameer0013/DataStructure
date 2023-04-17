import java.util.*;
public class Main{
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.get(0).add(1);
        for(int i=1;i<numRows;i++){
            ans.add(new ArrayList<>());
            ans.get(i).add(1);
            for(int j=1;j<i;j++){
                ans.get(i).add(ans.get(i-1).get(j-1) + ans.get(i-1).get(j));
            }
            ans.get(i).add(1);
        }

        return ans;

    }
    public static void main(String[] args){
        // Main obj = new Main();
        List<List<Integer>> ans = new Main().generate(5);
        for(List<Integer> ll: ans){
            System.out.println(ll);
        }

    }
}