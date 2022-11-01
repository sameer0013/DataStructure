import java.util.*;
class Main {
    private static void quicksort(int[] arr, int lo,int hi ){
        if(lo>=hi) return;
        
        Random rand = new Random();
        int idx = rand.nextInt(hi-lo)+lo;
        swap(arr,idx,hi);
        int pivot = arr[hi];
        int pidx = getPivotIndex(arr,pivot,lo,hi);
        
        if(lo<pidx-1) quicksort(arr,lo,pidx-1);
        if(pidx+1<hi) quicksort(arr,pidx+1,hi);
    }
    
    private static int getPivotIndex(int[] arr, int pivot, int lo,int hi){
        int i=lo,j=lo;
        while(j<=hi){
            if(arr[j]<=pivot){
                swap(arr,i,j);
                i++;j++;
            }else{
                j++;
            }
        }
        return i-1;
    }
    
    private static void swap(int[] arr, int i,int j){
        int temp = arr[i];
        arr[i]= arr[j];
        arr[j]= temp;
    }
    public int[] sortArray(int[] nums) {
        quicksort(nums,0,nums.length-1);
        return nums;
    }
}