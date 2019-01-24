
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
    private final int RADIUS = 15;
    private Color fillColor = Color.WHITE;
    private Circle circle;


    /**
     * Constructor for objects of class Bubble
     */
    public Bubble()
    {
        circle = new Circle(center.getX(), center.getY(), RADIUS);
        circle.setFill(fillColor);
    }

    public Bubble(int x, int y, Color fill)
    {
        this.setCenter(x, y);
        this.setColor(fill);
        circle = new Circle(center.getX(), center.getY(), RADIUS);
        circle.setFill(fillColor);
    }

    public Circle getBubble()
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
        // put your code here
        return this.fillColor;
    }

    public void setColor(Color fill)
    {
        // put your code here
        this.fillColor = fill;
    }

    public int pointOnGrid(int x)
    {
        int rest = x % RADIUS;

        
        if(rest < RADIUS/2)
        {
            return (x - rest);
        }
        else
        {
            return (x + RADIUS - rest);   
        }

    }
}
