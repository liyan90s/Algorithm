// Time: O(lmn * 4^k), where 
// l = words.length, m = board.length, n = board[0].length, k = word.length()
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return res;
        }        
        
        for (String word : words) {
            if (exist(board, word) && !res.contains(word)) {
                res.add(word);
            }
        }
        
        return res;
    }
    
    public boolean exist(char[][] board, String word) {        
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean search(char[][] board, String word, int index, int row, int col, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }
        
        visited[row][col] = true;
        boolean result = search(board, word, index + 1, row - 1, col, visited) ||
                         search(board, word, index + 1, row + 1, col, visited) ||
                         search(board, word, index + 1, row, col - 1, visited) ||
                         search(board, word, index + 1, row, col + 1, visited);
        
        visited[row][col] = false;
        return result;
    }    
}