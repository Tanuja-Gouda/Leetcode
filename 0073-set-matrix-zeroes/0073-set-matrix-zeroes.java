class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[] rowzero = new boolean[rows];
        boolean[] colzero = new boolean[cols];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j] == 0){
                    rowzero[i] = true;
                    colzero[j] = true;
                }
            }
        }

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(rowzero[i] || colzero[j]){
                    matrix[i][j] = 0;
                }
            }
        }













        // int n = matrix.length;       // Number of rows
        // int m = matrix[0].length;    // Number of columns

        // // Use two boolean arrays to mark rows and columns to be zeroed
        // boolean[] rowZero = new boolean[n];
        // boolean[] colZero = new boolean[m];

        // // First pass: Identify the rows and columns that should be zeroed
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         if (matrix[i][j] == 0) {
        //             rowZero[i] = true;
        //             colZero[j] = true;
        //         }
        //     }
        // }

        // // Second pass: Set the rows and columns to zero
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         if (rowZero[i] || colZero[j]) {
        //             matrix[i][j] = 0;
        //         }
        //     }
        // }
    }
}
