import java.util.*;
public class Main{
    static class Heap{
        ArrayList<Integer> data;
        Heap(){
            data = new ArrayList<>();
        }

        private void upHeapify(int idx){
            if(idx==0) return;
            int pidx = (idx-1)/2;

            if(data.get(idx)<data.get(pidx)){
                swap(idx,pidx);
                upHeapify(pidx);
            }
        }

        private void downHeapify(int idx){
            int lidx = (2*idx)+1;
            int ridx = (2*idx)+2;
            
            int min = idx;
            if(lidx<data.size() && data.get(lidx)<data.get(min)){
                min = lidx;
            }
            if(ridx<data.size() && data.get(lidx)<data.get(min)){
                min = ridx;
            }

            if(min!=idx){
                swap(min,idx);
                downHeapify(min);
            }
        }

        private void swap(int idx1,int idx2 ){
            int v1 = data.get(idx1);
            int v2 = data.get(idx2);

            data.set(idx1,v2);
            data.set(idx2,v1);
        }

        public void add(int vl){

            data.add(vl);
            upHeapify(data.size()-1);
        }

        public int remove(){
            if(data.size()==0){
                System.out.println("Underflow");
                return -1;
            }

            int vl = data.get(0);
            swap(0,data.size()-1);
            data.remove(data.size()-1);
            downHeapify(0);
            return vl;

        }

        public int peek(){
            if(data.size()==0){
                System.out.println("Under flow");
                return -1;
            }
            return data.get(0);
        }
    }

    public static void main(String args[]){
        Heap pq = new Heap();
        pq.add(30);
        System.out.println(pq.data + "->"+pq.peek());
        pq.add(10);
        System.out.println(pq.data + "->"+pq.peek());
        pq.add(20);
        System.out.println(pq.data + "->"+pq.peek());
        pq.add(8);
        System.out.println(pq.data + "->"+pq.peek());
        pq.remove();
        System.out.println(pq.data + "->"+pq.peek());
    }
}