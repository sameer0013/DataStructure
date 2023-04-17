class Solution {
    public int longestPalindromeSubseq(String s) {
        // Recursion
        // return lps(s.toCharArray(),0,s.length()-1);
        
        
        // dynamic programming
        return lps(s);
    }
    
    private int lps(String s){
        int n = s.length();
        int dp[][] = new int[n][n];
        
        for(int i=0;i<n;i++)
            dp[i][i]=1;
        
        for(int i=n-2;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(s.charAt(i)==s.charAt(j)&&i+1==j){
                    dp[i][j] =2;
                }
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1]+2;
                }
                
                else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        
        return dp[0][n-1];
    }
    private int lps(char[] s , int i,int j){
        if(i==j) return 1;
        
        if(s[i]==s[j] && i+1==j) return 2;
        
        if(s[i]==s[j]) return lps(s,i+1,j-1)+2;
        
        return Math.max(lps(s,i+1,j),lps(s,i,j-1));
    }
}