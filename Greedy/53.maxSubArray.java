// Maximum Subarray with Greedy Approach
  public int maxSubArray(int[] nums) {
    // initialize an integer with the length of the array
    int n = nums.length;
    // then initialize a currSum variable, and a maxSum variable with value at first index of array
    int currSum = nums[0], maxSum = nums[0];
    // iterate through the array
    // start at second index of nums and loop until index is equal to length of array
    for(int i = 1; i < n; ++i) {
      // assign the max value between nums at index i and the currSum plus nums at index i
      // to the currSum variable
      currSum = Math.max(nums[i], currSum + nums[i]);
      // assign the maxSum variable the max value between maxSum and currSum
      maxSum = Math.max(maxSum, currSum);
    }
    // return the max value
    return maxSum;
  }
