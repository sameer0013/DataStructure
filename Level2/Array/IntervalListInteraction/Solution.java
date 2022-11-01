class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int[]> list = new ArrayList<>();
        int i=0,j=0;
        while(i<firstList.length && j<secondList.length){
            int[] interval1 = firstList[i];
            int[] interval2 = secondList[j];
            int sp1 = interval1[0],ep1= interval1[1];
            int sp2 = interval2[0],ep2= interval2[1];
            if(sp1<=ep2 && ep1>=sp2){
               int[] arr = {Math.max(sp1,sp2),Math.min(ep1,ep2)};
                list.add(arr);
            }
            
            if(ep1<ep2) i++;
            else j++;

        }
        
        return list.toArray(new int[list.size()][]);
    }
}