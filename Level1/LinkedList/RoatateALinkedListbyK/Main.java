import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static int size(ListNode head){
        int count =0;
        ListNode ptr=head;
        while(ptr!=null){
            ptr=ptr.next;
            count++;
        }
        return count;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null) return head;
        
        int len = size(head);
        k=k%len;
        if(k==0) return head;
        ListNode slow=head,fast=head;
        while(k!=0){
            fast=fast.next;
            k--;
        }
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        ListNode head2 =slow.next;
        slow.next=null;
        fast.next=head;
        return head2;
        
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
        
        printList(head);
    }
}