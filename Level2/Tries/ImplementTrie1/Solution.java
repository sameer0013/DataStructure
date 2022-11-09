import java.util.*;
class Trie {
    
    private class Node{
        char ch;
        HashMap<Character,Node> children;
        boolean isEnd;
        Node(char ch){
            this.ch = ch;
            this.children = new HashMap<>();
            this.isEnd = false;
        }
        
        boolean hasChild(char childCh){
            return this.children.containsKey(childCh);
        } 
        
        Node getChild(char childCh){
            return this.children.get(childCh);
        }
        
        Node addChild(char childCh){
            if(this.children.containsKey(childCh)){
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
    }
    
    private Node root;
    public Trie() {
        this.root= new Node(' ');
    }
    
    public void insert(String word) {
        Node ptr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(ptr.hasChild(ch)){
                ptr = ptr.getChild(ch);
            }
            else{
                ptr = ptr.addChild(ch);
            }
        }
        ptr.markEndOfWord();
    }
    
    public boolean search(String word) {
        Node ptr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(ptr.hasChild(ch)){
                ptr = ptr.getChild(ch);
            }else{
                return false;
            }
        }
        return ptr.endOfWord();
    }
    
    public boolean startsWith(String prefix) {
         Node ptr = root;
        for(int i=0;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            if(ptr.hasChild(ch)){
                ptr = ptr.getChild(ch);
            }else{
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */