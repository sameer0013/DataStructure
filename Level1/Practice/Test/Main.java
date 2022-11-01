import java.util.*;
public class Main{
    public static int solve(String str){
        int len=0,sum=0;
        for(int i=0;i<str.length();i++){
            char ch =str.charAt(i);
            if(ch==' ') continue;
            else if(('a'<=ch&&ch<='z')||('A'<=ch&&ch<='Z')||ch=='-'){
                len +=1;
                // System.out.println(len);
            }else{
                int num = ch-'0';
                sum += num;
            }
        }
        // System.out.println(len);
        // System.out.println(sum/len);
        float res = (float)sum/len;
        return Math.round(res);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        int n = solve(str);
        System.out.println(n);
    }

}