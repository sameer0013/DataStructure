import java.io.*;
	import java.util.*;

	public class Main {

	    public static void main(String[] args) throws Exception {

			Scanner scn = new Scanner(System.in);
			int n = scn.nextInt();
			int val[] = new int[n];
			int wt[] = new int[n];
			for(int i=0;i<n;i++) val[i]= scn.nextInt();
			for(int i=0;i<n;i++) wt[i]= scn.nextInt();

			int cap = scn.nextInt();

			System.out.println(unbound_Knapsack_tab(val,wt,cap));


	    }

		public static int unbound_Knapsack_tab(int[] value,int[] weight,int capacity){
			int dp[]= new int[capacity+1];
			dp[0]=0;
			for(int i =0;i<value.length;i++){
				for(int cap = 1;cap<dp.length;cap++){
					int wt = weight[i];
					int v = value[i];
					if(cap>=wt){
						int inc = v+dp[cap-wt];
						int exc = dp[cap];
						dp[cap]= Math.max(inc,exc);
					}
				}
			}
			return dp[capacity];
		}
	}