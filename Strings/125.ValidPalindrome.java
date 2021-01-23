// 125 Valid Palindrome
    public boolean isPalindrome(String s) {
        // first need to dress up the string in several ways
        // one is to make sure it is containing the right elements
        s = s.replaceAll("[^A-Za-z0-9]", "");
        // make them characters lower case
        s = s.toLowerCase();
        // make the integer k equal to the length of the string minus one
        int k = s.length() - 1;
        // iterate through the string halfway
        for(int i = 0; i < s.length()/2; i++){
          // if the character at the length index doesn't line up
          // with the character at the index
            if(s.charAt(k) != s.charAt(i)){
              // then return false
                return false;
            }
            // now decrement the second pointer
            k--;
        }
        // now return true if we haven't returned false
        return true;
    }
