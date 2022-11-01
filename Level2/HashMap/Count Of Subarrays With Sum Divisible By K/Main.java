import java.util.*;

public class Main {

    public static int solution(int[] arr, int k) {
        // write your code here
        int ssf=0;
        int count=0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        for(int val: arr){
            ssf += val;
            int rem = ssf%k;
            if(rem<0) rem+=k; //negative rem
            if(hm.containsKey(rem)){
                int f=hm.get(rem);
                hm.put(rem,f+1);
                count +=f;

            }else{
                hm.put(rem,1);
            }

        }

        return count;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println(solution(arr, k));
    }

}
