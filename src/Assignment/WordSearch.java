package Assignment;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {
    static final char[][] GRID = {
            {'C', 'A', 'T', 'S'},
            {'O', 'R', 'E', 'A'},
            {'D', 'E', 'A', 'M'},
            {'E', 'L', 'L', 'S'}
    };

    // 8 directions: up-left, up, up-right, left, right, down-left, down, down-right
    static final int[] DR = {-1, -1, -1, 0, 0, 1, 1, 1};
    static final int[] DC = {-1, 0, 1, -1, 1, -1, 0, 1};

    static int callCount = 0;

    // ---------- (a) Decision version: can the word be formed? ----------
    static boolean exists(char[][] grid, String word) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];   // state
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (search(grid, word, 0, r, c, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean search(char[][] grid, String word, int index, int r, int c, boolean[][] visited) {
        callCount++;
        // Constraints: inside grid, not used, letter matches
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) return false;
        if (visited[r][c] || grid[r][c] != word.charAt(index)) return false;

        // Goal: last letter matched
        if (index == word.length() - 1) return true;

        visited[r][c] = true;                         // make the choice
        for (int d = 0; d < 8; d++) {                 // choices: 8 neighbours
            if (search(grid, word, index + 1, r + DR[d], c + DC[d], visited)) {
                return true;
            }
        }
        visited[r][c] = false;                        // undo the choice (backtrack)
        return false;
    }

    // ---------- (c) Traced version: prints choices and backtracking ----------
    static boolean searchTraced(char[][] grid, String word, int index, int r, int c,
                                boolean[][] visited, int depth) {
        String indent = "  ".repeat(depth);
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) return false;
        if (visited[r][c]) return false;
        if (grid[r][c] != word.charAt(index)) {
            System.out.println(indent + "x (" + r + "," + c + ") '" + grid[r][c] + "' != '"
                    + word.charAt(index) + "'  -> pruned");
            return false;
        }
        System.out.println(indent + "CHOOSE (" + r + "," + c + ") '" + grid[r][c] + "'  [matched "
                + (index + 1) + "/" + word.length() + "]");
        if (index == word.length() - 1) {
            System.out.println(indent + "GOAL reached");
            return true;
        }
        visited[r][c] = true;
        for (int d = 0; d < 8; d++) {
            if (searchTraced(grid, word, index + 1, r + DR[d], c + DC[d], visited, depth + 1)) {
                return true;
            }
        }
        visited[r][c] = false;
        System.out.println(indent + "BACKTRACK from (" + r + "," + c + ") '" + grid[r][c] + "' (unmark)");
        return false;
    }

    // ---------- (e) All paths: do not stop at the first match ----------
    static void findAll(char[][] grid, String word, int index, int r, int c, boolean[][] visited,
                        List<int[]> path, List<List<int[]>> results) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) return;
        if (visited[r][c] || grid[r][c] != word.charAt(index)) return;

        visited[r][c] = true;
        path.add(new int[]{r, c});
        if (index == word.length() - 1) {
            results.add(new ArrayList<>(path));       // save a copy of the path
        } else {
            for (int d = 0; d < 8; d++) {
                findAll(grid, word, index + 1, r + DR[d], c + DC[d], visited, path, results);
            }
        }
        path.remove(path.size() - 1);                 // undo
        visited[r][c] = false;
    }

    public static void main(String[] args) {
        String word = "DREAM";
        System.out.println("Can \"" + word + "\" be formed? " + exists(GRID, word));
        System.out.println("Recursive calls made: " + callCount);

        System.out.println("\n=== (c) Trace (starting at every 'D') ===");
        boolean[][] visited = new boolean[4][4];
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                if (GRID[r][c] == word.charAt(0)) {
                    searchTraced(GRID, word, 0, r, c, visited, 0);
                }
            }
        }

        System.out.println("\n=== (e) All possible paths ===");
        List<List<int[]>> results = new ArrayList<>();
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                findAll(GRID, word, 0, r, c, new boolean[4][4], new ArrayList<>(), results);
            }
        }
        System.out.println("Number of ways = " + results.size());
        for (List<int[]> path : results) {
            StringBuilder sb = new StringBuilder();
            for (int[] cell : path) {
                sb.append("(").append(cell[0]).append(",").append(cell[1]).append(") ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}
