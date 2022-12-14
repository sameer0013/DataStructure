import java.io.*;
import java.util.*;

public class RemovePrimeArrayList 
 {

	public static boolean isPrime(int num){
		
			for(int j=2;j*j<=num;j++){
				if(num%j==0){
					return false;
				}
			}
		return true;	
	}

	public static void solution(ArrayList<Integer> al){
		// write your code here
		for (int i=al.size()-1;i>=0;i--){
			int num=al.get(i);
			if(isPrime(num))
			{
				al.remove(i);
				
			}
		}
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		ArrayList<Integer> al = new ArrayList<>();
		for(int i = 0 ; i < n; i++){
			al.add(scn.nextInt());
		}
		solution(al);
		System.out.println(al);
	}

}
