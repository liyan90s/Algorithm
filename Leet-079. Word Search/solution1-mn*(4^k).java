// Time: O(mn*(4^k)), where k = word.length()
public class Solution {
    /*
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean search(char[][] board, String word, int row, int col, int index) {
        if (index == word.length()) {
            return true;
        }
        
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }
        
        board[row][col] = '$';
        boolean result = search(board, word, row - 1, col, index + 1) || 
                         search(board, word, row + 1, col, index + 1) ||
                         search(board, word, row, col - 1, index + 1) ||
                         search(board, word, row, col + 1, index + 1);
                         
        board[row][col] = word.charAt(index);
        return result;
    }
}