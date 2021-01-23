// 67 Add Binary
  public String addBinary(String a, String b) {
    // initialize an integer n equal to the string length
    // and an integer m equal to the other string's length
    int n = a.length(), m = b.length();
    // then check if the length of the n string is less than length of m
    // if it is then return add Binary function with b and a as parameters
    // basically switch the inputs
    if (n < m) return addBinary(b, a);
    // initialize an integer L with the max value between n and m
    int L = Math.max(n, m);
    // Now create a StringBuilder
    StringBuilder sb = new StringBuilder();
    // Now initialize two integers
    // one for the carry bit and one for the second index
    int carry = 0, j = m - 1;
    // the loop starts at L minus one and runs until index is zero
    for(int i = L - 1; i > -1; --i) {
      // check if character in a at i is equal to one
      // if it is then add one to carry
      if (a.charAt(i) == '1') ++carry;
      // check if j index is greater than -1 and character at j of b is one
      // then increment carry by one
      if (j > -1 && b.charAt(j--) == '1') ++carry;
      // now check if the carry modulated by two is one
      // if it is then append sb with one
      if (carry % 2 == 1) sb.append('1');
      // otherwise append sb with zero
      else sb.append('0');
      // at the end of the loop assign carry divided itself by 2
      carry /= 2;
    }
    // check if carry is one
    // if it is then append one to sb
    if (carry == 1) sb.append('1');
    // now reverse the string builder at the end
    sb.reverse();
    // return the string builder set to a string
    return sb.toString();
  }
}
