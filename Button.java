import processing.core.PApplet;
public class Button {
    public int wSize, hSize, xPos, yPos;
    public Button() {}
    public Button(int xPos, int yPos, int wSize, int hSize) {
        this.wSize = wSize;
        this.hSize = hSize;
        this.xPos = xPos;
        this.yPos = yPos;
    }
    // Displays this button on PApplet pa
    public void display(PApplet pa) {
        if (pa.mousePressed && isOverButton(pa))
            pa.fill(255,0,0);
        else
            pa.fill(255, 255, 255);
        pa.rect(xPos - (int)(wSize / 2), yPos - (int)(hSize / 2), wSize, hSize);
    }
    // The mouse position is mouseX and mouseY (ala Processing);
    // returns the coordinates of the mouse on the Processing screen
    public boolean isOverButton(PApplet pa) {
        return pa.mouseX >= xPos - wSize / 2 && pa.mouseX <= xPos + wSize / 2 &&
                pa.mouseY >= yPos - hSize / 2 && pa.mouseY <= yPos + hSize / 2;
    }
}
