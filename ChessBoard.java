import processing.core.PApplet;
public class ChessBoard extends PApplet {
    // Boxes per row/col, Size in pixels, Start pos: 0,0 (top left)
    public int nCount, boardSize, xPos, yPos;
    public char[][] board; // 'Q' = Queen; '_' = Empty
    ChessBoardButton[][] chessBoard;

    public ChessBoard() {}
    public ChessBoard(int nCount, int boardSize) {
        xPos = 100;
        yPos = 100;
        this.nCount = nCount;
        this.boardSize = boardSize;
        int buttonSize = boardSize / nCount;
        chessBoard = new ChessBoardButton[nCount][nCount];
        for (int r = 0; r < nCount; r++) {
            for (int c = 0; c < nCount; c++) {
                chessBoard[c][r] = new ChessBoardButton(xPos + buttonSize * r,yPos + buttonSize * c, buttonSize, buttonSize, r, c);
            }
        }
        board = new char[nCount][nCount];
        reset();
        print();
    }
    public void display(PApplet pa) {
        for (int r = 0; r < nCount; r++) {
            for (int c = 0; c < nCount; c++) {
                chessBoard[r][c].isSafe = true;
                if (!isSafe(r, c)) {
                    chessBoard[r][c].isSafe = false;
                }
                if (legalQueenCounter() == nCount) {
                    chessBoard[r][c].isSolved = true;
                }
                else
                    chessBoard[r][c].isSolved = false;
            }
        }
        for (ChessBoardButton[] rank: chessBoard) {
            for (ChessBoardButton button: rank) {
                button.display(pa, board);
            }
        }
        print();
        System.out.println();
    }
    public int legalQueenCounter() {
        int legalQueenCounter = 0;
        for (int r = 0; r < nCount; r++) {
            for (int c = 0; c < nCount; c++) {
                if (board[r][c] == 'Q' && isSafe(r, c)) {
                    legalQueenCounter++;
                }
            }
        }
        return legalQueenCounter;
    }
    public void reset() {
        for (int r = 0; r < nCount; r++) {
            for (int c = 0; c < nCount; c++) {
                board[r][c] = '_';
                chessBoard[r][c].isQueen = false;
            }
        }
    }
    public void print() {
        for (int r = 0; r < nCount; r++) {
            for (int c = 0; c < nCount; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
    }
    public boolean isSafe(int row, int col){
        // Left
        for (int c = col - 1; c >= 0; c--){
            if(board[row][c] == 'Q'){
                return false;
            }
        }
        // Right
        for (int c = col + 1; c < nCount; c++){
            if(board[row][c] == 'Q'){
                return false;
            }
        }
        // Down
        for (int r = row + 1; r < nCount; r++){
            if(board[r][col] == 'Q') {
                return false;
            }
        }
        // Up
        for (int r = row - 1; r >= 0; r--){
            if(board[r][col] == 'Q') {
                return false;
            }
        }
        //UpLeft
        for(int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }
        //UpRight
        for(int r = row - 1, c = col + 1; r >= 0 && c < nCount; r--, c++){
            if(board[r][c] == 'Q'){
                return false;
            }
        }
        // downLeft
        for(int r = row + 1, c = col - 1; r < nCount && c >= 0; r++, c--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }
        // downRight
        for(int r = row + 1, c = col + 1; r < nCount && c < nCount; r++, c++){
            if(board[r][c] == 'Q'){
                return false;
            }
        }
        return true;
    }
}
