import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i  < n; i++){
            arr[i] = scn.nextInt();
        }
		//write your code here
        System.out.println(equivalentSubarray(arr));
		
	}

    public static int equivalentSubarray(int[] arr){
        HashSet<Integer> hs = new HashSet<>();
        for(int val : arr){
            hs.add(val);
        }

        HashMap<Integer,Integer> hm = new HashMap<>();
        int tue = hs.size();
        int count=0;
        int i=0,j=0;

        boolean flag = true;
        while(flag){

            flag=false;
            if(tue!=hm.size() && j<arr.length){
                flag = true;
                int val = arr[j];
                hm.put(val,hm.getOrDefault(val,0)+1);
                j++;
            }

            if(tue==hm.size() && i<arr.length){
                flag = true;
                count += arr.length - (j-1);
                int val = arr[i];
                int f = hm.get(val);
                if(f==1) hm.remove(val);
                else hm.put(val,f-1);
                i++;
            }
        }

        return count;
    }


}
