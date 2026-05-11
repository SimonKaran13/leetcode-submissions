class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        
        int l = 0;
        int r = 1;
        int maxProfit = 0;
        while (l < prices.length - 1) {
            int buyPrice = prices[l];
            int sellPrice = prices[r];
            int profit = sellPrice - buyPrice;
            if (profit > maxProfit) maxProfit = profit;

            if (buyPrice > sellPrice) {
                l++;
            }

            if (r < prices.length - 1) {
                r++;
            } else {
                l++;
            }
        }
        return maxProfit;
    }
}
