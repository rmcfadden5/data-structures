// 169 Majority Element
    public int majorityElement(int[] nums) {
      // A counter variable is intialized with zero
        int counter = 0;
      // A high counter variable is initialized with zero
        int hiCounter = 0;
      // A target variable is initialized with zero
        int target = 0;
      // If the length of the array is only 1 element long, return that element
        if(nums.length == 1) return nums[0];
        // Loop through the entire integer array
        // The outer loop starts at the first index and ends at the last
       for(int i = 0; i < nums.length; i++){
         // The extra counter variable is initialized along the way
           counter++;
         // The inner loop starts one index to the right of the outer loops
         // and runs to the end of the integer array
           for(int k = i+1; k < nums.length; k++){
             // If the values at the inner and outer loops match then increment the counter
               if(nums[i] == nums[k]) counter++;
               // If this counter is now greater than the high counter
               if(counter > hiCounter){
                 // Then make it the new high counter
                   hiCounter = counter;
                   // Remember to save the index when the high counter was found
                   target = nums[i];
               }

           }
           // reset the counter
           counter = 0;

       }
       // the target variable contains the index where the high counter was found
        return target;
    }
