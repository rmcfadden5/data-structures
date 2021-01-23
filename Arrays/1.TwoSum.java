// Two Sum
public int[] twoSum(int[] nums, int target) {
  // Will have to use a nested for loop to traverse the loop
  //outer loop will start at the first index and traverse to the end of the array
    for (int i = 0; i < nums.length; i++) {
      //inner loop will start one index to the right of the outer loop and traverse to the end
        for (int j = i+1; j < nums.length; j++) {
          //the value at the index of the inner loop is compared to the
          //target minus the value at the index of the outer loop
            if (nums[j] == (target - nums[i])) {
              //if the condition is met then a new array is returned containing the values at i and j
                return new int[] { i, j };
            }
        }
    }
}
