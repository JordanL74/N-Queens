public class Solver {
    public static char[][] board; // 'Q' = Queen; '_' = empty
    public static int size = 8; // 4 <= size
    public static int solutionCounter = 0;
    // Determines whether spot board[row, col] is safe from Queen Q
    public static boolean isSafe(int row, int col){
        // Horizontal
        for (int c = col; c >= 0; c-- ) {
            if(board[row][c] == 'Q')
                return false;
        }
        // Up Left
        for (int r = row, c = col; r >= 0 && c >= 0; r--, c--) {
            if(board[r][c] == 'Q')
                return false;
        }
        // Down Left
        for (int r = row, c = col; r < size && c >= 0; r++, c--) {
            if (board[r][c] == 'Q')
                return false;
        }
        return true;
    }
    public static boolean solveNQueens(char[][] board, int col) {
        // Base condition
        if (col >= size) {
            print();
            printSolution();
            System.out.println();
        }
        // Recursive callstack
        else {
            for (int r = 0; r < size; r++) {
                if (isSafe(r, col)) {
                    board[r][col] = 'Q';
                    if (solveNQueens(board, col + 1)) {
                        return true;
                    }
                    // Backtrack
                    board[r][col] = '_';
                }
            }
        }
        return false;
    }
    // Reset board to '_'
    public static void reset() {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                board[r][c] = '_';
            }
        }
    }
    // Print board
    public static void print() {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                System.out.print(board[r][c] + " ") ;
            }
            System.out.println();
        }
    }
    // Print the positions of solution
    public static void printSolution() {
        solutionCounter++;
        System.out.print("Solution " + solutionCounter + ": ");
        System.out.print("[ ");
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (board[c][r] == 'Q') {
                    System.out.print(c + 1 + " ");
                }
            }
        }
        System.out.println("]");
    }
    public static void main(String[] args) {
        board = new char[size][size];
        reset();
        solveNQueens(board, 0);
    }
}
