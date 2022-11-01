import java.util.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Main {
     public class ListNode {
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }
    public static ListNode listMid(ListNode head){
        if(head == null|| head.next==null) return head;
        ListNode slow =head;
        ListNode fast = head;
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public static ListNode reverse(ListNode head){
        if(head== null || head.next==null) return head;
        ListNode prev = null;
        ListNode curr= head;
        while(curr!=null){
            ListNode nbr = curr.next;
            curr.next=prev;
            prev=curr;
            curr=nbr;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        if(head == null|| head.next==null) return;
        ListNode mid = listMid(head);
       
        ListNode head2 = mid.next;
        mid.next=null;
        ListNode p1 = head;
        ListNode p2 = reverse(head2);
        ListNode p3 = new ListNode(0);
        while(p1!=null&&p2!=null){
            
            p3.next=p1;
            p1=p1.next;
            p3=p3.next;
            
            p3.next=p2;
            p2=p2.next;
            p3=p3.next;
        }
        p3.next=p1;
        
    }
    public static void main(String[] args) {
        LinkedList<Integer> list= new LinkedList<>();
        
    }
}