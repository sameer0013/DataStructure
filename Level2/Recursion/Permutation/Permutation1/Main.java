import java.io.*;
import java.util.*;

public class Main {

  public static void permutations(int[] boxes, int currobj, int totalobj){
    // write your code here
    if(currobj>totalobj){
        for(int vl : boxes) System.out.print(vl);
        System.out.println();
        return;
    }
    for(int i=0;i<boxes.length;i++){
        if(boxes[i]==0){
            boxes[i] = currobj;
            permutations(boxes,currobj+1,totalobj);
            boxes[i]=0;
        }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    permutations(new int[nboxes], 1, ritems);
  }

}