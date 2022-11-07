class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int lc=0,sp=0,ep=0,maxlen=0;
        while(ep<s.length()){
            char ch = s.charAt(ep);
            freq[ch-'A']++;
            lc = Math.max(lc,freq[ch-'A']);
            while(ep-sp+1-lc>k &&sp<s.length()){
                char sch = s.charAt(sp);
                freq[sch-'A']--;
                lc = max(freq);
                sp++;
            }
            
            maxlen = Math.max(maxlen,ep-sp+1);
            ep++;
        }
        return maxlen;
    }
    
    public int max(int[] freq){
        int max=0;
        for(int vl:freq){
            max = Math.max(max,vl);
        }
        
        return max;
    }
}