import java.util.Scanner;

public class PointOfParity {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = scn.nextInt();
            
        }
        
        System.out.println(pos(arr));
    }
    public static int pos(int[] arr){
        int sum=0;
        int lsum=0;
        for(int i =0;i<arr.length;i++){
            sum = sum+arr[i];
        }
        for(int i =0;i<arr.length;i++){
            sum = sum -arr[i];
            if(lsum == sum) return i;
            lsum = lsum + arr[i];
        }    
        return -1;
        
    }
        
    
}