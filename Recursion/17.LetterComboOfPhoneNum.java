// 17. Letter Combinations of a Phone Number
class Solution {
  // Create a HashMap called phone that interfaces from a Map of Strings
  Map<String, String> phone = new HashMap<String, String>() {{
    // Populate the map with the keys and their character counterparts
    put("2", "abc");
    put("3", "def");
    put("4", "ghi");
    put("5", "jkl");
    put("6", "mno");
    put("7", "pqrs");
    put("8", "tuv");
    put("9", "wxyz");
  }};
// Create an ArrayList that interfaces from a List of Strings
  List<String> output = new ArrayList<String>();
// Create a function that will back track using a combination string and a next_digits string
  public void backtrack(String combination, String next_digits) {
    // if there is no more digits to check
    if (next_digits.length() == 0) {
      // the combination is done
      output.add(combination);
    }
    // if there are still digits to check
    else {
      // iterate over all letters which map
      // the next available digit
      String digit = next_digits.substring(0, 1);
      String letters = phone.get(digit);
      // Iterate through the letter string starting at the first index
      for (int i = 0; i < letters.length(); i++) {
        // create a string called letter that is equal to
        // the digit substring that is get from the phone HashMap
        String letter = phone.get(digit).substring(i, i + 1);
        // append the current letter to the combination
        // and proceed to the next digits
        backtrack(combination + letter, next_digits.substring(1));
      }
    }
  }
// create a function for returning letter combinations
  public List<String> letterCombinations(String digits) {
    // if the digits length is not zero
    if (digits.length() != 0)
    // then backtrack through the digits
      backtrack("", digits);
      // return output
    return output;
  }
}
