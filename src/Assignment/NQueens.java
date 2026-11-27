package Assignment;

import java.math.BigInteger;

public class NQueens {
    static int nodes = 0;          // number of valid placements explored

    // ---------- (a) Search space sizes for 8x8 ----------
    static BigInteger choose(int n, int k) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= k; i++) {
            result = result.multiply(BigInteger.valueOf(n - k + i)).divide(BigInteger.valueOf(i));
        }
        return result;
    }

    // ---------- (b) Optimized solver ----------
    // board[row] = column of the queen in that row (1D array)
    // cols[c], diag1[r + c], diag2[r - c + n - 1] are true when occupied
    static boolean solve(int row, int n, int[] board, boolean[] cols, boolean[] diag1, boolean[] diag2,
                         boolean[][] forbidden, boolean stopAtFirst, int[] count, boolean trace) {
        if (row == n) {
            count[0]++;
            return stopAtFirst;            // true stops the whole search
        }
        for (int c = 0; c < n; c++) {
            if (forbidden != null && forbidden[row][c]) continue;
            if (cols[c] || diag1[row + c] || diag2[row - c + n - 1]) {
                if (trace) {
                    System.out.println("  ".repeat(row) + "row " + row + ", col " + c + " attacked -> skip");
                }
                continue;
            }
            // choose
            board[row] = c;
            cols[c] = diag1[row + c] = diag2[row - c + n - 1] = true;
            nodes++;
            if (trace) {
                System.out.println("  ".repeat(row) + "PLACE row " + row + ", col " + c + "   board="
                        + show(board, row + 1) + "  cols=" + flags(cols) + " d1=" + flags(diag1)
                        + " d2=" + flags(diag2));
            }
            if (solve(row + 1, n, board, cols, diag1, diag2, forbidden, stopAtFirst, count, trace)) {
                return true;
            }
            // un-choose (backtrack)
            cols[c] = diag1[row + c] = diag2[row - c + n - 1] = false;
            if (trace) {
                System.out.println("  ".repeat(row) + "BACKTRACK: remove queen from row " + row + ", col " + c);
            }
        }
        return false;
    }

    static String show(int[] board, int filled) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < board.length; i++) {
            sb.append(i < filled ? String.valueOf(board[i]) : "-");
            if (i < board.length - 1) sb.append(",");
        }
        return sb.append("]").toString();
    }

    static String flags(boolean[] a) {
        StringBuilder sb = new StringBuilder();
        for (boolean b : a) sb.append(b ? '1' : '0');
        return sb.toString();
    }

    static void printBoard(int[] board, boolean[][] forbidden) {
        int n = board.length;
        for (int r = 0; r < n; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < n; c++) {
                if (board[r] == c) sb.append("Q ");
                else if (forbidden != null && forbidden[r][c]) sb.append("X ");
                else sb.append(". ");
            }
            System.out.println(sb);
        }
    }

    static int[] run(int n, boolean[][] forbidden, boolean stopAtFirst, int[] count, boolean trace) {
        nodes = 0;
        int[] board = new int[n];
        solve(0, n, board, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1],
                forbidden, stopAtFirst, count, trace);
        return board;
    }

    public static void main(String[] args) {
        System.out.println("=== (a) 8x8 search space ===");
        System.out.println("Brute force, C(64,8)     = " + choose(64, 8));
        System.out.println("One queen per row, 8^8   = " + (long) Math.pow(8, 8));
        System.out.println("Row + column unique, 8!  = " + 40320);
        int[] count = new int[1];
        run(8, null, false, count, false);
        System.out.println("Backtracking placements explored (all solutions) = " + nodes);
        System.out.println("Number of solutions for 8-Queens = " + count[0]);
        count[0] = 0;
        run(8, null, true, count, false);
        System.out.println("Placements explored until the FIRST solution   = " + nodes);

        System.out.println("\n=== (c) Trace for N = 4 (stops at the first solution) ===");
        count[0] = 0;
        int[] board = run(4, null, true, count, true);
        System.out.println("\nFirst solution (column of the queen in each row): " + show(board, 4));
        printBoard(board, null);

        System.out.println("\n=== (e) N = 6 with forbidden squares (X) ===");
        boolean[][] forbidden = new boolean[6][6];
        forbidden[0][1] = true;
        forbidden[1][3] = true;
        forbidden[2][5] = true;
        count[0] = 0;
        board = run(6, forbidden, false, count, false);
        System.out.println("Solutions with forbidden squares = " + count[0] + " (without: 4)");
        count[0] = 0;
        board = run(6, forbidden, true, count, false);
        if (count[0] > 0) {
            printBoard(board, forbidden);
        }
    }
}
