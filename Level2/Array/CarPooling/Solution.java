class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] pass = new int[1001];
        for(int[] t: trips){
            int nopass =t[0],start=t[1],end =t[2];
            pass[start] += nopass;
            pass[end] -= nopass;
        }
        
        int currpass =0;
        for(int vl: pass){
            currpass += vl;
            if(currpass>capacity)
                return false;
        }
        return true;
    }
}