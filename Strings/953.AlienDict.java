// Verify Alien Dictionary
    public boolean isAlienSorted(String[] words, String order) {
      // create a new integer array with 26 elements
        int[] index = new int[26];
        // for each character of the string place it in the index array
        for (int i = 0; i < order.length(); ++i)
        // here the array is being populated with values
            index[order.charAt(i) - 'a'] = i;
            // then use a searching for loop to iterate through the words array
        search: for (int i = 0; i < words.length - 1; ++i) {
          // Then create two String variables
          // set one equal to the word at current index
          // and the other equal to the word at next index
            String word1 = words[i];
            String word2 = words[i+1];

            // Find the first difference word1[k] != word2[k].
            for (int k = 0; k < Math.min(word1.length(), word2.length()); ++k) {
              // if the words don't match
                if (word1.charAt(k) != word2.charAt(k)) {
                    // If they compare badly, it's not sorted.
                    if (index[word1.charAt(k) - 'a'] > index[word2.charAt(k) - 'a'])
                        return false;
                    continue search;
                }
            }

            // If we didn't find a first difference, the
            // words are like ("app", "apple").
            if (word1.length() > word2.length())
                return false;
        }

        return true;
    }
