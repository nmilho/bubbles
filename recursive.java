import lang.stride.*;
import java.util.Scanner;

/**
 * Primeiro teste com BlueJ e com Java desde 1900 e troca o passo
 * @author Nuno Milho @version 1.00
 */
public class recursive
{
    static Scanner scanner = new Scanner(System.in);
    static final int _Rows = 10;
    static final int _Cols = 5;
    
    static char[][] bubbleGrid = {{'A', 'V', 'V', 'A', 'V'},
                               {'V', 'A', 'V', 'V', 'V'},
                               {'V', 'A', 'A', 'V', 'A'},
                               {'A', 'V', 'A', 'V', 'V'},
                               {'A', 'A', 'V', 'A', 'V'},
                               {' ', ' ', ' ', ' ', ' '},
                               {' ', ' ', ' ', ' ', ' '},
                               {' ', ' ', ' ', ' ', ' '},
                               {' ', ' ', ' ', ' ', ' '},
                               {' ', ' ', ' ', ' ', ' '}};
    
    public static void main(String[] args) 
    {
    }
    
    
    
    public void printGrid() 
    {
        for(int l = 0; l < 10; l++)
        {
            for(int c = 0; c < 5; c++)
            {
                if(c<4)
                    System.out.print(bubbleGrid[l][c]);
                else
                    System.out.println(bubbleGrid[l][c]);
            }
        }
    }

    public char getColor(int row, int col)
    {
        if(hasBubble(row, col))
            return bubbleGrid[row][col];
        else
            return '0';
    }
    
    public void putBubble(int row, int col, char color)
    {
        bubbleGrid[row][col] = color;
        String matches = "";
        locateNeighbors(row, col, color, matches);
    }
    
    public boolean hasBubble(int row, int col)
    {
        return bubbleGrid[row][col] != ' ';
    }
    
    public void removeBubble(int row, int col)
    {
        bubbleGrid[row][col] = ' ';
    }

    

    public void locateNeighbors(int col, int row, char color, String matches) 
    {
    
        if(matches.indexOf("["+row+","+col+"]") != -1)
        {
            System.out.println(matches);
            return;
        }
        else
        {
            matches += "["+row+","+col+"]";
        }

        //Check north
        if(row + 1 < _Rows)
        {
            if(bubbleGrid[row + 1][col] == color)
                locateNeighbors(col, row + 1, color, matches);
        }

        //Check east
        if(col + 1 < _Cols)
        {
            if(bubbleGrid[row][col + 1] == color)
                locateNeighbors(col + 1, row, color, matches);
        }

        //Check south
        if(row > 0)
        {
            if(bubbleGrid[row - 1][col] == color)
                locateNeighbors(col, row - 1, color, matches);
        }

        //Check west
        if(col > 0)
        {
            if(bubbleGrid[row][col - 1] == color)
                locateNeighbors(col - 1, row, color, matches);
        }

    }

}
