/*
 * [490] The Maze
 *
 * https://leetcode.com/problems/the-maze/description/
 *
 * algorithms
 * Medium (43.41%)
 * Total Accepted:    12.2K
 * Total Submissions: 28.1K
 * Testcase Example:  '[[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]\n[0,4]\n[4,4]'
 *
 * There is a ball in a maze with empty spaces and walls. The ball can go
 * through empty spaces by rolling up, down, left or right, but it won't stop
 * rolling until hitting a wall. When the ball stops, it could choose the next
 * direction.
 * 
 * Given the ball's start position, the destination and the maze, determine
 * whether the ball could stop at the destination.
 * 
 * The maze is represented by a binary 2D array. 1 means the wall and 0 means
 * the empty space. You may assume that the borders of the maze are all walls.
 * The start and destination coordinates are represented by row and column
 * indexes.
 * 
 * 
 * Example 1
 * 
 * Input 1: a maze represented by a 2D array
 * 
 * 0 0 1 0 0
 * 0 0 0 0 0
 * 0 0 0 1 0
 * 1 1 0 1 1
 * 0 0 0 0 0
 * 
 * Input 2: start coordinate (rowStart, colStart) = (0, 4)
 * Input 3: destination coordinate (rowDest, colDest) = (4, 4)
 * 
 * Output: true
 * Explanation: One possible way is : left -> down -> left -> down -> right ->
 * down -> right.
 * 
 * 
 * 
 * 
 * 
 * Example 2
 * 
 * Input 1: a maze represented by a 2D array
 * 
 * 0 0 1 0 0
 * 0 0 0 0 0
 * 0 0 0 1 0
 * 1 1 0 1 1
 * 0 0 0 0 0
 * 
 * Input 2: start coordinate (rowStart, colStart) = (0, 4)
 * Input 3: destination coordinate (rowDest, colDest) = (3, 2)
 * 
 * Output: false
 * Explanation: There is no way for the ball to stop at the destination.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * There is only one ball and one destination in the maze.
 * Both the ball and the destination exist on an empty space, and they will not
 * be at the same position initially.
 * The given maze does not contain border (like the red rectangle in the
 * example pictures), but you could assume the border of the maze are all
 * walls.
 * The maze contains at least 2 empty spaces, and both the width and height of
 * the maze won't exceed 100.
 * 
 * 
 */
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) return false;
        return check(maze, start, destination, new boolean[maze.length][maze[0].length]);
    }

    public boolean check(int[][] maze, int[] start, int[] dest, boolean[][] visited) {
        if (visited[start[0]][start[1]]) return false;
        if (Arrays.equals(start, dest)) return true;
        visited[start[0]][start[1]] = true;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int[] d : dirs) {
            int x = start[0];
            int y = start[1];
            while (validPos(maze, x + d[0], y + d[1]) && maze[x + d[0]][y + d[1]] != 1) {
                x += d[0];
                y += d[1];
            }
            if (check(maze, new int[]{x, y}, dest, visited)) return true;
        }
        return false;
    }

    public boolean validPos(int[][] maze, int x, int y) {
        return (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length);
    }
}
