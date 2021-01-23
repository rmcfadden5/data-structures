// Longest Common Prefix
public String longestCommonPrefix(String[] strs) {
  // If the array is empty then return an empty string
   if (strs.length == 0) return "";
   // Create a String variable called prefix and initialize it with the value
   // at the starting index of the array of strings
   String thePrefix = strs[0];
   // Then loop through the remaining elements in the array of strings
   for (int i = 1; i < strs.length; i++)
   // The while loops condition is met only when the index of the value
   // at the index of the array of strings is not equal to zero
       while (strs[i].indexOf(thePrefix) != 0) {
         // Now assign prefix a substring of prefix from 0 to the end of the string
           thePrefix = thePrefix.substring(0, thePrefix.length() - 1);
           // If there are no more values in prefix return an empty string
           if (thePrefix.isEmpty()) return "";
       }
       //prefix now contains the longest common prefix in the array of strings
   return thePrefix;
}
