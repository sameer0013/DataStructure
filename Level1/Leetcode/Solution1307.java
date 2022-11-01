public class Solution1307 
 {
    public String sortString(String s) {
        int [] freq = new int[26];
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            freq[(ch-'a')]++;
        }
        
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        while(sb.length()!=n){
            //increasing
            for(int i=0;i<26;i++){
                if(freq[i]>0){
                    char c = (char)(i+'a');
                    sb.append(c);
                    freq[i]--;
                }
            }
            //decreasing
             for(int i=25;i>=0;i--){
                if(freq[i]>0){
                    char c = (char)(i+'a');
                    sb.append(c);
                    freq[i]--;
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Solution1307 s= new Solution1307();
        System.out.println(s.sortString("aaaabbbbbcccc"));
    }
}
