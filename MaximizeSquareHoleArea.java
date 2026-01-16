class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int maxConsecitiveHbars=1;
        int maxConsecitiveVbars=1;
        int temp=1;
        for(int i=0;i<hBars.length-1;i++){
          if(hBars[i]+1 == hBars[i+1]){
            temp++;
           maxConsecitiveHbars= Math.max(temp,maxConsecitiveHbars);
            }
          else temp=1;
          
        }
        temp=1;
        for(int i=0;i<vBars.length-1;i++){
          if(vBars[i]+1==vBars[i+1]){
            temp++;
           maxConsecitiveVbars= Math.max(temp,maxConsecitiveVbars);
            }
          else temp=1;

        }
        int min=Math.min(maxConsecitiveVbars,maxConsecitiveHbars);
        return (min+1)*(min+1);
        

        
    }
}