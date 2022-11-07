class Solution {
    public boolean checkInclusion(String s1, String s2) {
     
        int l1 = s1.length(),l2 = s2.length();
        if(l1>l2) return false;
        int freq[] = new int[26];
        for(int i=0;i<l1;i++){
            freq[s1.charAt(i)-'a']++; //include
            freq[s2.charAt(i)-'a']--; // exclude
        }
        if(check(freq)) return true;
        
        
        for(int i=l1;i<l2;i++){
            char ch = s2.charAt(i);
            freq[ch-'a']--; //include
            freq[s2.charAt(i-l1)-'a']++; // exclude
            if(check(freq)) return true;
        }
        
        return false;
    }
    
    public boolean check(int[] freq){
        for(int vl:freq) if(vl!=0) return false;
        return true;
    }
}