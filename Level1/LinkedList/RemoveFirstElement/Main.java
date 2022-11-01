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

        void display(){
            Node ptr = this.head;
            while(ptr!=null){
                System.out.println(ptr.data);
                ptr=ptr.next;
            }
            //System.out.println(this.tail.data);
        }

        public void removeFirst(){
            // write your code here
            if(this.size==0){
              System.out.println("List is empty");

            }else{
                if(this.size==1) {
                    this.head=this.tail=null;

                }else{
                    Node nbr = this.head.next;
                    this.head.next=null;
                    this.head=nbr;
                }
                this.size--;
            }
            
          }
    }
        public static void main(String[] args) {
            LinkedList ll = new LinkedList();
            ll.addLast(10);
            ll.addLast(20);
            ll.addLast(30);
            ll.addLast(40);
            ll.display();
            System.out.println(ll.size());
        }
}

