// 139. Word Break
    public boolean wordBreak(String s, List<String> wordDict) {
      // Create a new HashSet interfacing from a Set of Strings passed as wordDict
        Set<String> wordDictSet = new HashSet<>(wordDict);
        // Create an array of booleans of size equal to the length of the string plus one
        boolean[] dp = new boolean[s.length() + 1];
        // set the first index of the new boolean array equal to true
        dp[0] = true;
        // iterate through the length of the string starting at the second index
        // the outer loop starts at the second index and runs to end of the string
        for (int i = 1; i <= s.length(); i++) {
          // the inner loop starts at the first index and runs while less than the first index
            for (int j = 0; j < i; j++) {
              // check if the boolean value at the inner loop is true
              // and if it is contained in the Hash set in a substring from j to i
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                  // then set the value at the index of the outer loop equal to true
                    dp[i] = true;
                    // then break back to the outer loop
                    break;
                }
            }
        }
        // now the value at the index equal to the length of the string contains the wordBreak decision
        return dp[s.length()];
    }
