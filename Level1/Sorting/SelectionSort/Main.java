import java.util.Scanner;
class Main {
    public  static int[] sortArray(int[] nums) {
//         selection sort
        selectionSort(nums);
        return nums;
       
    }
    public static void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    public static void selectionSort(int[] nums){
        int n = nums.length;
        for(int itr=1;itr<=n-1;itr++){
            int mIdx = itr-1;
            for(int i=itr;i<n;i++){
                if(nums[mIdx]>nums[i]) mIdx=i;
            }
            swap(nums,mIdx,itr-1);
        }
    }
    public static  void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int [] arr ={5,1,1,2,0,0};
        int [] arr2=sortArray(arr);
        for(int i:arr2) System.out.println(i);

    }
}