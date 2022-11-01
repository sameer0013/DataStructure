import java.util.*;
class Solution {
    public int maxArea(int[] height) {
        int i=0,j=height.length-1;
        int ih,jh;
        int cal,maxamt=0;
        while(j>i){
            ih = height[i];
            jh = height[j];
            if(ih>jh){
                cal = jh*(j-i);
                j--;
            }else{
                cal = ih*(j-i);
                i++;
            }
            if(cal>maxamt)
                maxamt =cal;
        }
        return maxamt;
    }
}