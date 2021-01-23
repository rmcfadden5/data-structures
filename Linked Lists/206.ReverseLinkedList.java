// 206. Reverse Linked List
public ListNode reverseList(ListNode head) {
  // Create two ListNode pointers, one for previous, and one for current
  // Initialize the previous pointer to null
  // and the current pointer to head
    ListNode prev = null;
    ListNode curr = head;
    // iterate through the list while the current node is not null (at the end)
    while (curr != null) {
      // Create a ListNode pointer named nextTemp to hold current node's next pointer
        ListNode nextTemp = curr.next;
        // Now change the current node's next pointer to be equal to the previous node
        // In other words save the previous node's value in the current nodes next pointer
        curr.next = prev;
        // Now it is fine to overwrite the prvious node with the current node
        // which will also store the current node in the previous node
        prev = curr;
        // then assign the current node equal to the NextTemp node
        curr = nextTemp;
    }
    // at the end return the new head reference for the linked list
    return prev;
}
