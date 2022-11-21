import java.util.*;

class HashMap{

    public class HMNode{
        String key;
        int val;
        HMNode(String key, int val){
            this.key= key;
            this.val = val;
        }
    }
    LinkedList<HMNode> buckets[];
    int size=0;
    HashMap(){
        initBucket(4);
    }
    private void initBucket(int len){
        buckets = new LinkedList[len];

        for(int i=0;i<len;i++){
            buckets[i] = new LinkedList<>();
        }

    }

    private int hashFunc(String key){
        int hcode = key.hashCode();
        int abshcode = Math.abs(hcode);
        int bidx = abshcode%buckets.length;
        return bidx;
    }

    private HMNode findEleInBucket(int bi,String key){
        
        for(HMNode node : buckets[bi]){
            if(node.key.equals(key)){
                return node;
            }
        }
        return null;
    }

    public void put(String key,int val){
        int bidx = hashFunc(key);

        HMNode rnode = findEleInBucket(bidx ,key);

        if(rnode ==null){
            HMNode node = new HMNode(key,val);
            buckets[bidx].addLast(node);
            this.size++;
        }else{
            rnode.val = val;
        }

        double lambda = this.size/this.buckets.length;
        if (lambda>2){
            reHashing();
        }


    }

    private void reHashing(){
        this.size=0;
        LinkedList<HMNode> oldBuckets[] = buckets;
        initBucket(buckets.length*2);

        for(LinkedList<HMNode> ll: oldBuckets){
            for(HMNode node : ll){
                put(node.key,node.val);
            }
        }
    }

    public Integer get(String key){
        int bidx = hashFunc(key);

        HMNode rnode = findEleInBucket(bidx ,key);

        if(rnode ==null){
            return null;
        }else{
            return rnode.val;
        }

    }

    public boolean containsKey(String key){
        int bidx = hashFunc(key);

        HMNode rnode = findEleInBucket(bidx ,key);

        if(rnode ==null){
            return false;
        }else{
            return true;
        }

    }

    public void remove(String key){
        int bidx = hashFunc(key);

        HMNode rnode = findEleInBucket(bidx ,key);

        if(rnode ==null){
            
        }else{
            buckets[bidx].remove(rnode);
            this.size--;
        }

    }

    public Set<String> keySet(){
        Set<String> hs = new HashSet<>();
        for(LinkedList<HMNode> ll : buckets){
            for(HMNode node : ll){
                hs.add(node.key);
            }
        }
        return hs;

    }
    public int size(){
        return this.size;
    }
}
public class Main{
    public static void main(String args[]){
        HashMap hm = new HashMap();
        hm.put("India",120);
        hm.put("aus",30);
        hm.put("pak",0);
        System.out.println(hm.containsKey("china"));
        System.out.println(hm.containsKey("aus"));
        System.out.println(hm.keySet());
        System.out.println(hm.get("India"));
        hm.remove("aus");
        System.out.println(hm.keySet());

        System.out.println(hm.size());
    }
}