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
