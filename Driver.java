import processing.core.PApplet;
public class Driver extends PApplet {
    public int nCount = 8, boardSize = 600;
    ChessBoard chessBoard;
    FunctionButton clearButton, incrButton, decrButton;
    public void settings() {
        size(1000, 800);
        chessBoard = new ChessBoard(8, boardSize);
        clearButton = new FunctionButton(900, 100, 150, 75, "Clear");
        incrButton = new FunctionButton(900, 200, 150, 75, "Increase");
        decrButton = new FunctionButton(900, 300, 150, 75, "Decrease");
    }
    public void draw() {
        background(150);
        fill(255);
        textSize(50);
        text("Fit N-Queens on an NxN Board to Win", 0, 50);
        chessBoard.display(this);
        clearButton.display(this);
        incrButton.display(this);
        decrButton.display(this);
    }
    public void mouseReleased() {
        for (ChessBoardButton[] rank: chessBoard.chessBoard) {
            for (ChessBoardButton button : rank) {
                if (button.isOverButton(this)) {
                    button.isQueen = !button.isQueen;
                }
            }
        }
        if (clearButton.isOverButton(this))
            chessBoard.reset();
        if (incrButton.isOverButton(this))
            chessBoard = new ChessBoard(++nCount, boardSize);
        if (decrButton.isOverButton(this) && nCount > 4)
            chessBoard = new ChessBoard(--nCount, boardSize);
    }
    public static void main(String[] args) {
        PApplet.main("Driver", args);
    }
}
