class Main{
    public static class Node{
        int data;
        Node next;
    }

    public static class LinkedList{
        Node head;
        Node tail;
        int size;

        void addLast(int val){
            Node node = new Node();
            node.data=val;
            if(this.size==0){
                this.head=node;
                this.tail=node;
            }
            else{
                this.tail.next=node;
                this.tail=node;    
            }
            this.size++;
        }
        int size(){
            return this.size;
        }
        void addBegin(int val){
            Node node = new Node();
            node.data=val;
            node.next=this.head;
            this.head = node;
            this.size++;
        }
        void display(){
            Node ptr = this.head;
            while(ptr!=null){
                System.out.println(ptr.data);
                ptr=ptr.next;
            }
            //System.out.println(this.tail.data);
        }
    }


    public static class GfG
    {
        boolean isCircular(Node head)
        {
        // Your code here	
        //https://practice.geeksforgeeks.org/problems/circular-linked-list/1
        //https://leetcode.com/problems/linked-list-cycle/
        Node slow =head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow = slow.next;
            if(fast == slow ) return true;
        }
        return false;
        }

        public Node detectCycle(Node head) {
        // leetcode 
        //https://leetcode.com/problems/linked-list-cycle-ii/
            Node slow = head;
            Node fast = head;
            boolean hasCycle = false;
            
            while(fast!= null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
                if(fast == slow ){
                    hasCycle = true;
                    break;
                }
            }
            if(!hasCycle) return null;
            Node curr = head;
            Node ptr = slow;
            while(curr!=ptr){
                ptr=ptr.next;
                curr=curr.next;
            }
            return curr;
        }

        public static void removeLoop(Node head){
            // code here
            // remove the loop without losing any nodes
            //https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1
            Node slow=head;
            Node fast = head;
            boolean hasCycle = false;
            Node prev = null;
            
            while(fast!=null&& fast.next!=null){
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
                if(fast == slow){
                    hasCycle = true;
                    break;
                }
            }
            if(!hasCycle) return ;
            Node curr = head;
            while(slow!=curr){
                prev=slow;
                slow=slow.next;
                curr=curr.next;
            }
            prev.next=null;
            
        }

        static int countNodesinLoop(Node head)
        {
            //https://practice.geeksforgeeks.org/problems/find-length-of-loop/1
             Node slow = head;
             Node fast = head;
             boolean hasCycle =false;
             while(fast!=null && fast.next != null){
                 slow=slow.next;
                 fast = fast.next.next;
                 if(fast == slow){
                     hasCycle = true;
                     break;
                 }
             }
         
          if(!hasCycle) return 0;
         
             slow = slow.next;
             int count =1;
             while(slow!=fast){
                 slow=slow.next;
                 count++;
             }
             return count;
         }
    }

    
        public static void main(String[] args) {
            LinkedList ll = new LinkedList();
            ll.addLast(10);
            ll.addLast(20);
            ll.addLast(30);
            ll.addLast(40);
            ll.addBegin(70);
            // System.out.println(ll.head.data);
            // System.out.println(ll.head.next.data);
            // System.out.println(ll.tail.data);
            ll.display();
            System.out.println(ll.size());
        }
}
