// Invert Binary Tree
public TreeNode invertTree(TreeNode root) {
  // If the tree is empty then return null
    if (root == null) return null;
    // Create a Queue interfacing as a Linked List
    Queue<TreeNode> treeQueue = new LinkedList<TreeNode>();
    // Add the root of the tree to the queue
    treeQueue.add(root);
    // The conditional for the loop is if the loop is not empty
    while (!treeQueue.isEmpty()) {
      // Initialize a new tree node as the current variable
      // and give it the value of the front of the queue and then slice it from the queue
        TreeNode curr = treeQueue.poll();
        // Now Initialize another tree node variable with the left node of the current node
        TreeNode temp = curr.left;
        // Now set the left node of the current equal to the right node of the current
        curr.left = curr.right;
        // Now make the right node of the current equal to the temp variable
        curr.right = temp;
        // if the left node of the current isn't null then add it to the queue
        if (curr.left != null) treeQueue.add(curr.left);
        // if the right node of the current isn't null then add it to the queue
        if (curr.right != null) treeQueue.add(curr.right);
    }
    // return the root which is inverted from it's previous representation
    return root;
}
