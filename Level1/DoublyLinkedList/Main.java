public class Main{

    public static class MyLinkedList {
        public  static class Node{
            int data;
            Node prev;
            Node next;
        }
        Node head;
        Node tail;
        int size;
        
        public MyLinkedList() {
            this.head=null;
            this.tail=null;
            this.size=0;
        }
        
        public int get(int index) {
            if(index<0||index>=this.size){
                return -1;
            }
            Node ptr = this.head;
            while(index!=0){
                ptr=ptr.next;
                index--;
            }
            return ptr.data;
        }
        
        public void addAtHead(int val) {
            Node node = new Node();
            node.data = val;
            if(this.size==0){
                
                this.head=this.tail=node;
                
            }
            else{
                node.prev=null;
                node.next=this.head;
                this.head.prev=node;
                this.head=node;
            }
            this.size++;
        }
        
        public void addAtTail(int val) {
            Node node = new Node();
            node.data=val;
            if(this.size==0){
                this.head=this.tail=node;
            }else{
                this.tail.next=node;
                node.prev=this.tail;
                this.tail=node;
            }
            this.size++;
            
        }
        
        
        public void addAtIndex(int index, int val) {
            if(index<0||index>this.size) return;
            else if(index==0) addAtHead(val);
            
            else if(index==this.size) addAtTail(val);
            else{
                Node node = new Node();
                node.data=val;
                Node ptr1=null; 
                Node ptr2=head;
                while(index!=0){
                    ptr1=ptr2;
                    ptr2=ptr2.next;
                    index--;
                }
                ptr1.next=node;
                node.prev=ptr1;
                node.next=ptr2;
                ptr2.prev=node;
                this.size++;
            }
        }
        
        public void deleteAtHead(){
            if(this.size==0) return;
            else if(this.size==1) {
                this.head=this.tail=null;
            }
            else{
                Node nbr = this.head.next;
                this.head.next=null;
                this.head.prev=null;
                this.head=nbr;
                
            }
            this.size--;
        }
        
        
        public void deleteAtTail(){
            if(this.size ==0) return;
            else if(this.size==1){
                this.head = this.tail=null;
            }else{
               Node prvNode = this.tail.prev;
                this.tail.prev=null;
                prvNode.next=null;
                this.tail=prvNode;
            }
             
                this.size--;
        }
        public void deleteAtIndex(int index) {
            if(index<0||index>=this.size) return;
            else if(index==0){
                deleteAtHead();
            }
            else if(index==this.size-1){
               deleteAtTail();
            }else{
                Node currNode = this.head;
                
                while(index!=0){
                    currNode=currNode.next;
                    index--;
                }
                Node prvNode =currNode.prev;
                Node nxtNode = currNode.next;
                
                prvNode.next=nxtNode;
                nxtNode.prev=prvNode;
                
                currNode.next=null;
                currNode.prev=null;
                
                this.size--;
            }
            
        }
    }
    
    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(10);
        list.addAtHead(20);
        list.addAtHead(30);
    }    
}