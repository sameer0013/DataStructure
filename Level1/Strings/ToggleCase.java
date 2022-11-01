import java.io.*;
import java.util.*;

public class ToggleCase 
{

	public static String toggleCase(String str){
		StringBuilder sb= new StringBuilder();
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			if(ch>='a'&&ch<='z')
			{
				// lowercase character we have to convert it to uppercase

				char uc=(char)((ch-'a')+'A'); /*typecasting is needed beacuse 
                                            when we convert a int to char 
                                            lossy conversion error happens 
                                            because int is of 4bytes where as char is of 2 bytes in java*/
				sb.append(uc);
			}
			else if(ch>='A'&&ch<='Z'){
				// uppercase we have to convert it to lowercase

				char lc=(char)((ch-'A')+'a');
                
				sb.append(lc);
			}	
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(toggleCase(str));
	}

}
