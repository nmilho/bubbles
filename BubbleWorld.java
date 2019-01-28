
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
    private int ROWS_TO_FILL = 5;
    private int ROWS_EMPTY = 5;
    private int TOTAL_ROWS = ROWS_EMPTY + ROWS_TO_FILL;
    private Bubble [][] bubbleGrid;
    

    

    /**
     * Constructor for objects of class BubbleWorld
     */
    public BubbleWorld()
    {
        // initialise instance variables
        this.pane = new Pane();
        this.pane.setPrefSize(TOTAL_COLS * GRID_SIZE, (TOTAL_ROWS) * GRID_SIZE);
        Scene scene = new Scene(this.pane, Color.AZURE);
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
        Bubble circle = new Bubble(x, y, fill);
        pane.getChildren().add(circle.getCircle());
        /*bubbleGrid[line][columns] = circle;
        pane.getChildren().add(bubbles[line][columns]);*/
    }

    public boolean hasBubble(int row, int col)
    {
        if(bubbleGrid[row][col] != null)
        {
            return true;
        }
        return false;
    }


}
