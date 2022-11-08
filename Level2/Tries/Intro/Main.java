package Intro;

import java.util.*;

public class Main{
    static class Node{
        char ch;
        HashMap<Character,Node> children;
        boolean isEnd;
        int count;
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

        boolean isEndOfWord(){
            return isEnd;
        }

        void unMarkEndOfWord(){
            this.isEnd = false;
        }

        int getCount(){
            return this.count;
        }

        void changeCount(int vl){
            this.count = vl;
        }
    }
    static class Trie{
        
        Node root;
        Trie(){
            this.root = new Node(' ');
        }

        void insert(String word){
            Node ptr = root;
            ptr.changeCount(ptr.getCount()+1);
            for(int i=0;i<word.length();i++){
                char ch = word.charAt(i);
                if(ptr.hasChild(ch)){
                    ptr = ptr.getChild(ch);
                }else{
                    ptr = ptr.addChild(ch);
                }
                ptr.changeCount(ptr.getCount()+1);
            }
            ptr.markEndOfWord();
        }

        boolean search(String word){
            Node ptr = root;
            for(int i=0;i<word.length();i++){
                char ch = word.charAt(i);
                if(ptr.hasChild(ch)){
                    ptr = ptr.getChild(ch);
                }else{
                    return false;
                }
            }
            return ptr.isEndOfWord();
        }

        boolean prefix(String word){
            Node ptr = root;
            for(int i=0;i<word.length();i++){
                char ch = word.charAt(i);
                if(ptr.hasChild(ch)){
                    ptr = ptr.getChild(ch);
                }else{
                    return false;
                }

                
            }
            return ptr.getCount()>0;
        }

        void remove(String word){
            if(!search(word)) return;

            Node ptr = root;
            ptr.changeCount(ptr.getCount()-1);
            for(int i=0;i<word.length();i++){
                char ch = word.charAt(i);
                if(ptr.hasChild(ch)){
                    ptr = ptr.getChild(ch);
                }
                ptr.changeCount(ptr.getCount()-1);
                
            }
            ptr.unMarkEndOfWord();;
        }
    }

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("apple");
        obj.insert("apples");
        obj.insert("app");
        obj.insert("bank");
        obj.insert("ban");
        obj.insert("bat");
        obj.insert("zeeee");

        System.out.println(obj.search("app"));
        System.out.println(obj.search("ap"));
        System.out.println(obj.prefix("ap"));
    }
}