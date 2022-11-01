import java.io.*;
import java.util.*;

public class Main {

  public static void permutations(int currbox, int totalbox, int[] boxStatus, int objplacedsf, int totalobjs, String asf){
    // write your code here
    if(currbox > totalbox){ // base case
        if(objplacedsf == totalobjs){
            System.out.println(asf);
        }
        return;
    }
    
    if(objplacedsf< totalobjs){
        for(int i =0;i<boxStatus.length;i++){
            if(boxStatus[i] == 0){
                boxStatus[i]=1;
                permutations(currbox+1,totalbox,boxStatus,objplacedsf+1,totalobjs, asf+(i+1));
                boxStatus[i]=0;
            }
        }
    }
    
    permutations(currbox+1,totalbox,boxStatus,objplacedsf,totalobjs,asf+"0");

  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    permutations(1, nboxes, new int[ritems], 0, ritems, "");
  }

}