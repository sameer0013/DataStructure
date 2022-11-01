import java.util.HashMap;

public class Main{
    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();
        // INITAILLY {} HASHMAP 
        System.out.println(hm);

        // BUILDING THE HASHMAP
        hm.put("India",200);
        // System.out.println(hm);
        hm.put("UK",190);
        // System.out.println(hm);
        hm.put("USA",150);
        // System.out.println(hm);
        hm.put("China",130);
        System.out.println(hm);

        //constains key or not (t/f)
        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("india"));

        // RETURN VALUE OF THAT KEY IF NOT THEN NULL
        System.out.println(hm.get("India"));
        System.out.println(hm.get("india"));

        //UPDATE VALUE OF THAT SPECIFIC KEY
        hm.put("India",250);
        System.out.println(hm);

        //REMOVE KEY,VALUE FROM HASHMAP IF NOT ALREADY PRESENT THEN IT RETURN NULL OTHERWISE REMOVE+ RETURN VALUE
        System.out.println(hm.remove("China")+" status ->  "+ hm);
        System.out.println(hm.remove("China")+" status ->  "+ hm);

        // TOTAL NUMBER OF ELEMENT PRESENT IN HM
        System.out.println(hm.size());

        // NO OTHER WAY TO ITERATE OVER HM AS HM ARE UNORDERED 
        for(String key : hm.keySet()){
            System.out.println("Key : "+key+" value : "+hm.get(key));
        }

    }
}