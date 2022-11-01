import java.util.*;

public class Main {

	public static ArrayList<ArrayList<String>> groupAnagrams(String[] strs) {
		// write your code here
		HashMap<HashMap<Character,Integer>,ArrayList<String>> hm = new HashMap<>();
		for(int i=0;i<strs.length;i++){
		    HashMap<Character,Integer> map = new HashMap<>();
		    for(int j=0;j<strs[i].length();j++){
		        char ch = strs[i].charAt(j);
		        map.put(ch,map.getOrDefault(ch,0)+1);
		    }
		    
		    if(hm.containsKey(map)){
		        ArrayList<String> list = hm.get(map);
		        list.add(strs[i]);
		        hm.put(map,list);
		    }else{
		        ArrayList<String> list = new ArrayList<>();
		        list.add(strs[i]);
		        hm.put(map,list);
		    }
		    
		}
		
// 		System.out.println(hm);
        ArrayList<ArrayList<String>> list = new ArrayList();
        for(ArrayList<String> ll: hm.values()){
            list.add(ll);
        }
        

		return list;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.next();
		}
		ArrayList<ArrayList<String>> anagramsGrouped = groupAnagrams(arr);
		for (ArrayList<String> lst : anagramsGrouped) {
			Collections.sort(lst);
		}
		anagramsGrouped.sort(new ListComparator());
		display(anagramsGrouped);
	}

	// it is used to make the result unique
	static class ListComparator implements Comparator<List<String>> {
		@Override
		public int compare(List<String> l1, List<String> l2) {
			if (l1.size() != l2.size()) {
				return l2.size() - l1.size();
			}

			String l1str = l1.get(0);
			String l2str = l2.get(0);
			return l1str.compareTo(l2str);

		}
	}

	public static void display(ArrayList<ArrayList<String>> list) {
		for (int i = 0; i < list.size(); i++) {
			ArrayList<String> currList = list.get(i);
			for (int j = 0; j < currList.size(); j++) {
				System.out.print(currList.get(j) + " ");
			}
			System.out.println();
		}
	}

}
