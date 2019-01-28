import javafx.scene.paint.Paint;
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
    private Circle circle;


    /**
     * Constructor for objects of class Bubble
     */
    public Bubble(int x, int y, Color fill)
    {
        circle = new Circle(pointOnGrid(x), pointOnGrid(y), RADIUS);
        circle.setFill(fill);
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
    public Paint getColor()
    {
        // put your code here
        return this.circle.getFill();
    }

    public void setColor(Color fill)
    {
        // put your code here
        this.circle.setFill(fill);
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
