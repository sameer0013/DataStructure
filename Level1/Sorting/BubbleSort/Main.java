public class Main {
    public  static int[] sortArray(int[] nums) {
        //         Bubble sort
                selectionSort(nums);
                return nums;
               
            }
    public static void bubbleSort(int[] nums){
        int n =nums.length;
        for(int itr=1;itr<=n-1;itr++){
            for(int i=0;i<=n-itr-1;i++){
                if(nums[i+1]<nums[i]) swap(nums,i,i+1);
                
            }
        }
    public static void swap(int[] nums,i,j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

    public static void main(String[] args) {
        int [] arr ={5,1,1,2,0,0};
        int [] arr2=sortArray(arr);
        for(int i:arr2) System.out.println(i);
    }
}
