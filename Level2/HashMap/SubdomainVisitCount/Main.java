import java.util.*;

public class Main {
    
	public static List<String> subdomainVisits(String[] s) {
		// write your code here
		HashMap<String,Integer> hm = new HashMap<>();
		for(String ss:s){
			String[] str = ss.split(" ");
			int vc = Integer.parseInt(str[0]);
			String domain = str[1];

			String[] dom = domain.split("\\.");

			StringBuilder sb = new StringBuilder();
			for(int i=dom.length-1;i>=0;i--){
				if(i==dom.length-1){
					sb.append(dom[i]);
				}else{
					sb.insert(0,".");
					sb.insert(0,dom[i]);
				}

				String sss= sb.toString();
				hm.put(sss,hm.getOrDefault(sss,0)+vc);
			}


		}
		List<String> ans = new ArrayList<>();
		for(String k : hm.keySet()){
			StringBuilder sb = new StringBuilder();
			sb.append(hm.get(k));
			sb.append(" ");
			sb.append(k);

			ans.add(sb.toString());
		}

		return ans;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = Integer.parseInt(s.nextLine());
		String[] cpd = new String[n];
		for (int i = 0; i < cpd.length; i++) {
			cpd[i] = s.nextLine();
		}
		List<String> ans = subdomainVisits(cpd);
		Collections.sort(ans);
		for(String str : ans){
			System.out.println(str);

		}
	}

}
