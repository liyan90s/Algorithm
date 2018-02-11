class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new LinkedList<>();
        }
        
        LinkedList<String> res = new LinkedList<>();
        res.add("");
        String[] dict = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        for (int i = 0; i < digits.length(); i++) {
            String letters = dict[digits.charAt(i) - '0'];
            while (!res.isEmpty() && res.peek().length() == i) {
                String prev = res.remove();
                for (int j = 0; j < letters.length(); j++) {
                    res.add(prev + letters.charAt(j));
                }
            }
        }
        
        return res;
    }
}