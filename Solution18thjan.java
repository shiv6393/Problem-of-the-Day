class Solution18thjan {

    private boolean rowComp(int i, int j, int size, int[][] rowSum, int target) {
        for (int r = i; r < i + size; r++) {
            int sum = rowSum[r][j + size - 1] - (j > 0 ? rowSum[r][j - 1] : 0);
            if (sum != target) return false;
        }
        return true;
    }

    private boolean colComp(int i, int j, int size, int[][] colSum, int target) {
        for (int c = j; c < j + size; c++) {
            int sum = colSum[i + size - 1][c] - (i > 0 ? colSum[i - 1][c] : 0);
            if (sum != target) return false;
        }
        return true;
    }

    private int diagonalSum(int i, int j, int size, int[][] grid) {
        int sum = 0;
        for (int k = 0; k < size; k++) {
            sum += grid[i + k][j + k];
        }
        return sum;
    }

    private int antiDiagonalSum(int i, int j, int size, int[][] grid) {
        int sum = 0;
        for (int k = 0; k < size; k++) {
            sum += grid[i + k][j + size - 1 - k];
        }
        return sum;
    }

    public int largestMagicSquare(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] rowSum = new int[n][m];
        int[][] colSum = new int[n][m];
        for (int i = 0; i < n; i++) {
            int preSum = 0;
            for (int j = 0; j < m; j++) {
                preSum += grid[i][j];
                rowSum[i][j] = preSum;
            }
        }
        for (int j = 0; j < m; j++) {
            int preSum = 0;
            for (int i = 0; i < n; i++) {
                preSum += grid[i][j];
                colSum[i][j] = preSum;
            }
        }

        int min = Math.min(n, m);

        for (int size = min; size >= 2; size--) {
            for (int i = 0; i + size <= n; i++) {
                for (int j = 0; j + size <= m; j++) {

                    int target =
                        rowSum[i][j + size - 1] - (j > 0 ? rowSum[i][j - 1] : 0);

                    if (!rowComp(i, j, size, rowSum, target)) continue;
                    if (!colComp(i, j, size, colSum, target)) continue;

                    if (diagonalSum(i, j, size, grid) != target) continue;
                    if (antiDiagonalSum(i, j, size, grid) != target) continue;

                    return size;
                }
            }
        }
        return 1;
    }
}
