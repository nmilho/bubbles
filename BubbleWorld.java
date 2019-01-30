
import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.shape.*;
import javafx.embed.swing.*;
import javafx.application.*;
import javafx.scene.text.*;
import java.util.*;
import javafx.scene.paint.Color;

/** 
 * Grid of Rectangle objects
 * @author 
 * @version 2018-12-14
 */
public class BubbleWorld { 

    private Bubble [][] bubbles;

    private int X_GRID = 15;
    private int Y_GRID = 15;
    private static final int RADIUS = 15;
    private int totalLines = 6;
    private static final int GRID_STEP = 30;

    private String[] matchesArr = new String[0];

    private Bubble nextBubble;

    public static final Color[] bubbleColors = {Color.YELLOW, Color.GREEN, Color.RED,
            Color.BLUE, Color.GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK};

    private static int numberColors = AskColors.numberColors();

    private int [] randomColors = randomColors(numberColors);// agora o programa guarda o array com os numeros das cores cá em cima para ficar acessivel

    /**
     * Create grid of objects and add to pane
     * Grid has two empty rows at the bottom (higher y)
     * All squares are stored in a 2D array named squareGrid
     * @param pane where objects are drawn
     * @param nLines total number of lines (two are left empty)
     * @param nColumns total number of columns
     */
    public BubbleWorld(Pane pane, int nLines, int nColumns) //int [] randomColors) //Bubble [][] bubbles)
    {
        totalLines += nLines;
        bubbles = new Bubble[totalLines][nColumns];
        int variableTest = X_GRID;

        for (int line = 0; line < nLines; line++)
        {
            X_GRID = variableTest;
            for(int columns = 0; columns < nColumns; columns++)
            {
                drawBubble(pane, X_GRID, Y_GRID, getRandomColor(), RADIUS, line, columns);
                X_GRID += 30;
            }
            Y_GRID += 30;
        }
    }

    public Color getRandomColor()
    {
        int number = (int)(0 + ((randomColors.length -1) - 0 +1) * Math.random());
        return bubbleColors[randomColors[number]];
    }
    

    public void removeBubb (double x, double y, Pane pane)
    {
            int line = getLine(y);
            int column = getColumn(x);
            pane.getChildren().remove(bubbles[line][column]);          
            bubbles[line][column] = null;
    }
    
    

    /**
     * add object at x, y and in the array at line, col
     * @param line line to add the object
     * @param col column to add the object   Color [] bubbleColors, int [] randomColors
     */
    public void drawBubble(Pane pane, int x, int y, Color fill, int RADIUS, int line, int columns)
    { 
        Bubble circle = new Bubble(x, y, RADIUS, fill);
        bubbles[line][columns] = circle;
        pane.getChildren().add(bubbles[line][columns].getCircle());
    }

    /**
     * get square at position (x, y)
     * @param x x coordinate for object
     * @param y y coordinate for object
     * @return the square (rectangle object) at point (x, y)
     * or null if outside limits 
     * 
     * insideBoard(x, y)
     */
    public Bubble circleInPoint(double x, double y)
    {
        if (x >= 0 && x <= 15 + (30 * (bubbles[0].length - 1)) && y >= 0 && y <= 400)
        {
            int line = getLine(y);
            int columns  = getColumn(x);
            return bubbles[line][columns];
        }
        else 
        {
            return null;
        }
    }

    /**
     * @return the bubbles array line number given an y coordinate
     */
    public int getLine(double y)
    {
        return (int)(y - RADIUS) / GRID_STEP;
    }

    /**
     * @return the bubbles array column number given an x coordinate
     */
    public int getColumn(double x)
    {
        return (int)(x - RADIUS) / GRID_STEP;
    }

    public int getCenterX(double x)
    {
        return RADIUS + (getColumn(x) * GRID_STEP);
    }

    public int getCenterY(double y)
    {
        return RADIUS + (getLine(y) * GRID_STEP);
    }

