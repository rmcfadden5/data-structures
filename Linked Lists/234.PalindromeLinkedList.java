// 234 Palindrome Linked List
class Solution {
// Create the main function for the solution
    public boolean isPalindrome(ListNode head) {
      // check if the list is empty and if it is return true
        if (head == null) return true;
        // Find the end of first half and reverse second half.
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);
        // Check whether or not there is a palindrome.
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        // Set a boolean variable to true
        boolean result = true;
        // Iterate through the List starting at the secondHalfStart while result is true
        while (result && p2 != null) {
          // return a false result if the values at pointers p1 and p2 do not match
            if (p1.val != p2.val) result = false;
            // other set p1 to it's next pointer
            p1 = p1.next;
            // same goes for p2
            p2 = p2.next;
        }
        // Restore the list and return the result.
        firstHalfEnd.next = reverseList(secondHalfStart);
        // Return the result true or false
        return result;
    }
    // Now create a method that will return a reversedList head pointer
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
// Create a function that has two pointers one fast and one slow
    private ListNode endOfFirstHalf(ListNode head) {
      // the fast and slow pointers are both initialized with the head of the list
        ListNode fast = head;
        ListNode slow = head;
        // iterate through the list while fast's next several pointers don't both equal null
        while (fast.next != null && fast.next.next != null) {
          // for each iteration make fast equal to its next's next pointer
            fast = fast.next.next;
            // make slow node equal to its next pointer
            slow = slow.next;
        }
        // return the slow node
        return slow;
    }
}
