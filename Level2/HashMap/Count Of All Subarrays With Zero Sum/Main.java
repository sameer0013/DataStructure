import java.util.*;

public class Main {

	public static int solution(int[] arr) {
		HashMap<Integer,Integer> hm = new HashMap<>();
		hm.put(0,1);
		int sum=0;
		int count =0;

		for(int val: arr){
			sum += val;
			Integer freq = hm.get(sum);
			if(freq!=null){
				count += freq;
				hm.put(sum,freq+1);
			}else{
				hm.put(sum,1);
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
		System.out.println(solution(arr));

	}

}
