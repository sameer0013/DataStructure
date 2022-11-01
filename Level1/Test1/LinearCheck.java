// 5
// 0 1
// 0 2
// 1 3
// 0 4
// 0 5
// output-NO
import java.util.Scanner;

public class LinearCheck 
 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int arr[][]=new int[n][2];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                arr[i][j]=scn.nextInt();
            }
        }
        int countx=0;
        int county=0;
        
            
                
        for(int i=1;i<n;i++)
        {
            if(arr[i-1][0]==arr[i][0])
            {
                countx++;
            }else{
                countx=0;
                break;
            }
        }
                
                
        for(int i=1;i<n;i++)
        {
            if(arr[i-1][1]==arr[i][1])
            {
                county++;
            }else{
                county=0;
                break;
            } 
        }
                
            
        if(countx>0||county>0){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
            
        
    }
}
