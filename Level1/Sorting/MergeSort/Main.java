import java.io.*;
import java.util.*;

public class Main {

  public static int[] mergeSort(int[] arr, int lo, int hi) {
    //write your code here
    if(lo==hi){
      return new int[] {arr[lo]};

    }
    int mid = lo +(hi-lo)/2;
    int[] left = mergeSort(arr,lo,mid);
    int[] right = mergeSort(arr,mid+1,hi);

    return mergeTwoSortedArrays(left,right);
  }

  //used for merging two sorted arrays
  public static int[] mergeTwoSortedArrays(int[] a, int[] b){
    System.out.println("Merging these two arrays ");
    System.out.print("left array -> ");
    print(a);
    System.out.print("right array -> ");
    print(b);
    int idx = 0, p1 =0, p2 = 0;
    int[] ans = new int[a.length + b.length];
    while(idx<ans.length){
      int v1 = (p1<a.length)? a[p1]:Integer.MAX_VALUE;
      int v2 = (p2<b.length)? b[p2]:Integer.MAX_VALUE;
      if(v1<v2){
        ans[idx] = v1;
        p1++;
      }else{
        ans[idx] = v2;
        p2++;
      }
      idx++;
    }
    return ans;
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int[] sa = mergeSort(arr,0,arr.length - 1);
    System.out.print("Sorted Array -> ");
    print(sa);
  }

}