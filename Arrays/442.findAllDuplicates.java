// Find All Duplicates in an Array
    public List<Integer> findDuplicates(int[] nums) {
      // Create a new array list object
        ArrayList<Integer> dupeList = new ArrayList<Integer>();
        // iterate through the array
        for(int i = 0; i < nums.length; i++){
          // the inner loop starts one index to the right of the outer loop
          // and traverses to the end each time
            for(int j = i+1; j < nums.length; j++){
              // when the outer loop and inner loop indices are equal then add it to list
                if(nums[i] == nums[j]){
                  // a duplicate has been found place it in the list
                    dupeList.add(nums[j]);
                    // then break out of the loop
                    break;
                }
            }
        }
        // now the array list contains the duplicates
        return dupeList;
    }
