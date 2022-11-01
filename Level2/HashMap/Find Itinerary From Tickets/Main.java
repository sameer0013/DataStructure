import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int noofpairs_src_des = scn.nextInt();
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < noofpairs_src_des; i++) {
			String s1 = scn.next();
			String s2 = scn.next();
			map.put(s1, s2);	
		}

		//write your code here

		String sp = findItinerary(map);
		System.out.print(sp);
		for(int i=0;i<noofpairs_src_des;i++){
			System.out.print(" -> "+map.get(sp));
			sp=map.get(sp);

		}
		System.out.println(".");


	}

	public static String findItinerary(HashMap<String,String> inp){
		HashMap<String,Boolean> map = new HashMap<>();
		String sp="";
		for(String src : inp.keySet()){
			String dest = inp.get(src);

			map.put(dest,false);
			if(map.containsKey(src)==false){
				map.put(src,true);
			}
		}

		for(String val: map.keySet()){
			if(map.get(val)==true){
				sp=val;
			}
		}
		return sp;
	}

}
