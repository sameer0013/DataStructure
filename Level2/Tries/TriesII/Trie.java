import java.util.* ;
import java.io.*; 
public class Trie {
    private class Node{
        char ch;
        HashMap<Character,Node> children;
        boolean isEnd;
        int count;
        Node(char ch){
            this.ch = ch;
            this.children = new HashMap<>();
            this.isEnd = false;
            this.count =1;
        }
        
        boolean hasChild(char childCh){
            return this.children.containsKey(childCh);
        }
        Node getChild(char childCh){
            return this.children.get(childCh);
        }
        Node addChild(char childCh){
            if(this.children.containsKey(childCh)){
                
                this.children.get(childCh).count++;
                return this.children.get(childCh);
            }
            Node childNode = new Node(childCh);
            this.children.put(childCh,childNode);
            return childNode;
        }
        
        void markEndOfWord(){
            this.isEnd = true;
        }
        boolean endOfWord(){
            return this.isEnd;
        }
        void unMarkEndOfWord(){
            this.isEnd = false;
        }
        
        int getWordCount(){
            return this.count;
        }
        
        void removeChild(){
            this.count--;
        }
    }
    Node root ;
    public Trie() {
        // Write your code here.
        this.root = new Node(' ');
    }

    public void insert(String word) {
        // Write your code here.
        Node ptr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            ptr = ptr.addChild(ch);
        }
        ptr.markEndOfWord();
    }

    public int countWordsEqualTo(String word) {
        // Write your code here.
        Node ptr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(ptr.hasChild(ch)){
                ptr = ptr.getChild(ch);
            }else{
                return 0;
            }
            
        }
        if(ptr.endOfWord()){
            return ptr.getWordCount();
        }else{
            return 0;
        }
        
    }

    public int countWordsStartingWith(String word) {
        // Write your code here.
        Node ptr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(ptr.hasChild(ch)){
                ptr = ptr.getChild(ch);
            }else{
                return 0;
            }
            
        }
        return ptr.getWordCount();
    }

    public void erase(String word) {
        // Write your code here.
        Node ptr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(ptr.hasChild(ch)){
                ptr = ptr.getChild(ch);
                ptr.removeChild();
            }  
        }
        ptr.unMarkEndOfWord();
        
    }

}
