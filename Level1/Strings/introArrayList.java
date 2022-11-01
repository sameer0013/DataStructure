import java.util.ArrayList;

public class introArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<Integer>();

        System.out.println(list+" "+list.size());
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(90);
        list.add(50);
        System.out.println(list+" "+list.size());
        System.out.println("==================");
        for(int i=0;i<list.size();i++){
            System.err.println(list.get(i));

        }
        System.out.println("==================");
        for(int v1:list){
            System.out.println(v1);
        }
        System.out.println("==================");
        int re=list.remove(0);
        System.out.println("remove ele : "+re+" list: "+list);
        
        System.out.println("==================");
        list.add(2,49);
        System.out.println("list: "+list);
    }
}
