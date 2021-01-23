// 3. Longest Substring Without Repeating Characters
    public int lengthOfLongestSubstring(String s) {
      // Initialize an integer n with the length of the string
        int n = s.length();
        // then create a new HashSet interfaced from a Set of Characters
        Set<Character> set = new HashSet<>();
        // Initialize three integers, one ans var, two pointers all with zero
        int ans = 0, i = 0, j = 0;
        // iterate through the string starting at the first position
        while (i < n && j < n) {
            // try to extend the range [i, j]
            // see if the HashSet contains a char equal to the one at strings index of j
            if (!set.contains(s.charAt(j))){
              // if it doesn't then add it to the HashSet
                set.add(s.charAt(j++));
                // now the ans var is equal to the max between itself and the difference between pointers
                ans = Math.max(ans, j - i);
            }
            else {
              // if it does then remove the character in the string at index i + 1 from the HashSet
                set.remove(s.charAt(i++));
            }
        }
        // the ans var now contains the longest repeating substring
        return ans;
    }
