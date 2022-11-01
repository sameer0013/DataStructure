import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        int[] a= new int[n];
        for(int i=0;i<a.length;i++){
            a[i]=scn.nextInt();
        }
        int k=scn.nextInt();
        System.out.println(binarySearch(a,k));
    }
    public static int binarySearch(int[] a,int k){
        int st=0,ed=a.length-1;
        while(st<=ed){
            int mid=(st+ed)/2;
            if(a[mid]<k){
                st=mid+1;
            }else if(a[mid]>k){
                ed=mid-1;
            }
            else{
                return mid;
            }

        }
        return -1;
    }
}
