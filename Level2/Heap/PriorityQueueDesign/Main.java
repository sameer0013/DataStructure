import java.io.*;
import java.util.*;

public class Main {

  public static class PriorityQueue {
    ArrayList<Integer> data;

    public PriorityQueue() {
      data = new ArrayList<>();
    }

    private void swap(int pidx,int idx){
      int val = data.get(idx);
      int pval = data.get(pidx);

      data.set(pidx,val);
      data.set(idx,pval);
    }
    private void upheapify(int idx){
      if(idx==0) return;
      int pidx = (idx-1)/2;

      if(data.get(pidx)>data.get(idx)){
        swap(pidx,idx);
        upheapify(pidx);
      }
    }
    public void add(int val) {
      data.add(val);

      int idx = data.size()-1;

      upheapify(idx);

    }

    private void downheapify(int pidx){
      int lidx = (2*pidx)+1;
      int ridx = (2*pidx)+2;

      int minidx = pidx;
      if(lidx<data.size() && data.get(lidx)<data.get(minidx)){
        minidx = lidx;
      }
      if(ridx<data.size() && data.get(ridx)<data.get(minidx)){
        minidx = ridx;
      }

      if(minidx!=pidx){
        swap(pidx,minidx);
        downheapify(minidx);
      }
    }
    public int remove() {
      if(data.size()==0) {
        System.out.println("Underflow");
        return -1;
      }
      int lidx = data.size()-1;
      swap(0,lidx);
      int maxheapEle = data.get(lidx);

      data.remove(lidx);

      downheapify(0);
      return maxheapEle;
    }

    public int peek() {
      if(data.size()==0) {
        System.out.println("Underflow");
        return -1;
      }
      return data.get(0);
    }

    public int size() {
      return data.size();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue qu = new PriorityQueue();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
  }
}