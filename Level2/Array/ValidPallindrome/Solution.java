
import java.util.*;
class Solution {
    public boolean isPalindrome(String s) {
        String str = makeStr(s);
        // System.out.println(str);
        int l=0,r=str.length()-1;
        while(l<r){
            if(str.charAt(l)!=str.charAt(r)) return false;
            l++;
            r--;
        }
        
        return true;
    }
    public String makeStr(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            // if((ch>='0' && ch<='9')||(ch>='A' && ch<='Z')||(ch>='a' && ch<='z'))
            if(Character.isLetterOrDigit(ch))
                sb.append(Character.toLowerCase(ch));
        }
        
        return sb.toString();
    }
}