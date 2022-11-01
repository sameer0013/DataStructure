package SmallestSubstringofaStringContainingallUniqueCharacterOfItself;

import java.util.*;

public class Main {

	public static int solution(String str){
		// write your code here
		HashSet<Character> hs = new HashSet<>();
		HashMap<Character,Integer> hm = new HashMap<>();

		for(int i=0;i<str.length();i++){
			hs.add(str.charAt(i));
		}

		int i=0,j=0;
		int min = Integer.MAX_VALUE;

		while(j<=str.length()){
			boolean flag=true;

			if(hm.size()!=hs.size()&&j<str.length()){
				//acquire
				char ch = str.charAt(j);
				hm.put(ch,hm.getOrDefault(ch,0)+1);
				j++;
				flag=false;
			}
			
			if(hm.size()==hs.size()){
				//release
				min = Math.min(min,j-i);
				Integer freq = hm.get(str.charAt(i));
				if(freq==1){
					hm.remove(str.charAt(i));
				}else{
					hm.put(str.charAt(i),freq-1);
				}
				flag =false;
				i++;
			}

			if(flag) break;
		}
		
		return min;
		
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}

