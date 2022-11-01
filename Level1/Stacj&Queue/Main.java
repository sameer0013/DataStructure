import java.util.Stack;
import java.util.Queue;
import java.util.ArrayDeque;
public class Main{
    public static void stackIntro() {
        Stack<Integer> st = new Stack<Integer>();
        System.out.println(st);

        st.push(10);
        System.out.println(st.size()+" : "+st);
        st.push(20);
        System.out.println(st.size()+" : "+st);
        st.push(30);
        System.out.println(st.size()+" : "+st);
        st.push(40);
        System.out.println(st.size()+" : "+st);
        st.push(50);
        System.out.println(st.size()+" : "+st);

        // for(int ele : st){
        //     System.out.print(ele+ " -> ");


        // }
        System.out.println(st.pop()+" - "+st);
        System.out.println(st.peek()+ " - "+st);
    }
    public static void queueIntro(){
        Queue<Integer> qe = new ArrayDeque<>();
        System.out.println(qe.size()+"-"+qe);

        qe.add(10);
        System.out.println(qe.size()+"-"+qe);
        qe.add(20);
        System.out.println(qe.size()+"-"+qe);
        qe.add(30);
        System.out.println(qe.size()+"-"+qe);
        qe.add(40);
        System.out.println(qe.size()+"-"+qe);
        qe.add(50);
        System.out.println(qe.size()+"-"+qe);
        System.out.println(qe.remove()+" <-> "+qe.size()+"-"+qe);
        System.out.println(qe.remove()+" <-> "+qe.size()+"-"+qe);
        System.out.println(qe.remove()+" <-> "+qe.size()+"-"+qe);
        
        System.out.println(qe.peek()+" <-> "+qe.size()+"-"+qe);
        

        for(int ele : qe){
            System.out.print(ele+"->");
        }


    }
    public static void main(String[] args) {
        // stackIntro();
        queueIntro();
    }
}