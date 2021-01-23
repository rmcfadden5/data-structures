// 200.NumberOfIslands
  public int numIslands(char[][] grid) {
    // check if the 2d character grid is null or if the grid is empty
    if (grid == null || grid.length == 0) {
      // if so then return 0
      return 0;
    }
    // initialize integers for grid length, grid[0] length,
    // and num_islands equal to zero
    int nr = grid.length;
    int nc = grid[0].length;
    int num_islands = 0;
    // iterate through the 2d character array
    // the outer loop starts at the first position and increments
    // while the index is less than the length of the grid
    for (int r = 0; r < nr; ++r) {
      // the inner loop starts at the first position
      // and loops while the index is less than the length of the grid row's length
      for (int c = 0; c < nc; ++c) {
        // check if the value at the intersection of r and c is equal to one
        if (grid[r][c] == '1') {
          // if so then increment the number of the islands
          ++num_islands;
          grid[r][c] = '0'; // mark as visited
          // Create a Linked List that interfaces as a Queue of Integers
          Queue<Integer> neighbors = new LinkedList<>();
          // then add the value of the outer loop index times the length of the grid row + inner loop index
          neighbors.add(r * nc + c);
          // then go into a while loop with the condition while the neighbors list is not empty
          while (!neighbors.isEmpty()) {
            // now initialize three integers one with the first element removed from neighbors
            int id = neighbors.remove();
            // the result of id / nc
            int row = id / nc;
            // and the result of id modulated nc
            int col = id % nc;
            // Now check if the row minus one is greater than or equal zero
            // and also if the value at the intersection of grid at row minus one and columns
            // equal to one
            if (row - 1 >= 0 && grid[row-1][col] == '1') {
              // then add the value of row minus one times nc plus col
              neighbors.add((row-1) * nc + col);
              // then assign the intersection of grid at row minus one and col
              grid[row-1][col] = '0';
            }
            // then check if row plus one is less than nr and
            // if grid intersection row plus one and col equals one
            if (row + 1 < nr && grid[row+1][col] == '1') {
              // then add value row plus one time nc plus col to neighbors
              neighbors.add((row+1) * nc + col);
              // then grid intersection at row plus one and col equals zeo
              grid[row+1][col] = '0';
            }
            // now check if col minus one is greater than or equal to zero
            // and check if grid intersection row and col minus one equals one
            if (col - 1 >= 0 && grid[row][col-1] == '1') {
              // now add the value or row times nc plus col minus one
              neighbors.add(row * nc + col-1);
              // now grid intersection at row and col minus one equal to zero
              grid[row][col-1] = '0';
            }
            // now check if col plus one is less than nc
            // and if the grid intersection row and col plus one is equal to one
            if (col + 1 < nc && grid[row][col+1] == '1') {
              // now add value of row times nc plus col plus one
              neighbors.add(row * nc + col+1);
              // now grid intersection at row and col plus one equals zero
              grid[row][col+1] = '0';
            }
          }
        }
      }
    }
// now the variable num_islands will hold the number of islands
    return num_islands;
  }
