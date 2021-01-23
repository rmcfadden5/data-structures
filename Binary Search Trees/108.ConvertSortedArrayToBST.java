// sortedArrayToBST with Preorder Traversal
class Solution {
  // Declare an integer array called nums
  int[] nums;
  // this is not the main method it is a helper function for tree traversal
  public TreeNode treeHelper(int pLeft, int pRight) {
    // check if the left node of the tree is greater than the right node
    // if so then return null
    if (pLeft > pRight) return null;
    // always choose left middle node as a root
    int p = (pLeft + pRight) / 2;
    // preorder traversal: node -> left -> right
    TreeNode root = new TreeNode(nums[p]);
    // now assign the left node of root using a recursive call
    root.left = treeHelper(pLeft, p - 1);
    // now assign the right node of the root using a recursive call
    root.right = treeHelper(p + 1, pRight);
    // then return the root
    return root;
  }

// This is the main function
  public TreeNode sortedArrayToBST(int[] nums) {
    // the nums of the tree object is assigned the value of the nums parameter
    this.nums = nums;
    // begin the recursive dive traversing from 0 to the end of the array
    return treeHelper(0, nums.length - 1);
  }
}
