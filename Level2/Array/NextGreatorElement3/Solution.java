import java.util.*;
class Solution {
    public int[] intToArr(int n){
        char[] carr = Integer.toString(n).toCharArray();
        int[] arr = new int[carr.length];
        int i=0;
        for(char ch : carr){
            arr[i] = ch-'0';
            i++;
        }
        return arr;
    }
    public void reverse(int[] nums,int lo,int hi){
        while(lo<hi){
            swap(nums,lo,hi);
            lo++;hi--;
        }
    }
    public void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j]=tmp;
    }
    public void nextPermutation(int[] arr){
        int i=-1;
        for(int idx =arr.length-2;idx>=0;idx--){
            if(arr[idx]<arr[idx+1]){
                i=idx;
                break;
            }
        }
        
        if(i==-1){
            //do nothing
        }else{
            int j=-1;
            for(int idx =arr.length-1;idx>=i;idx--){
                if(arr[idx]>arr[i]){
                    j=idx;
                    break;
                }
            }
            
            swap(arr,i,j);
            reverse(arr,i+1,arr.length-1);
        }
    }
    public long arrToInt(int arr[]){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            sb.append(arr[i]+"");
        }
        return Long.parseLong(sb.toString());
    }
    public int nextGreaterElement(int n) {
        int[] arr = intToArr(n);
        nextPermutation(arr);
        long vl = arrToInt(arr);
        if(vl==n||vl>Integer.MAX_VALUE) return -1;
        return (int)vl;
    }
}
