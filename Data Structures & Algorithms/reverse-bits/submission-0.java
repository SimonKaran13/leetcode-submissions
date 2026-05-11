class Solution {
    public int reverseBits(int n) {
         int res = 0;
        for (int i = 32; i > 0; --i) {
            int bit = n & 0b1;
            res = res | (bit << i - 1);
            n = n >> 1;
        }
        return res;
    }
}
