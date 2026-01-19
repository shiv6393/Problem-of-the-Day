class Solution19thjanPod {
    public int maxSideLength(int[][] mat, int threshold) {
         int m=mat.length;
         int n=mat[0].length;
         int[][]rowSum=new int[m][n];
         for(int i=0;i<m;i++){
            int preSum=0;
            for(int j=0;j<n;j++){
                preSum+=mat[i][j];
                rowSum[i][j]=preSum;

            }
         }
        int minSize=Math.min(m,n);
        for(int size=minSize;size>=1;size--){
            for(int i=0;i+size<=m;i++){
                for(int j=0;j+size<=n;j++){
                    int squareSum=0;
                   for (int k=0; k<size;k++){
    squareSum += rowSum[i+k][j+size-1] 
               - (j>0 ?rowSum[i+k][j-1]:0);
}

                    if(squareSum<=threshold)return size;
                }
            }
        }
        return 0;
        
    }
}