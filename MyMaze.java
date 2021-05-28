// Written by Peng Mong Thao and Alvin Tan
public class MyMaze {
    Cell[][] maze;

    public MyMaze(int rows, int cols) {
        maze = new Cell[rows][cols];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                maze[i][j] = new Cell();
            }
        }
    }

    /* TODO: Create a new maze using the algorithm found in the writeup. */
    public static MyMaze makeMaze(int rows, int cols) {
        MyMaze newMaze = new MyMaze(rows, cols);
        Stack1Gen newStack = new Stack1Gen();
        int row = 0;
        int column = 0;
        int[] arr = {row, column};
        newStack.push(arr);
        newMaze.maze[row][column].setVisited(true);
        while (newStack.isEmpty() == false) {
            int randomInt = 0;
            if (row == 0 && column == 0) {                                                // Case: top left corner
                randomInt = (int) (Math.random() * 2) + 1;                                // randomInt will either be 1 or 2
                if (newMaze.maze[row + 1][column].getVisited() == true && newMaze.maze[row][column + 1].getVisited() == true) {        // if every cell around current cell has already been visited
                    newStack.pop();
                    if (newStack.isEmpty() == false) {
                        arr = (int[]) newStack.pop();                                      // This line pops the top element off stack but we don't actually want to remove it.
                        newStack.push(arr);                                                // Hence, we have to push arr back onto stack here
                        row = arr[0];                                                      // row and column become the row and column of the int array that was just pushed onto stack
                        column = arr[1];
                    }
                } else {
                    if (randomInt == 1) {                                                  // if randomInt is 1, the maze will move to the right one
                        if (newMaze.maze[row][column + 1].getVisited() == false) {
                            newMaze.maze[row][column].setRight(false);
                            column++;
                            newMaze.maze[row][column].setVisited(true);
                            arr = new int[]{row, column};                                  // creates a new int array that holds the current row and column that the maze is on
                            newStack.push(arr);
                        }
                    }
                    if (randomInt == 2) {                                                  // if randomInt is 2, the maze will move down one spot
                        if (newMaze.maze[row + 1][column].getVisited() == false) {
                            newMaze.maze[row][column].setBottom(false);
                            row++;
                            newMaze.maze[row][column].setVisited(true);
                            arr = new int[]{row, column};
                            newStack.push(arr);
                        }
                    }
                }
            } else {
                if (row == 0 && column == cols - 1) {                                      // Case: top right corner
                    randomInt = (int) (Math.random() * 2) + 1;
                    if (newMaze.maze[row + 1][column].getVisited() == true && newMaze.maze[row][column - 1].getVisited() == true) {
                        newStack.pop();
                        if (newStack.isEmpty() == false) {
                            arr = (int[]) newStack.pop();
                            newStack.push(arr);
                            row = arr[0];
                            column = arr[1];
                        }
                    } else {
                        if (randomInt == 1) {                                               // when randomInt = 1, the maze moves left one spot
                            if (newMaze.maze[row][column - 1].getVisited() == false) {
                                newMaze.maze[row][column - 1].setRight(false);
                                column--;
                                newMaze.maze[row][column].setVisited(true);
                                arr = new int[]{row, column};
                                newStack.push(arr);
                            }
                        }
                        if (randomInt == 2) {
                            if (newMaze.maze[row + 1][column].getVisited() == false) {      // when randomInt = 2, the maze moves down one spot
                                newMaze.maze[row][column].setBottom(false);
                                row++;
                                newMaze.maze[row][column].setVisited(true);
                                arr = new int[]{row, column};
                                newStack.push(arr);
                            }
                        }
                    }
                } else {
                    if (row == rows - 1 && column == cols - 1) {                        // Case: bottom right corner
                        randomInt = (int) (Math.random() * 2) + 1;
                        if (newMaze.maze[row - 1][column].getVisited() == true && newMaze.maze[row][column - 1].getVisited() == true) {   // if every cell around current cell has already been visited
                            newStack.pop();
                            if (newStack.isEmpty() == false) {                 // this part, where there's no unvisited cell around, is the same for all the different cases
                                arr = (int[]) newStack.pop();
                                newStack.push(arr);
                                row = arr[0];
                                column = arr[1];
                            }
                        } else {
                            if (randomInt == 1) {                                           // when randomInt = 1, the maze moves up one spot
                                if (newMaze.maze[row - 1][column].getVisited() == false) {
                                    newMaze.maze[row - 1][column].setBottom(false);
                                    row--;
                                    newMaze.maze[row][column].setVisited(true);
                                    arr = new int[]{row, column};
                                    newStack.push(arr);
                                }
                            }
                            if (randomInt == 2) {                                           // when randomInt = 2, the maze moves left one spot
                                if (newMaze.maze[row][column - 1].getVisited() == false) {
                                    newMaze.maze[row][column - 1].setRight(false);
                                    column--;
                                    newMaze.maze[row][column].setVisited(true);
                                    arr = new int[]{row, column};
                                    newStack.push(arr);
                                }
                            }
                        }
                    } else {
                        if (row == rows - 1 && column == 0) {                               // Case: bottom left corner
                            randomInt = (int) (Math.random() * 2) + 1;
                            if (newMaze.maze[row - 1][column].getVisited() == true && newMaze.maze[row][column + 1].getVisited() == true) {     // no unvisited cells
                                newStack.pop();
                                if (newStack.isEmpty() == false) {
                                    arr = (int[]) newStack.pop();
                                    newStack.push(arr);
                                    row = arr[0];
                                    column = arr[1];
                                }
                            } else {
                                if (randomInt == 1) {                                           // when randomInt = 1, the maze moves up one spot
                                    if (newMaze.maze[row - 1][column].getVisited() == false) {
                                        newMaze.maze[row - 1][column].setBottom(false);
                                        row--;
                                        newMaze.maze[row][column].setVisited(true);
                                        arr = new int[]{row, column};
                                        newStack.push(arr);
                                    }
                                }
                                if (randomInt == 2) {                                           // when randomInt = 2, the maze moves right one spot
                                    if (newMaze.maze[row][column + 1].getVisited() == false) {
                                        newMaze.maze[row][column].setRight(false);
                                        column++;
                                        newMaze.maze[row][column].setVisited(true);
                                        arr = new int[]{row, column};
                                        newStack.push(arr);
                                    }
                                }
                            }
                        } else {
                            if ((row == 0 || row == rows - 1) && (column != 0 && column != cols - 1)) {           // Case: top and bottom boundary (not corners)
                                randomInt = (int) (Math.random() * 3) + 1;
                                if ((row == 0 && newMaze.maze[row][column + 1].getVisited() == true && newMaze.maze[row][column - 1].getVisited() == true
                                        && newMaze.maze[row + 1][column].getVisited() == true) || (row == rows - 1 && newMaze.maze[row][column - 1].getVisited() == true
                                        && newMaze.maze[row][column + 1].getVisited() == true && newMaze.maze[row - 1][column].getVisited() == true)) {
                                    newStack.pop();
                                    if (newStack.isEmpty() == false) {
                                        arr = (int[]) newStack.pop();
                                        newStack.push(arr);
                                        row = arr[0];
                                        column = arr[1];
                                    }
                                } else {
                                    if (randomInt == 1) {                                                   // if we're on the top boundary, when randomInt = 1, the maze will move down one spot
                                        if (row == 0) {
                                            if (newMaze.maze[row + 1][column].getVisited() == false) {
                                                newMaze.maze[row][column].setBottom(false);
                                                row++;
                                                newMaze.maze[row][column].setVisited(true);
                                                arr = new int[]{row, column};
                                                newStack.push(arr);
                                            }
                                        } else {                                                            // if we're on the bottom boundary, when randomInt = 1, the maze moves up one spot
                                            if (newMaze.maze[row - 1][column].getVisited() == false) {
                                                newMaze.maze[row - 1][column].setBottom(false);
                                                row--;
                                                newMaze.maze[row][column].setVisited(true);
                                                arr = new int[]{row, column};
                                                newStack.push(arr);
                                            }
                                        }
                                    }
                                    if (randomInt == 2) {                                                   // when randomInt = 2, the maze moves left one spot
                                        if (newMaze.maze[row][column - 1].getVisited() == false) {
                                            newMaze.maze[row][column - 1].setRight(false);
                                            column--;
                                            newMaze.maze[row][column].setVisited(true);
                                            arr = new int[]{row, column};
                                            newStack.push(arr);
                                        }
                                    }
                                    if (randomInt == 3) {                                                   // when randomInt = 3, the maze moves right one spot
                                        if (newMaze.maze[row][column + 1].getVisited() == false) {
                                            newMaze.maze[row][column].setRight(false);
                                            column++;
                                            newMaze.maze[row][column].setVisited(true);
                                            arr = new int[]{row, column};
                                            newStack.push(arr);
                                        }
                                    }
                                }
                            } else {
                                if ((column == 0 || column == cols - 1) && (row != 0 && row != rows - 1)) {         // Case: left and right boundary (not the corners)
                                    randomInt = (int) (Math.random() * 3) + 1;
                                    if ((column == 0 && newMaze.maze[row][column + 1].getVisited() == true && newMaze.maze[row + 1][column].getVisited() == true
                                            && newMaze.maze[row - 1][column].getVisited() == true) || (column == cols - 1 && newMaze.maze[row][column - 1].getVisited() == true
                                            && newMaze.maze[row + 1][column].getVisited() == true && newMaze.maze[row - 1][column].getVisited() == true)) {
                                        newStack.pop();
                                        if (newStack.isEmpty() == false) {
                                            arr = (int[]) newStack.pop();
                                            newStack.push(arr);
                                            row = arr[0];
                                            column = arr[1];
                                        }
                                    } else {
                                        if (randomInt == 1) {
                                            if (column == 0) {                                              // if we're on the left boundary, when randomInt = 1, the maze moves right one spot
                                                if (newMaze.maze[row][column + 1].getVisited() == false) {
                                                    newMaze.maze[row][column].setRight(false);
                                                    column++;
                                                    newMaze.maze[row][column].setVisited(true);
                                                    arr = new int[]{row, column};
                                                    newStack.push(arr);
                                                }
                                            } else {                                                        // if we're on the right boundary, when randomInt = 1, the maze moves left one spot
                                                if (newMaze.maze[row][column - 1].getVisited() == false) {
                                                    newMaze.maze[row][column - 1].setRight(false);
                                                    column--;
                                                    newMaze.maze[row][column].setVisited(true);
                                                    arr = new int[]{row, column};
                                                    newStack.push(arr);
                                                }
                                            }
                                        }
                                        if (randomInt == 2) {                                               // when randomInt = 2, the maze moves up one spot
                                            if (newMaze.maze[row - 1][column].getVisited() == false) {
                                                newMaze.maze[row - 1][column].setBottom(false);
                                                row--;
                                                newMaze.maze[row][column].setVisited(true);
                                                arr = new int[]{row, column};
                                                newStack.push(arr);
                                            }
                                        }
                                        if (randomInt == 3) {                                               // when randomInt = 3, the maze moves down one spot
                                            if (newMaze.maze[row + 1][column].getVisited() == false) {
                                                newMaze.maze[row][column].setBottom(false);
                                                row++;
                                                newMaze.maze[row][column].setVisited(true);
                                                arr = new int[]{row, column};
                                                newStack.push(arr);
                                            }
                                        }
                                    }
                                } else {
                                    if (column + 1 <= cols && row + 1 <= rows && row - 1 >= 0 && column - 1 >= 0) {                // Case: in the middle of the maze, not around any boundaries
                                        if (newMaze.maze[row][column + 1].getVisited() == true && newMaze.maze[row + 1][column].getVisited() == true
                                                && newMaze.maze[row][column - 1].getVisited() == true && newMaze.maze[row - 1][column].getVisited() == true) {
                                            newStack.pop();
                                            if (newStack.isEmpty() == false) {
                                                arr = (int[]) newStack.pop();
                                                newStack.push(arr);
                                                row = arr[0];
                                                column = arr[1];
                                            }
                                        } else {
                                            randomInt = (int) (Math.random() * 4) + 1;                             // generates random int from 1 to 4 (inclusive)
                                            if (randomInt == 1) {                                                  // when randomInt = 1, the maze moves up one spot if it's unvisited
                                                if (row - 1 >= 0) {
                                                    if (newMaze.maze[row - 1][column].getVisited() == false) {
                                                        newMaze.maze[row - 1][column].setBottom(false);
                                                        row--;
                                                        newMaze.maze[row][column].setVisited(true);
                                                        arr = new int[]{row, column};
                                                        newStack.push(arr);
                                                    }
                                                }
                                            }
                                            if (randomInt == 2) {                                                  // when randomInt = 2, the maze moves right one spot if it's unvisited
                                                if (column + 1 < cols) {
                                                    if (newMaze.maze[row][column + 1].getVisited() == false) {
                                                        newMaze.maze[row][column].setRight(false);
                                                        column++;
                                                        newMaze.maze[row][column].setVisited(true);
                                                        arr = new int[]{row, column};
                                                        newStack.push(arr);
                                                    }
                                                }
                                            }
                                            if (randomInt == 3) {                                                   // when randomInt = 3, the maze moves down one spot if it's unvisited
                                                if (row + 1 < rows) {
                                                    if (newMaze.maze[row + 1][column].getVisited() == false) {
                                                        newMaze.maze[row][column].setBottom(false);
                                                        row++;
                                                        newMaze.maze[row][column].setVisited(true);
                                                        arr = new int[]{row, column};
                                                        newStack.push(arr);
                                                    }
                                                }
                                            }
                                            if (randomInt == 4) {                                                   // when randomInt = 4, the maze moves left one spot if it's unvisited
                                                if (column - 1 >= 0) {
                                                    if (newMaze.maze[row][column - 1].getVisited() == false) {
                                                        newMaze.maze[row][column - 1].setRight(false);
                                                        column--;
                                                        newMaze.maze[row][column].setVisited(true);
                                                        arr = new int[]{row, column};
                                                        newStack.push(arr);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }                   // while loop bracket
        for (int i = 0; i < newMaze.maze.length; i++) {             // these two 'for loops' set every cell back to unvisited
            for (int j = 0; j < newMaze.maze[i].length; j++) {
                newMaze.maze[i][j].setVisited(false);
            }
        }
        return newMaze;
    }

    /* TODO: Print a representation of the maze to the terminal */
    public void printMaze(boolean path) {
        String finalString = "";
        int a = 0;                        // Need 'a' because each cell is three "|" tall, not just one so we can't use the "i" in the for loop to keep track of what row we in.
        if (path == true) {
            for (int i = 0; i <= maze.length * 2; i++) {        // we use maze.length * 2 so that each cell can be 3 "|" tall
                for (int j = 0; j < maze[0].length; j++) {
                    if (i == 0 || i == maze.length * 2) {       // creates the top and bottom boundaries
                        finalString += "|---";
                    } else {
                        if(j == 0 && i != 1){                   // puts a "|" to start every row off (other than the top and bottom boundary)
                            finalString += "|";
                        }
                        if(i % 2 == 1) {                        // if row is odd, it's the middle of the cell so that's where we'll test if the cell has a right wall or not
                            if (maze[a][j].getRight() == true && maze[a][j].getVisited() == true) {        // Case: the cell has a right wall and was visited
                                if (j == 0 && i == 1) {                                                    // the case for the entrance of the maze
                                    finalString += "  * |";
                                } else {
                                    if (j == maze[0].length - 1) {                                         // the case for the last cell in a row
                                        finalString += " * ";
                                    } else {                                                               // the case for every other cell in a row
                                        finalString += " * |";
                                    }
                                }
                            } else {
                                if (maze[a][j].getRight() == false && maze[a][j].getVisited() == true) {   // Case: the cell doesn't have a right wall but was visited
                                    if (j == 0 && i == 1) {                                                // the case for the entrance of the maze
                                        finalString += "  *  ";
                                    } else {
                                        if (j == maze[0].length - 1) {                                    // case of the last cell in the row
                                            finalString += " * ";
                                        } else {
                                            finalString += " *  ";                                        // the case for every other cell in a row
                                        }
                                    }
                                } else {
                                    if (maze[a][j].getRight() == true && maze[a][j].getVisited() == false) {     // Case: Cell has a right wall but was not visited
                                        if (j == 0 && i == 1) {                                           // the case for the entrance of the maze
                                            finalString += "    |";
                                        } else {
                                            if (j == maze[0].length - 1) {                                // case of the last cell in the row
                                                finalString += "   ";
                                            } else {
                                                finalString += "   |";                                    // the case for every other cell in a row
                                            }
                                        }
                                    } else {
                                        if(maze[a][j].getRight() == false && maze[a][j].getVisited() == false) {      // Case: Cell has no right wall and was not visited
                                            if (j == 0 && i == 1) {
                                                finalString += "     ";
                                            } else {
                                                if (j == maze[0].length - 1) {                            // case of the last cell in the row
                                                    finalString += "   ";
                                                } else {
                                                    finalString += "    ";                                // the case for every other cell in a row
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }else {                     // else if row is even, it's the bottom part of the cell and where we'll test if the cell has a bottom wall or not
                            if (maze[a][j].getBottom() == true) {
                                if(j == maze[0].length - 1){        // case of the last cell in the row with a bottom wall
                                    finalString += "---";
                                }else {
                                    finalString += "---|";          // every other case where there is a bottom wall
                                }
                            } else {
                                if(j == maze[0].length - 1){        // case of the last cell in the row without a bottom wall
                                    finalString += "   ";
                                }else {
                                    finalString += "   |";          // every other case where there isn't a wall
                                }
                            }
                        }
                    }
                    if(j == maze[0].length - 1 && i == maze.length * 2 - 1){       // this is the exit in the maze
                        finalString += "\n";
                    }else {
                        if (j == maze[0].length - 1) {                             // the "|" at the end of every row
                            finalString += "|\n";
                        }
                    }
                }
                if(i % 2 == 0 && i != 0 && i != maze.length * 2){                  // 'a' increments every two rows because that's where the middle of the cells are
                    a++;
                }
            }
        }else {
            if (path == false) {                                           // Everything below here is basically the same thing as above when path == true except that
                for (int i = 0; i <= maze.length * 2; i++) {               // there are no cases where we have to add asterisks
                    for (int j = 0; j < maze[0].length; j++) {
                        if (i == 0 || i == maze.length * 2) {
                            finalString += "|---";
                        } else {
                            if (j == 0 && i != 1) {
                                finalString += "|";
                            }
                            if (i % 2 == 1) {
                                if (maze[a][j].getRight() == true) {
                                    if (j == 0 && i == 1) {               // the case for the entrance of the maze
                                        finalString += "    |";
                                    } else {
                                        if (j == maze[0].length - 1) {
                                            finalString += "   ";         // case of the last cell in the row
                                        } else {
                                            finalString += "   |";        // every other case without a right wall
                                        }
                                    }
                                } else {                                // if the cell has no right wall
                                    if (j == 0 && i == 1) {
                                        finalString += "     ";
                                    } else {
                                        if (j == maze[0].length - 1) {  // case of the last cell in the row
                                            finalString += "   ";
                                        } else {
                                            finalString += "    ";      // every other case without a right wall
                                        }
                                    }
                                }
                            } else {                                     // else if row is even, it's the bottom part of the cell and where we'll test if the cell has a bottom wall or not
                                if (maze[a][j].getBottom() == true) {
                                    if (j == maze[0].length - 1) {        // case of the last cell in the row with a bottom wall
                                        finalString += "---";
                                    } else {
                                        finalString += "---|";          // every other case where there is a bottom wall
                                    }
                                } else {
                                    if (j == maze[0].length - 1) {        // case of the last cell in the row without a bottom wall
                                        finalString += "   ";
                                    } else {
                                        finalString += "   |";          // every other case where there isn't a wall
                                    }
                                }
                            }
                        }
                        if (j == maze[0].length - 1 && i == maze.length * 2 - 1) {       // this is the exit in the maze
                            finalString += "\n";
                        } else {
                            if (j == maze[0].length - 1) {                             // the "|" at the end of every row
                                finalString += "|\n";
                            }
                        }
                    }
                    if (i % 2 == 0 && i != 0 && i != maze.length * 2) {
                        a++;
                    }
                }
            }
        }
        System.out.println(finalString);
    }

    /* TODO: Solve the maze using the algorithm found in the writeup. */
    public void solveMaze() {
        Q1Gen newQueue = new Q1Gen();
        int row = 0;
        int column = 0;
        int[] arr = {row, column};
        newQueue.add(arr);
        while (newQueue.isEmpty() == false) {
            if (row == maze.length - 1 && column == maze[0].length - 1) {                                               // if the end was reached
                break;
            }
            if (row + 1 < maze.length) {
                if (maze[row + 1][column].getVisited() == false && maze[row][column].getBottom() == false) {            // if no wall and cell below is unvisited
                    row++;
                    arr = new int[]{row, column};
                    newQueue.add(arr);
                    row--;
                }
            }
            if (row - 1 >= 0) {
                if (maze[row - 1][column].getVisited() == false && maze[row - 1][column].getBottom() == false) {        // if no wall and cell above is unvisited
                    row--;
                    arr = new int[]{row, column};
                    newQueue.add(arr);
                    row++;
                }
            }
            if (column + 1 < maze[0].length) {
                if (maze[row][column + 1].getVisited() == false && maze[row][column].getRight() == false) {             // if no wall and cell to the right is unvisited
                    column++;
                    arr = new int[]{row, column};
                    newQueue.add(arr);
                    column--;
                }
            }
            if (column - 1 >= 0) {
                if (maze[row][column - 1].getVisited() == false && maze[row][column - 1].getRight() == false) {         // if no wall and cell to the left is unvisited
                    column--;
                    arr = new int[]{row, column};
                    newQueue.add(arr);
                    column++;
                }
            }
            arr = (int[]) newQueue.remove();
            row = arr[0];
            column = arr[1];
            maze[row][column].setVisited(true);
        }
        printMaze(true);
    }

    public static void main(String[] args){
        MyMaze thisMaze = new MyMaze(5,20);
        thisMaze = thisMaze.makeMaze(5,20);
        thisMaze.printMaze(true);
        thisMaze.solveMaze();

        MyMaze newMaze = new MyMaze(10,15);
        newMaze = newMaze.makeMaze(10,15);
        newMaze.printMaze(true);
        newMaze.solveMaze();

        MyMaze nextMaze = new MyMaze(7,8);             // this test to show that printMaze(true) and printMaze(false) work as intended
        nextMaze = nextMaze.makeMaze(7,8);
        nextMaze.printMaze(true);
        nextMaze.solveMaze();
        nextMaze.printMaze(false);
    }
}
