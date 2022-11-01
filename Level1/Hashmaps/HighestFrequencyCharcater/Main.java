import java.io.*;
import java.util.*;

public class Main {

    public static Character maxfreqc(String str){
        HashMap<Character,Integer> hm = new HashMap<>();

        for(int idx =0;idx<str.length();idx++){
            Character ch = str.charAt(idx);
            if(hm.containsKey(ch)){
                hm.put(ch,hm.get(ch)+1);
            }else{
                hm.put(ch,1);
            }

        }

        int maxfreq=0;
        Character maxfreqch = ' ';
        for(Character ch : hm.keySet()){
            if(maxfreq<hm.get(ch)){
                maxfreq=hm.get(ch);
                maxfreqch=ch;
            }
        }
        return maxfreqch;
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        System.out.println(maxfreqc(str));
    
    }

}
