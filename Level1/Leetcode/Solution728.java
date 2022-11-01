import java.util.ArrayList;
import java.util.List;

public class Solution728  {
    public List<Integer> selfDividingNumbers(int left, int right) {
      ArrayList<Integer> mylist = new ArrayList<>();
        for(int i=left;i<=right;i++){
          if(check(i)){
              mylist.add(i);
          }
            
        }
        return mylist;
    }
    public boolean check(int ele){
        int temp=ele;
        while(temp>0){
           int r= temp%10;
            if (r==0) return false;
            if(ele%r!=0) return false;
            temp=temp/10;
        }
        return true;
    }
   public static void main(String[] args) {
       Solution728 s = new Solution728();
       List<Integer> ans=s.selfDividingNumbers(1,22);
       System.out.println(ans);
   } 
}
