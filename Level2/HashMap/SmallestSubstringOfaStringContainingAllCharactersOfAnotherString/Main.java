import java.util.*;

public class Main {

	public static String solution(String s1, String s2){
		// write your code here
		HashMap<Character,Integer> ohm = new HashMap<>();
		for(int i=0;i<s2.length();i++){
			char ch = s2.charAt(i);
			ohm.put(ch,ohm.getOrDefault(ch,0)+1);
		}
		// System.out.println(ohm);

		HashMap<Character,Integer> map = new HashMap<>();
		int oc = s2.length();
		int count=0,i=0,j=0;
		int min = Integer.MAX_VALUE;
		int f_idx =0,l_idx=0;

		while(j<=s1.length()){
			boolean flag=true;
			if(oc!=count && j<s1.length()){
				char ch = s1.charAt(j);
				map.put(ch,map.getOrDefault(ch,0)+1);
				if(ohm.containsKey(ch)){
					int of = ohm.get(ch);
					int f = map.get(ch);
					if(f<=of){
						count++;
					}
				}
				j++;
				flag=false;
			}
			if(oc==count&&i<s1.length()){
				if(min>(j-i)){
					min=j-i;
					f_idx=i;
					l_idx=j;
				}
				char ch = s1.charAt(i);
				int f = map.get(ch);
				if(f==1) map.remove(ch);
		        else map.put(ch,f-1);

				if(ohm.containsKey(ch)){
					int of = ohm.get(ch);
					if(f-1<of){
						count--;
					}
				}

				i++;
				flag=false;
			}
			if(flag) break;
		}
		
		return s1.substring(f_idx,l_idx);
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1,s2));
	}

}