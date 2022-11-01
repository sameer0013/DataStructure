
//input= pepCODing
// e-p=-11,p-e=11,C-p=-45,O-C=12,D-O=-11,i-D=37,n-i=5,g-n=-7
// output=p-11e11p-45C12O-11D37i5n-7g

import java.io.*;
import java.util.*;

public class StringWithCharDiff {

	public static String solution(String str){
		// write your code here
		StringBuilder sb = new StringBuilder();
		sb.append(str.charAt(0));
		for(int i=1;i<str.length();i++)
		{
			char c1=str.charAt(i);
			char c2=str.charAt(i-1);
			int v1=c1-c2;
			sb.append(v1);
			sb.append(c1);
			

		}
		// sb.append(str.charAt(str.length()-1));
		

		return sb.toString();
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}
