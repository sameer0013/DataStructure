import java.util.*;

public class Main {
	
	public static int solution(int[] arr) {
		// write your code here
		HashMap<Integer,Integer> hm = new HashMap<>();
		int ssf=0,len=0;
		hm.put(0,-1);
		for(int i=0;i<arr.length;i++){
			ssf += arr[i];
			if(hm.containsKey(ssf)){
				int idx = hm.get(ssf);
				int diff = i-idx;
				len = Math.max(len,diff); 
			}else{
				hm.put(ssf,i);
			}
		}

		return len;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}

}

