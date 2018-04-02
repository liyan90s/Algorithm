// Use quick sort idea
public class Solution {
    /**
     * @param alphabet: the new alphabet
     * @param words: the original string array
     * @return: the string array after sorting
     */
    public String[] wordSort(char[] alphabet, String[] words) {
        // Write your code here
        if (words == null || words.length <= 1) {
            return words;
        }
        
        quickSort(alphabet, words, 0, words.length - 1);
        return words;
    }
    
    public void quickSort(char[] alphabet, String[] words, int left, int right) {
        if (left >= right) {
            return ;
        }
        
        String pivot = words[left];
        int lo = left + 1;
        int hi = right;
        
        while (lo <= hi) {
            while (lo <= hi && compareWords(alphabet, words[lo], pivot)) {
                lo++;
            }
            
            while (lo <= hi && compareWords(alphabet, pivot, words[hi])) {
                hi--;
            }
            
            if (lo <= hi) {
                swap(words, lo, hi);
                lo++;
                hi--;
            }
        }
        
        swap(words, left, hi);
        
        if (left < hi) {
            quickSort(alphabet, words, left, hi);
        }
        
        if (lo < right) {
            quickSort(alphabet, words, lo, right);
        }
    }
    
    public void swap(String[] words, int l, int r) {
        String temp = words[l];
        words[l] = words[r];
        words[r] = temp;
    }
    
    // return true is w1 comes before w2
    public boolean compareWords(char[] alphabet, String w1, String w2) {
        if (w1 == null || w1.length() == 0) {
            return true;
        }
        
        if (w2 == null || w2.length() == 0) {
            return false;
        }
        
        boolean res = false;
        int i = 0, j = 0;
        while (i < w1.length() && j < w2.length()) {
            if (w1.charAt(i) == w2.charAt(j)) {
                i++;
                j++;
            } else {
                res = findIdx(alphabet, w1.charAt(i)) < findIdx(alphabet, w2.charAt(j));
                return res;
            }     
        }
        
        if (i == w1.length() && j < w2.length()) {
            return true;
        } else {
            return false;
        }
    }
    
    public int findIdx(char[] alphabet, char ch) {
        int i = 0;
        while (i < alphabet.length) {
            if (alphabet[i] == ch) {
                break ;
            }
            i++;
        }
        
        return i;
    }
}