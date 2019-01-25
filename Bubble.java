
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
/**
 * Write a description of class Bubble here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bubble
{
    // instance variables - replace the example below with your own
    private Color[] fillColor = {Color.BLUE, Color.RED};
    private Circle circle;

    /**
     * Constructor for objects of class Bubble
     */
    public Bubble(int x, int y, double radius)
    {
        this.circle = new Circle(x, y, radius);
    }

    public Circle getCircle()
    {
        return this.circle;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public Color getColor()
    {
        return (Color)this.circle.getFill();
    }

    public void setColor(Color fill)
    {
        // put your code here
        this.circle.setFill(fill);
    }

    public void setColor(int color)
    {
        // put your code here
        this.circle.setFill(fillColor[color]);
    }

}
