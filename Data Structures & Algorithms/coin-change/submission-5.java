class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        Arrays.sort(coins);

        HashMap<Integer, Integer> cache = new HashMap<>();
        for (int coin: coins) {
            cache.put(coin, 1); // Base cases
        }
        
        return topDown(amount, coins, cache) == Integer.MAX_VALUE ? -1 : cache.get(amount);
    }

    private int topDown(int target, int[] coins, HashMap<Integer, Integer> cache) {
        if (target < 0) return Integer.MAX_VALUE;
        if (target == 0) return 0;
        if (cache.containsKey(target)) return cache.get(target);

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int num = topDown(target - coin, coins, cache);
            if (num != Integer.MAX_VALUE) {
                res = Math.min(num + 1, res);
            }
        }
        cache.put(target, res);
        return res;
    }

    private int numOfCoins(int target, int current, int[] coins) {
        if (target < 0) return -1;
        if (target == 0) return current;
        
        int res = -1;
        for (int i = coins.length - 1; i >= 0; i--) {
            int num = numOfCoins(target - coins[i], current + 1, coins);
            if (res == -1 && num > res) {
                res = num;
            } else if (num < res && num > -1) {
                res = num;
            }
        }
        return res;
    }
}
