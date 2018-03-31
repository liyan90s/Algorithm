class Solution {
    public int[][] candyCrush(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return board;
        }
        
        int rows = board.length, cols = board[0].length;
        boolean todo = false;
        // 1st, mark the candy with same rows and cols
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int val = Math.abs(board[r][c]);
                if (val > 0 && c >= 2 && Math.abs(board[r][c - 1]) == val && Math.abs(board[r][c - 2]) == val) {
                    board[r][c] = board[r][c - 1] = board[r][c - 2] = -val;
                    todo = true;
                }
            }
        }
        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows; r++) {
                int val = Math.abs(board[r][c]);
                if (val > 0 && r >= 2 && Math.abs(board[r - 1][c]) == val && Math.abs(board[r - 2][c]) == val) {
                    board[r][c] = board[r - 1][c] = board[r - 2][c] = -val;
                    todo = true;
                }
            }
        }
        
        // 2nd, drop the candies (crush)
        drop(board, rows, cols);
        
        return todo ? candyCrush(board) : board;
    }
    
    public void drop(int[][] board, int rows, int cols) {
        for (int c = 0; c < cols; c++) {
            int ptr = rows - 1;
            for (int r = rows - 1; r >= 0; r--) {
                if (board[r][c] > 0) {
                    board[ptr][c] = board[r][c];
                    ptr--;
                }
            }
            
            while (ptr >= 0) {
                board[ptr][c] = 0;
                ptr--;
            }
        }
    }
}