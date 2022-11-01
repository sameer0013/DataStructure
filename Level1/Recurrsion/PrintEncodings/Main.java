import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String n =scn.nextLine();
        printEncodings(n,"");


    }

    public static void printEncodings(String str,String asf) {
        if(str.length()==0){
            System.out.println(asf);
            return;
        }

        char n1 = str.charAt(0);
        if(n1=='0'){
            return;
        }else{
            char enc1 = (char)('a'+(n1-'1'));
            printEncodings(str.substring(1),asf+enc1);

            // multiple digit
            if(str.length()>1){
                String tmp = str.substring(0,2);
                int n2 = Integer.parseInt(tmp);
                if(n2<=26){
                    char enc2 = (char)('a'+(n2-1));
                    printEncodings(str.substring(2),asf+enc2);
                }
            }
        }
       
        
    }

}