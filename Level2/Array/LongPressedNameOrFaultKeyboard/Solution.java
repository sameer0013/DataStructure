class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if(name.charAt(0)!=typed.charAt(0)) return false;
        int i=0,j=0;
        while(i<name.length() && j<typed.length()){
            if(name.charAt(i)==typed.charAt(j)){
                i++;
                j++;
            }else if(i>=0&&(typed.charAt(j)==name.charAt(i-1))){
                j++;
            }else return false;
        }
        
        if(i<name.length()) return false;
        
        while(j<typed.length()){
            if(typed.charAt(j-1)!=typed.charAt(j)) return false;
            j++;
        }
        
        return true;
    }
}