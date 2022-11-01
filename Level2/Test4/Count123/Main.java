package Count123;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        
        System.out.println(count(arr));
    }
    
    private static int count(int[] arr){
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("0#0",1);
        int c0=0,c1=0,c2=0;
        int count=0;
        String diff="";
        for(int val:arr){
            if(val==0) c0++;
            else if(val==1) c1++;
            else c2++;
            int c1_c0 = c1-c0;
            int c2_c1 = c2-c1;
            diff = c1_c0+"#"+c2_c1;
            if(hm.containsKey(diff)){
                count += hm.get(diff);
                hm.put(diff,hm.get(diff)+1);
            }else{
                hm.put(diff,1);
            }
        }
        
        return count;
        
    }
}
