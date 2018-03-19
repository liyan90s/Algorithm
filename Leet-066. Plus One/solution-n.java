class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[] {};
        }
        
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i] + carry;
            carry = digit >= 10 ? 1 : 0;
            digits[i] = digit % 10;
        }
        
        // if carry here is 1, which means all the trailing digits are 0
        if (carry == 1) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        
        return digits;
    }
}