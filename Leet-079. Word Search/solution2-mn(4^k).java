// Time: O(mn*(4^k)), where k is the word.length()
// Space: O(mn)
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
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search(board, word, i, j, visited, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean search(char[][] board, String word, int row, int col, boolean[][] visited, int index) {
        if (index == word.length()) {
            return true;
        }
        
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }
        
        visited[row][col] = true;
        boolean result = search(board, word, row - 1, col, visited, index + 1) || 
                         search(board, word, row + 1, col, visited, index + 1) ||
                         search(board, word, row, col - 1, visited, index + 1) ||
                         search(board, word, row, col + 1, visited, index + 1);
                         
        visited[row][col] = false;
        return result;
    }
}