// 207.Course Schedule
class Solution {
  // Declare a function to determine if a student can finish the Schedule
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    // course -> list of next courses
    HashMap<Integer, List<Integer>> courseDict = new HashMap<>();
    // build the graph first
    for (int[] relation : prerequisites) {
      // relation[0] depends on relation[1]
      if (courseDict.containsKey(relation[1])) {
        // use the get method and add method to add relation[0] to relation[1]
        courseDict.get(relation[1]).add(relation[0]);
      } else {
        // or Make a new LinkedList called nextCourses
        List<Integer> nextCourses = new LinkedList<>();
        // and add the relation[0] to the nextCourses list
        nextCourses.add(relation[0]);
        // then put the values from relation[1] to nextCourses into courseDict
        courseDict.put(relation[1], nextCourses);
      }
    }
    // then create a boolean array called checked with the size of numCourses
    boolean[] checked = new boolean[numCourses];
    // create another boolean array called path with a size of numCourses
    boolean[] path = new boolean[numCourses];
    // iterate through the courseDict using the isCyclic method
    // to return either a true or false
    for (int currCourse = 0; currCourse < numCourses; ++currCourse) {
      // if this is true
      if (this.isCyclic(currCourse, courseDict, checked, path))
      // then return false
        return false;
    }
    // if something hasn't already been returned then return false
    return true;
  }


  /*
   * postorder DFS check that no cycle would be formed starting from currCourse
   */
  protected boolean isCyclic(
  // create an Integer object, a HashMap of Integers, a List of Integers
  // and two Boolean Arrays
      Integer currCourse, HashMap<Integer, List<Integer>> courseDict,
      boolean[] checked, boolean[] path) {

    // bottom cases
    if (checked[currCourse])
      // this node has been checked, no cycle would be formed with this node.
      return false;
    if (path[currCourse])
      // come across a previously visited node, i.e. detect the cycle
      return true;

    // no following courses, no loop.
    if (!courseDict.containsKey(currCourse))
      return false;

    // before backtracking, mark the node in the path
    path[currCourse] = true;

    boolean ret = false;
    // postorder DFS, to visit all its children first.
    for (Integer child : courseDict.get(currCourse)) {
      ret = this.isCyclic(child, courseDict, checked, path);
      if (ret)
        break;
    }

    // after the visits of children, we come back to process the node itself
    // remove the node from the path
    path[currCourse] = false;

    // Now that we've visited the nodes in the downstream,
    // we complete the check of this node.
    checked[currCourse] = true;
    return ret;
  }
}
