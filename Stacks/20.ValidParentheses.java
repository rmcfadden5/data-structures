// java Stacks
class Solution {
    public boolean isValid(String s) {

        //test the string
        //iterations
        //could use a stack
        Stack<Character> stk = new Stack<Character>();
        char here = 'A';
        char there = 'B';
        for(int i = 0; i < s.length(); i++){
            //if its right facing then push else check if theres a match
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stk.push(s.charAt(i));
            }
            else{  // then its left facing and needs a match or its false so we need another if
                   // also need to check if it's empty if it is then return false
                if(stk.size() == 0) return false;
                here = stk.peek();
                if(here == '(') there = ')';
                else if(here == '{') there = '}';
                else there = ']';

                if(s.charAt(i) == there){ //
                    stk.pop(); // remove the one on top and don't add the one below
                }
                else{ // then there isn't a match on top but there still might be a match later
                    stk.push(s.charAt(i));
                }
            }
        }   // so at the end of the loop if the stack isn't empty there was something with no match
        if(stk.size() == 0){
            return true;
        }
        else return false;


    }
}
