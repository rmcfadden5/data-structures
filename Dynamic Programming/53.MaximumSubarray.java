// 53 Maximum Subarray
class Solution {
  // Create a function that will be used by the helper function to find a sum
  public int crossSum(int[] nums, int left, int right, int p) {
    // if the left and right parameters passed have equal values
    // return the value of the nums array at the left index
    if (left == right) return nums[left];
    // Initialize a variable called leftSubsum with the value of the smallest integer possible
    int leftSubsum = Integer.MIN_VALUE;
    // Initialize a variable called currSum with zero
    int currSum = 0;
    // Iterate through nums array from the starting index of p
    // to the index which equals left - 1
    for(int i = p; i > left - 1; --i) {
      // add each value of nums to the currSum variable
      currSum += nums[i];
      // assign the leftSubsum equal to the max integer value between leftSubsum and currSum
      leftSubsum = Math.max(leftSubsum, currSum);
    }
// Initialize a variable called rightSubsum with the value of min integer
    int rightSubsum = Integer.MIN_VALUE;
    // make currSum zero
    currSum = 0;
    // iterate through nums again from starting index of p + 1
    // to the index with the value right + 1
    for(int i = p + 1; i < right + 1; ++i) {
      // add each value in nums to currSum
      currSum += nums[i];
      // assign the greatest between rightSubsum and currSum to rightSubsum
      rightSubsum = Math.max(rightSubsum, currSum);
    }
// Now return the sum of leftSubsum and rightSubsum
    return leftSubsum + rightSubsum;
  }
// Now create a helper function
  public int helper(int[] nums, int left, int right) {
    // if the values passed for left and right are equal return nums at left index value
    if (left == right) return nums[left];
// Initialize a variable called p with the sum of left and right divided by 2 (average)
    int p = (left + right) / 2;
// Initialize leftSum with a helper that takes nums, left, and p
    int leftSum = helper(nums, left, p);
    // Initialize rightSum with a helper that takes nums, p + 1, and right
    int rightSum = helper(nums, p + 1, right);
    // Initialize crossSum with the result of crossSum after it takes nums, left, right, and p
    int crossSum = crossSum(nums, left, right, p);
// then return (the max of (the max of leftSum and rightSum) and crossSum)
    return Math.max(Math.max(leftSum, rightSum), crossSum);
  }
// Declare the main function
  public int maxSubArray(int[] nums) {
    // start the recursive dive with helper taking nums, 0, and nums.length - 1
    return helper(nums, 0, nums.length - 1);
  }
}
