import java.util.*;

public class Main{

    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static class LinkedList
    {
        
        Node head;
        Node tail;
        int size;

        void addLast(int val){
            Node node = new Node(val);
            if(size==0){
                head=tail=node;
                
            }else{
                tail.next=node;
                tail=node;
                tail.next=null;
            }
            this.size++;
        }

        void addFront(int val){
            Node node = new Node(val);
            if(head == null){
                head=tail=node;
                this.size++;
                return;
            }
            node.next=head;
            head=node;
            this.size++;
        }

        void addIndex(int val,int k){
            Node node = new Node(val);
            Node prev=null;
            Node ptr=head;
            while(k--!=0){
                prev=ptr;
                ptr=ptr.next;
            }
            prev.next=null;
            prev.next=node;
            node.next=ptr;
            this.size++;
        }

        void deleteFront(){
            if(head==tail){
                head=tail=null;
                this.size--;
                return;
            }
            Node ptr=head;
            head=head.next;
            ptr.next=null;
            this.size--;
        }

        void deleteLast(){
           
            Node ptr=head;
            while(ptr.next!=tail){
                ptr=ptr.next;
            }
            tail=ptr;
            tail.next=null;
            
            this.size--;
        }
        void deleteIndex(int k){
            Node prev=null;
            Node curr=head;
            while(k--!=0){
                prev=curr;
                curr=curr.next;
            }
            prev.next=curr.next;
            curr.next=null;
            this.size--;
        }

        void display(){
            Node ptr=head;
            while(ptr!=null){
                System.out.print(ptr.data+" -> ");
                ptr=ptr.next;
            }
            System.out.println("null");
        }

        int size(){
            return this.size;
        }

        int kthNodeFromLast(int k){
            if(k<0){
                k= k+this.size;
            }
            Node slow= this.head;
            Node fast = this.head;
            while(k--!=0){
                fast=fast.next;

            }
            while(fast!=this.tail){
                slow= slow.next;
                fast = fast.next;
            }

            return slow.data;
        }

     
        int mid(){
            Node slow= head;
            Node fast= head;
            while(fast!=null&&fast.next!=null){
                fast = fast.next.next;
                slow = slow.next;
            }

            return slow.data;
        }  


        Node getNodeAt(int idx){
            
            if(this.size==0||idx<0||idx==this.size) return null;
            else if(idx==0) return head;
            else if(idx==this.size-1) return tail;
            else{
                Node ptr=head;
                while(idx-->0){
                    ptr=ptr.next;
                }
                return ptr;
            }
           
        }
        void reverseLinkedListData(){
            int left=0,right=this.size-1;
            while(left<right){
                Node n1 = getNodeAt(left);
                Node n2 = getNodeAt(right);
                int tmp=n1.data;
                n1.data=n2.data;
                n2.data=tmp;
                left++;
                right--;
            }
        }

        void reverseLinkedListPointer(){
            Node curr=head;
            Node prev=null;
            while(curr!=null){
                Node nbr = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nbr;
            }
            this.tail = head;
            this.head = prev;
        }

        private void reverseHelper(Node node){
            if(node==tail){ 
                return;
            }
            reverseHelper(node.next);
            node.next.next=node;
        }

        void reverseLinkedListRecursive(){
            reverseHelper(this.head);
            this.head.next = null;
            Node tmp = head;
            head=tail;
            tail=tmp;
        }

        boolean hasCycle(){
            Node fast = head;
            Node slow = head;
            while(fast!=null && fast.next!=null){
                fast = fast.next.next;
                slow = slow.next;
                if(fast == slow){
                    return true;
                }
            }
            return false;
        }

        int startingPointCycle(){
            Node slow=head;
            Node fast = head;
            while(fast!=null && fast.next!=null){
                fast = fast.next.next;
                slow = slow.next;
                if(fast == slow){
                    break;
                }
            }

            if(fast==null || fast.next== null){
                return -1;
            }
            Node curr= head;
            Node prev = slow;
            while(curr!=prev){
                curr = curr.next;
                prev = prev.next;
            }
            return curr.data;
        }
       
    }

    public static int intersection(LinkedList one , LinkedList two){
        Node ptr1 = one.head;
        Node ptr2 = two.head;
        int diff=Math.abs(one.size()-two.size());
        if(one.size()>two.size()){
            while(diff-->0){
                ptr1=ptr1.next;
            }
        }else if(one.size()<two.size()){
            while(diff-->0){
                ptr2 = ptr2.next;
            }
        }

        while(ptr1.data!=ptr2.data){
            ptr1=ptr1.next;
            ptr2=ptr2.next;
        }
        return ptr1.data;
    }  

    
    
    
    public static void main(String args[]){
        LinkedList lt = new LinkedList();
        lt.addLast(10);
        lt.addLast(20);
        lt.addLast(30);
        lt.addLast(40);
        lt.addFront(50);
        lt.addIndex(60,2);
        lt.addLast(70);
        System.out.println(lt.size());

        // lt.deleteFront();
        // lt.deleteLast();
        // lt.deleteIndex(2);
        // System.out.println(lt.size());
        lt.display();

        System.out.println(lt.kthNodeFromLast(-1));
        // System.out.println(lt.head);
        System.out.println(lt.mid());


        LinkedList lt2 = new LinkedList();
        lt2.addLast(110);
        lt2.addLast(120);
        lt2.addLast(30);
        lt2.addLast(140);
        lt2.addLast(170);
        lt2.addFront(100);
        lt2.display();

        System.out.println(intersection(lt, lt2));

        lt.reverseLinkedListData();
        lt.display();
        lt.reverseLinkedListPointer();
        lt.display();
        lt.reverseLinkedListRecursive();
        lt.display();

        System.out.println(lt.hasCycle());
        System.out.println(lt.startingPointCycle());
        
        
    }
}