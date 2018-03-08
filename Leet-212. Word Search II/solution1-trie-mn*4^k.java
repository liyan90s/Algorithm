// Time: O(mn * 4^k), where k = longest word's length in the words array
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        
        Set<String> set = new HashSet<>();
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, "", i, j, trie, set);
            }
        }
        
        return new ArrayList<String>(set);
    }
    
    public void dfs(char[][] board, String str, int x, int y, Trie trie, Set<String> set) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == '$') {
            return;
        }
        
        str += board[x][y];
        if (!trie.prefix(str)) return;
        
        if (trie.search(str)) {
            set.add(str);
        }
        
        char temp = board[x][y];
        board[x][y] = '$';
        
        dfs(board, str, x - 1, y, trie, set);
        dfs(board, str, x + 1, y, trie, set);
        dfs(board, str, x, y - 1, trie, set);
        dfs(board, str, x, y + 1, trie, set);
        board[x][y] = temp;
    }

    class Trie {
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }
    
        /*
         * @param word: a word
         * @return: nothing
         */
        public void insert(String word) {
            if (word == null || word.length() == 0) {
                return ;
            }
            
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new TrieNode();
                }
                node = node.children[ch - 'a'];
            }
            
            node.isEnd = true;
        }
    
        /*
         * @param word: A string
         * @return: if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode node = searchHelper(word);
            return node != null && node.isEnd;
        }
        
        public boolean prefix(String word) {
            TrieNode node = searchHelper(word);
            return node != null;
        }   
        
        public TrieNode searchHelper(String word) {
            if (word == null || word.length() == 0) {
                return null;
            }
            
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (node.children[ch - 'a'] == null) {
                    return null;
                }
                node = node.children[ch - 'a'];
            }
            
            return node;            
        }        
        
        class TrieNode {
            TrieNode[] children;
            boolean isEnd;
            
            public TrieNode() {
                children = new TrieNode[26];
                isEnd = false;
            }
        }
    }    
}