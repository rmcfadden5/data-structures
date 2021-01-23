// Add Strings
    public String addStrings(String num1, String num2) {
      // First create the string builder
        StringBuilder mine = new StringBuilder();
        // now initialize three integers, one for a carry and two pointers
        int carry = 0;
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        // use one loop to iterate over two strings
        while (p1 >= 0 || p2 >= 0) {
          // Use the conditional operator to quickly find if the value is right
            int x1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
            // use the advanced java conditional on both strings
            int x2 = p2 >= 0 ? num2.charAt(p2) - '0' : 0;
            // set a new integer value equal to the strings and carry mod 10
            int value = (x1 + x2 + carry) % 10;
            // then update the carry variable
            carry = (x1 + x2 + carry) / 10;
            // append the StringBuilder with the value
            mine.append(value);
            //decrement each pointer
            p1--;
            //decrement the second pointer
            p2--;
        }
        // check if carry is empty or not
        if (carry != 0)
        // if not then append it to the StringBuilder
            mine.append(carry);
            // now return a reversed and stringified StringBuilder
        return mine.reverse().toString();
    }
