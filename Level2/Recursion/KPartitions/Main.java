import java.io.*;
import java.util.*;

public class Main {
    static int count=0;
	public static void solution(int idx, int n, int k, int rssf, ArrayList<ArrayList<Integer>> ans) {
		//write your code here
		if(idx>n){
		    if(rssf ==k){
		        count++;
		        System.out.print(count+". ");
		        for(int i =0;i<ans.size();i++){
		            
		            System.out.print(ans.get(i)+" ");
		        }
		        System.out.println();
		        
		    }
		    return;
		}
		
		for(int i=0;i<k;i++){
		    if(ans.get(i).size()!=0){
		        ans.get(i).add(idx);
		        solution(idx+1,n,k,rssf,ans);
		        ans.get(i).remove(ans.get(i).size()-1);
		    }
		    else{
		       ans.get(i).add(idx);
		        solution(idx+1,n,k,rssf+1,ans);
		        ans.get(i).remove(ans.get(i).size()-1); 
		        break;
		    }
		}
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(int i  = 0; i < k; i++) {
			ans.add(new ArrayList<>());
		}
		solution(1, n, k, 0, ans);

	}

}