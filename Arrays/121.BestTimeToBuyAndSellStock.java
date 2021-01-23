// 121 Best time to buy and sell stock
    public int maxProfit(int prices[]) {
      // Initialize a maxProfit variable with zero
        int maxProfit = 0;
        // Iterate through the prices array
        // The outer loop starts at the first index and runs till prices.length - 1
        for (int i = 0; i < prices.length - 1; i++) {
          // The inner loop starts one index to the right of the outer loop's index
          // and runs till prices.length which is one step further than the outer loop
            for (int j = i + 1; j < prices.length; j++) {
              // A new variable called profit is intialized on each iteration
              // with the value of prices at inner loop minus prices at outer loop
                int profit = prices[j] - prices[i];
                // If this price is greater than the current max profit
                if (profit > maxProfit)
                // Then make it the new max profit
                    maxProfit = profit;
            }
        }
        // Now the highest profit recoreded is found in the max profit variable return it
        return maxProfit;
    }
