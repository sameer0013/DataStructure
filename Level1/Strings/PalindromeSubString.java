
import java.io.*;
import java.util.*;

public class PalindromeSubString 
 {

	public static boolean ispalindrome(String s){
		// int index=s.length()-1;
		// String s2="";
		// while(index>=0){
		// 	s2=s2+s.charAt(index);     //time consuming approach
		// 	index--;
		// }
		// if(s.equals(s2)){
		 
		// 	return true;
		// }
		// return false;

		int left=0;
		int right=s.length()-1;
		while(left<right){
			if(s.charAt(left)==s.charAt(right)){
				left++;
				right--;
			}
			else{
				return false;
			}
		}
		return true;

	}

	public static void palindromeSubstring(String str){
		//write your code here
		for(int i=0;i<str.length();i++){
			for(int j=i+1;j<=str.length();j++){
				String s=str.substring(i,j);
				if (ispalindrome(s)){
					System.out.println(s);
				}
			}
		}
		
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		palindromeSubstring(str);
	}

}
