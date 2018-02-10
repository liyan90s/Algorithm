class Solution {
    public String intToRoman(int num) {
        int[] vals = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuffer sb = new StringBuffer();
        
        for (int i = 0; i < vals.length; i++) {
            while (num >= vals[i]) {
                sb.append(strs[i]);
                num -= vals[i];
            }
        }
        
        return sb.toString();
    }
}