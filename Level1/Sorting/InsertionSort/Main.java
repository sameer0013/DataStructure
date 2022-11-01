class Mian{
    public static void insertionSort(int[] nums)
    {
        for(int itr=1;itr<=nums.length-1;itr++){
            for(int idx =itr;idx>0;idx--){
                if(nums[idx]<nums[idx-1]){
                    swap(nums,idx,idx-1);
                }else{
                    break;
                }
            }

        }
    }
    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public static void display(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        int[] arr={7,5,3,2,1,6,4,0};
        insertionSort(arr);
        display(arr);
     }

}
