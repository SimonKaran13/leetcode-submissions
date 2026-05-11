class Solution {
    public int[] countBits(int n) {
        // 0, 1, 10,       11,          100,         101,       110,         111,        1000, 1001, 1010, 1011, 1100, 1101, 1110, 1111, 10000
    // res 0, 1, res[0]+1, res[1] + 1,  res[0] + 1, res[1] + 1, res[2] + 1, res[3]+1,
        if (n == 0) {
            int[] res = {0};
            return res;
        }
        if (n == 1) {
            int[] res = {0,1};
            return res;
        }
        
        int[] res = new int[n + 1];
        res[0] = 0;
        res[1] = 1;
        int mod = 2;

        for (int i = 2; i <= n; i++) {
            if (i > mod && i % mod == 0) mod *= 2;
            res[i] = res[i % mod] + 1;
        }
        return res;
        // 
    }
}
