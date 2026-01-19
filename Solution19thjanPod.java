class Solution19thjanPod {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;
        int[][] preSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                preSum[i][j] = mat[i - 1][j - 1]
                        + preSum[i - 1][j]
                        + preSum[i][j - 1]
                        - preSum[i - 1][j - 1];
            }
        }

        int low = 0, high = Math.min(m, n);

        while (low < high) {
            int mid = (low + high + 1) / 2;

            if (existsSquare(preSum, mid, threshold)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    private boolean existsSquare(int[][] preSum, int size, int threshold) {
        for (int i = size; i < preSum.length; i++) {
            for (int j = size; j < preSum[0].length; j++) {
                int sum = preSum[i][j]
                        - preSum[i - size][j]
                        - preSum[i][j - size]
                        + preSum[i - size][j - size];
                if (sum <= threshold) return true;
            }
        }
        return false;
    }
}
