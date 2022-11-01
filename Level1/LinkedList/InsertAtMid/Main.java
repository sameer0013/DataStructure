class Main {
    class Node {
        int data;
        Node next;
        
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public Node getMid(Node head){
        
        Node slow=head;
        Node fast = head;
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow = slow.next;
            
        }
        return slow;
    }
    public Node insertInMid(Node head, int data){
        Node x = new Node(data);
        if(head==null){
            head=x;
            
        }else if(head.next==null){
            head.next=x;
            
        }
        else{
            Node mid = getMid(head);
            x.next = mid.next;
            mid.next = x;
           
        }
        //Insert code here, return the head of modified linked list
        
        return head;
    }
}