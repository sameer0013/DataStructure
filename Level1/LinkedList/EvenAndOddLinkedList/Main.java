import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode divide(int N, Node head){
        // code here
        if(head==null||head.next==null) return head;
        ListNode even = new Node(0);
        ListNode odd = new Node(0);
        
        ListNode p1 = even,p2 = odd,p3=head;
        while(p3!=null){
            if(p3.val%2==0){
                p1.next=p3;
                p1=p3;
            }else{
                p2.next=p3;
                p2=p3;
            }
            p3=p3.next;
            
        }
        p1.next=null;
        p2.next=null;
        ListNode head2=odd.next;
        p1.next=head2;
        return even.next;
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        
        ListNode p1 =odd,p2=even,p3=head;
        int count =1;
        while(p3!=null){
            if(count%2!=0){
                p1.next=p3;
                p1=p3;
                
            }else{
                p2.next=p3;
                p2=p3;
            }
            p3=p3.next;
            count++;
        }
        p1.next=null;
        p2.next=null;
        ListNode head2 = even.next;
        p1.next=head2;
        return odd.next;
    }


    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = dummy.next;
        unfold(head);
        printList(head);
    }
}