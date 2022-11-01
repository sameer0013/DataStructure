import java.util.*;

public class Main {

	private static class Tri{
		int sp,ep,freq;
		Tri(int sp,int ep,int freq){
			this.sp = sp;
			this.ep = ep;
			this.freq = freq;
		}
	}

    public static void solution(int[] arr) {
        // write your code here

		HashMap<Integer,Tri> hm = new HashMap<>();
		int mfe=arr[0];

		for(int i=0;i<arr.length;i++){
			int val = arr[i];
			if(hm.containsKey(val)){
				Tri tri = hm.get(val);
				tri.ep=i;
				tri.freq +=1;
				hm.put(val,tri);
				if(hm.get(mfe).freq < hm.get(val).freq){
			    	mfe=val;
				}

			}else{
				Tri tri = new Tri(i,i,1);
				hm.put(val,tri);
			}
		}
        
        System.out.println(mfe);
        System.out.println(hm.get(mfe).sp);
        System.out.println(hm.get(mfe).ep);
        // System.out.println(hm.get(25).freq );
        
    }
    
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
                solution(arr);
	}

}

//fail case : 15
// 1 1 1 2 1 3 1 5 1 6 6 6

