class MatrixSum {
    public long maxMatrixSum(int[][] matrix) {
        long sum=0;
        int negCount=0;
        int n=matrix.length;
        int min=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sum+=Math.abs(matrix[i][j]);
                min=Math.min(min,Math.abs(matrix[i][j]));
                if(matrix[i][j]<0){
                    negCount++;
                }
            }

        }
        System.out.println(sum);
     return (negCount % 2 == 0) ? sum : sum - 2 * min ;
    }
}