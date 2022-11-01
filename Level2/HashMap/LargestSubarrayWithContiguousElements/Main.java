import java.util.*;

public class Main {

	public static int solution(int[] arr) {
		int ans =1;

		for(int j=0;j<arr.length;j++){

			int max = arr[j],min=arr[j];
			HashSet<Integer> hs = new HashSet<>();
			hs.add(arr[j]);

			for(int i =j+1;i<arr.length;i++){

				max = Math.max(max,arr[i]);
				min = Math.min(min,arr[i]);
 				hs.add(arr[i]);
				 
				if(i-j+1==hs.size()){
					if(i-j+1==max-min+1){
						ans = Math.max(ans,i-j+1);
					}
				}else{
					break;
				}

			}
		}

		return ans;
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
