
import javafx.application.*;
import javafx.event.*;
import javafx.stage.*;
import javafx.scene.shape.*;
import javafx.embed.swing.*;
import javafx.application.*;
import javafx.scene.text.*;
import java.util.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

/**
 * Write a description of class BubbleWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BubbleWorld
{
    // instance variables - replace the example below with your own
    private Pane pane;
    private int GRID_SIZE = 30;
    private int TOTAL_COLS = 5;
    private int TOTAL_ROWS = 10;
    private Bubble [][] bubbleGrid;
    private static int RADIUS = 15;
    

    

    /**
     * Constructor for objects of class BubbleWorld
     */
    public BubbleWorld()
    {
        // initialise instance variables
        /*this.pane = new Pane();
        this.pane.setPrefSize(TOTAL_COLS * GRID_SIZE, (TOTAL_ROWS) * GRID_SIZE);
        Scene scene = new Scene(this.pane, Color.AZURE);*/
        bubbleGrid = new Bubble[TOTAL_ROWS][TOTAL_COLS];
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void drawBubble(int x, int y, Color fill)
    {
        // put your code here
        Bubble bubble = new Bubble(posOnPane(x), posOnPane(y), RADIUS);
        bubble.setColor(fill);
        //pane.getChildren().add(bubble.getCircle());
        bubbleGrid[gridPos(y)][gridPos(y)] = bubble;
    }

    public boolean hasBubble(int row, int col)
    {
        if(bubbleGrid[row][col] != null)
        {
            return true;
        }
        return false;
    }

    /**
     * posOnPane - replace this comment with your own
     *
     * @param  coord  the coordinate of the mouse click (the x or the y)
     * @return    the pane center coordinate (x or y)
     */
    public int posOnPane(int coord)
    {
        return ((gridPos(coord) + 1) * (int)RADIUS);
    }

    /**
     * gridPos - replace this comment with your own
     *
     * @param  coord  the coordinate of the mouse click (the x or the y)
     * @return    the matrix position (col or row number)
     */
    public int gridPos(int coord)
    {
        double rest = (double)coord % (double)RADIUS;

        if(rest < (double)RADIUS/2)
        {
            return (int)(((double)coord - rest)/RADIUS);
        }
        else
        {
            return (int)(((double)coord + (double)RADIUS - rest)/RADIUS);   
        }
    }


}
