// leetcode question
import java.util.*;
public class SqrtOfxUsingBinarySearch {
    public int mySqrt(int x) {
       if(x<2){
           return x;
       }
       int left=2,right=x/2;
       while(left<=right){
           int mid = left+(right-left)/2;
           long curentsqr=(long)mid*mid;
           if(curentsqr<x){
               left=mid+1;
           }else if(curentsqr>x){
               right=mid-1;

           }else{
               return mid;
           }
       }
       return right;
        
        
    }
    public static void main(String[] args) {
        SqrtOfxUsingBinarySearch sq= new SqrtOfxUsingBinarySearch();
        System.out.println(sq.mySqrt(21344));
    }
}
