import processing.core.PApplet;
public class FunctionButton extends Button {
    public String text;
    public FunctionButton() {
    }
    public FunctionButton(int xPos, int yPos, int wSize, int hSize, String text) {
        super(xPos, yPos, wSize, hSize);
        this.text = text;
    }
    public void display(PApplet pa) {
        super.display(pa);
        pa.textSize((int)(hSize / 2));
        pa.fill(0);
        pa.text(text, xPos - (int)(wSize / 2),yPos + (int)(hSize / 4));
    }
}
