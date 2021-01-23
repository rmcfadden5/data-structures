// 70 Climbing Stairs
public class Solution {
  // create a function for climbing stairs
    public int climbStairs(int n) {
      // create an integer array with a size equal to n + 1
        int memo[] = new int[n + 1];
        // return the base case of the climb_Stairs function
        return climb_Stairs(0, n, memo);
    }
    // Create a function for counting stair ways
    public int climb_Stairs(int i, int n, int memo[]) {
      // Check if the index is greater than the array length
        if (i > n) {
          // return zero if it is
            return 0;
        }
        // Check if the index is equal to the length
        if (i == n) {
          // if it is then the base case is achieved and return 1
            return 1;
        }
        // if the value at memo at i is greater than zero
        if (memo[i] > 0) {
          // return that value
            return memo[i];
        }
        // if none of those than the value at memo at i is equal to
        // the sum of climb stairs posibilities
        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
        // then return the value at memo at i
        return memo[i];
    }
}
