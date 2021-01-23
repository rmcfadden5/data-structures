// 200.Number of Islands
class Solution {
  // create a function for the depth first search
  void dfs(char[][] grid, int r, int c) {
    // initialize two integers
    // one with the grids length
    int nr = grid.length;
    // and the other with the length of the grids row
    int nc = grid[0].length;
    // check if any of the search bounds cases are met
    if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
      // if so then exit
      return;
    }
    // make the value at grid at r and c equal to zero
    grid[r][c] = '0';
    // then execute several different variations of the dfs search
    dfs(grid, r - 1, c);
    dfs(grid, r + 1, c);
    dfs(grid, r, c - 1);
    dfs(grid, r, c + 1);
  }
// create a number of Islands function that also takes a 2d char grid
  public int numIslands(char[][] grid) {
    // check if the grid is null or if the length is zero
    if (grid == null || grid.length == 0) {
      // if so then return zero
      return 0;
    }
// now initialize integers with
// the length of the grid
    int nr = grid.length;
    // the length of the grid row
    int nc = grid[0].length;
    // zero
    int num_islands = 0;
    // now iterate through the grid
    // the outer loop goes through the starting at one along the row
    for (int r = 0; r < nr; ++r) {
      // the inner loop goes through starting at one along the column
      for (int c = 0; c < nc; ++c) {
        // check if the value at the inner and outer loops is equal to one
        if (grid[r][c] == '1') {
          // now increment the number of islands variable
          ++num_islands;
          // now execute dfs function with the grid and indices
          dfs(grid, r, c);
        }
      }
    }
// num_islands now contains the number of islands
    return num_islands;
  }
}
