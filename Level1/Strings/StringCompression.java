
import java.io.*;
import java.util.*;

public class StringCompression 
{

	public static String compression1(String str){
		// write your code here
		String s=""+str.charAt(0);
		int idx=1;
		while(idx<str.length()){
			if(str.charAt(idx-1)==str.charAt(idx)){
				idx++;
			}
			else{
				s=s+str.charAt(idx);
				idx++;
			}
		}
		return s;
	}

	public static String compression2(String str){
		// write your code here
		String s=""+str.charAt(0);
		int idx=1;
		int count=1;
		while(idx<str.length()){
			if(str.charAt(idx-1)==str.charAt(idx)){
				
				count++;
				idx++;
			}
			else{
				if(count>1){
					s=s+count+str.charAt(idx);
					idx++;
					count=1;
				}
				else{
					s=s+str.charAt(idx);
					idx++;
					count=1;	
				}
			}
		}
		if(count>1){
			s=s+count;
		}
		return s;

		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str=scn.next();
		System.out.println(compression1(str));
		System.out.println(compression2(str));
	}

}
