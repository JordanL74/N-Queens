import processing.core.PApplet;
public class ChessBoardButton extends Button{
    public boolean isQueen, isSafe, isSolved;
    public int rowIndex, colIndex;
    public ChessBoardButton() {
        isQueen = false;
    }
    public ChessBoardButton(int xPos, int yPos, int wSize, int hSize) {
        super(xPos, yPos, wSize, hSize);
        isQueen = false;
    }
    public ChessBoardButton(int xPos, int yPos, int wSize, int hSize, int colIndex, int rowIndex) {
        super(xPos, yPos, wSize, hSize);
        this.colIndex = colIndex;
        this.rowIndex = rowIndex;
        isQueen = false;
    }
    // Displays this button on PApplet pa
    public void display(PApplet pa, char[][] board){
        if (pa.mousePressed && isOverButton(pa))
            pa.fill(255, 0, 0);
        else
            pa.fill(255);

        if ((rowIndex + colIndex) % 2 == 0)
            pa.fill(255, 255, 255);
        else
            pa.fill(75, 75, 75);

        if (!isSafe) {
            if ((rowIndex + colIndex) % 2 == 0)
                pa.fill(255, 255, 0);
            else
                pa.fill(200, 200, 0);
        }
        pa.rect(xPos - (wSize / 2), yPos - (hSize / 2), wSize, hSize);
        if (isQueen) {
            board[rowIndex][colIndex] = 'Q';
            if ((rowIndex + colIndex) % 2 == 0)
                pa.fill(0);
            else
                pa.fill(255);

            if (!isSafe)
                pa.fill(255, 0, 0);
            else {
                if ((rowIndex + colIndex) % 2 == 0)
                    pa.fill(0);
                else
                    pa.fill(255);
            }
            pa.textSize(hSize);
            if (isSolved) {
                pa.fill(0);
                pa.text("Solution Found!", 100, 750);
                pa.fill(0, 255, 0);
            }
            pa.text("Q",xPos - wSize / 3, yPos + hSize / 4);
        }
        if (!isQueen) {
            isSafe = false;
            board[rowIndex][colIndex] = '_';
        }
    }
}
