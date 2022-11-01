public class Main{
    public  static class Node{
        int data;
        Node next;
    }

    public static class LinkedList{
        Node head;
        Node tail;
        int size;

        void addLast(int val){
            Node node =new Node();
            node.data=val;
            if(this.size==0){
                this.head=this.tail=node;
            }
            else{
                this.tail.next = node;
                this.tail = node;

            }
            this.size++;
        }
        int size(){
            return this.size;
        }

        void addFirst(int val){
            Node node = new Node();
            node.data=val;
            if(this.size==0){
                this.head=this.tail=node;
            }
            else{
                node.next=this.head;
                this.head=node;
            }
            this.size++;
        }

        void addAt(int idx,int val){
            Node node = new Node();
            node.data=val;

            if(idx==0) addFirst(val);
            else if(idx == this.size) addLast(val);
            else if (idx<0||idx>this.size) { 
                System.out.println("Invalid index");
                return;
            }
            else{
                Node ptr1=null;
                Node ptr2=head;
                while(idx!=0){
                    ptr1=ptr2;
                    ptr2=ptr2.next;
                    idx--;
                }
                ptr1.next = node;
                node.next=ptr2;
                this.size++;
            }
        }

        void display(){
            Node ptr=head;
            while(ptr!=null){
                System.out.print(ptr.data+" -> ");
                ptr=ptr.next;
            }
            System.out.println("null");
            
        }

        int getFirst(){
            if(this.size==0){
                System.out.println("List is empty");
                return -1;
            }
            return this.head.data;
        }

        int getLast(){
            if(this.size==0) {
                System.out.println("List is empty");
                return -1;
            }
            return this.tail.data;
        }

        int getAt(int idx){
            if(idx == 0){
                System.out.println("List is empty");
                return -1;
            }
            else if(idx<0||idx>=this.size){
                System.out.println("Invalid arguments");
                return -1;
            }

            Node ptr=head;
            while(idx!=0){
                ptr=ptr.next;
                idx--;
            }
            return ptr.data;
        }

        void removeFirst(){
            if(this.size==0){
                System.out.println("List is empty");
                return;
            }else if(this.size==1) this.head=this.tail=null;
            else{
                this.head=this.head.next;
            }
            this.size--;
        }

        void removeLast(){
            if(this.size==0){
                System.out.println("List is empty");
                return;
            }
            else if(this.size==1) this.head=this.tail=null;
            else{
                Node ptr =head;
                while(ptr.next!=this.tail){
                    ptr=ptr.next;
                }
                ptr.next=null;
                this.tail = ptr;
            }
            this.size--;
        }
        void removeAt(int idx){
            if(this.size==0){
                System.out.println("List is empty");
                return;
            }else if(idx==0) removeFirst();
            else if (idx==this.size-1) removeLast();
            else if(idx<0 || idx>=this.size()){
                System.out.println("Invalid arguments");
                return;
            }
            else{
                Node first=null;
                Node second=head;

                while(idx!=0){
                    first=second;
                    second = second.next;
                    idx--;
                }
                first.next=second.next;
                second.next=null;
                this.size--;
            }
        }

        int kthFromLast(int k){
            Node fast= this.head;
            Node slow = this.head;
            while(k!=0){
                fast=fast.next;
                k--;
            }
            while(fast!=tail){
                slow=slow.next;
                fast=fast.next;
            }
            return slow.data;
        }
        int midNode(){
            Node slow,fast;
            slow=fast=this.head;
            while(fast.next!=null&&fast.next.next!=null){
                fast=fast.next.next;
                slow=slow.next;
            }
            return slow.data;
        }


    }
    public static void main(String args[]){
        LinkedList list= new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        System.out.println(list.size());

        list.addFirst(50);
        list.addFirst(60);
        System.out.println(list.size());

        list.addAt(2, 90);
        list.addAt(7, 100);
        System.out.println(list.size());

        list.addAt(18, 78); //invalid case

        list.display();

        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.getAt(3));

        list.removeFirst();
        list.removeLast();
        list.removeAt(2);

        list.display();

        System.out.println("Kth node from last: "+list.kthFromLast(2));
        
        System.out.println("Mid node of Linked List is : "+list.midNode());
    }
}