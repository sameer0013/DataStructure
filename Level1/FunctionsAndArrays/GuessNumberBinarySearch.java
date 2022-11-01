//Leetcode question
public class GuessNumberBinarySearch {
    public int guessNumber(int n) 
    {
        
        int left=1,right=n;
        while(left<=right)
        {
            int mid =left+(right-left)/2;
            int res=guess(mid);
            if(res==-1){
                right=mid-1;
            }
            else if(res==1){
                left=mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    } 
    public int guess(int n){
        int pick=6;
        if(n==pick){
            return 0;
        }else if(n>pick){
            return -1;
        }else{
            return 1;
        }

    }  
    public static void main(String[] args) {
        GuessNumberBinarySearch gs= new GuessNumberBinarySearch();
        System.out.println(gs.guessNumber(10));

    }



}
    

