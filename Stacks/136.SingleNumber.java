// 136 Single Number
    public int singleNumber(int[] nums) {
      // Create a stack of integers
        Stack<Integer> stk = new Stack<Integer>();
        // iterate through the length of the array from the first position
        for(int i = 0; i < nums.length; i++){
          // for each iteration push the value at the index of the array to the stack
            stk.push(nums[i]);
            // now iterate through an inner loop that goes from the start to the end
            for(int k = 0; k < nums.length; k++){
              // if the index of the inner doesn't match the outer
                if(k != i){
                  // then check if the value at nums[k] is equal to the peek on the stack
                if(nums[k] == stk.peek()){
                  // if so then pop the stack
                    stk.pop();
                    // and break back to the outer loop
                    break;
                }
                }
            }
            // check if the size of the stack is greater than zero
            // if so then return the value of nums at i
            if(stk.size() > 0) return nums[i];
        }
        // now the top of the stack is holding the Single Number
        return stk.peek();
    }