    /**
     * add new square based on mouse coordinates
     * @param mx mouse x coordinate
     * @param my mouse y coordinate for object
     */
    public Color AddAndDrawNewBubble(Pane pane, double mx, double my, Color fill)//, int [] randomColors)
    {
        int line = getLine(my);
        int columns  = getColumn(mx);
        int x_for_new_bubble = getCenterX(mx);
        int y_for_new_bubble = getCenterY(my);
        
        if (0 <= line && line < bubbles.length &&  0 <= columns && columns < bubbles[0].length && 
        0 <= columns && columns < bubbles[0].length &&
        bubbles[line][columns] == null && bubbles[line - 1][columns] != null) // check if position is empty
        {
            drawBubble(pane, x_for_new_bubble, y_for_new_bubble, fill, RADIUS, line, columns);
        }
        else if (0 <= line && line < bubbles.length &&  0 <= columns && columns < bubbles[0].length && 
        0 <= columns && columns < bubbles[0].length &&
        bubbles[line][columns] == null && bubbles[line][columns + 1] != null) // mete à direita
        {
            drawBubble(pane, x_for_new_bubble, y_for_new_bubble, fill, RADIUS, line, columns);
        }
        else if (0 <= line && line < bubbles.length &&  0 <= columns && columns < bubbles[0].length && 
        0 <= columns && columns < bubbles[0].length &&
        bubbles[line][columns] == null && bubbles[line][columns - 1] != null) // mete à esquerda
        {
            drawBubble(pane, x_for_new_bubble, y_for_new_bubble, fill, RADIUS, line, columns);
        }
        return fill;
    }


    /*
        Devolve o array de cores;
    */
    private int [] randomColors (int numberColors)
    {
        int [] randomColors = new int [numberColors];
        int carry = 0;
        for (int i = 0; i < randomColors.length; )
        {
            int color = (int)(0 + (7 - 0 + 1) * Math.random()); 
            for(int k = 0; k < numberColors - 1; k++)
            {
                carry = 1;
                if (color == randomColors[k])
                {
                    carry = 0;
                    break;
                }
            }
            if(carry == 1)
            {
                randomColors[i] = color;
                i++;
            }
        }
        return randomColors;
    }


    public void removeMatches(Pane pane)
    {
        if(matchesArr.length > 2)
        {
            for(int i = 0; i < matchesArr.length; i++)
            {
                String[] coords = matchesArr[i].split(",");
                int row = Integer.parseInt(coords[0]);
                int col = Integer.parseInt(coords[1]);
                pane.getChildren().remove(bubbles[row][col].getCircle());
                bubbles[row][col] = null;
            }
        }
        matchesArr = new String[0];
    }

    
    public void findMatches(int row, int col, Color color, int lines, int columns) 
    {    
        if(contains(matchesArr, row + "," + col))
        {
            return;
        }
        else
        {
            matchesArr = add(matchesArr, row + "," + col);
        }

        //linha abaixo
        if(row + 1 < lines + 6 && bubbles[row + 1][col] != null)
        {
            Color tmp = bubbles[row + 1][col].getColor();
            if(color.equals(tmp))
                findMatches(row + 1, col, color, lines, columns);
        }

        //coluna à direita
        if(col + 1 < columns && bubbles[row][col + 1] != null)
        {
            if(color.equals(bubbles[row][col + 1].getColor()))
                findMatches(row, col + 1, color, lines, columns);
        }

        //linha acima
        if(row > 0 && bubbles[row - 1][col] != null)
        {
            if(color.equals(bubbles[row - 1][col].getColor()))
                findMatches(row - 1, col, color, lines, columns);
        }

        //coluna à esquerda
         if(col > 0 && bubbles[row][col - 1] != null)
        {
            if(color.equals(bubbles[row][col - 1].getColor()))
                findMatches(row, col - 1, color, lines, columns);
        }
    }
    
    public static String[] incrementArr(String[] arr)
    {
        String[] novo = new String[arr.length+1];
        for (int i = 0; i < arr.length; i++)
        {
            novo[i] = arr[i];
        }
        return novo;
    }

    public static String[] add(String[] arr, String val)
    {
        arr = incrementArr(arr);
        arr[arr.length-1] = val;

        return arr;
    }

    public static boolean contains(String[] arr, String val)
    {
        for(int i = 0; i < arr.length; i++)
        {
            if( val.equals(arr[i]) )
                return true;
        }
        return false;
    }
} // END class Grid
