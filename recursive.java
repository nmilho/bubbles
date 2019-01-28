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
    String[] matchesArr = new String[0];
    
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
        findMatches(row, col, color);
        if(matchesArr.length > 2)
        {
            removeMatches(bubbleGrid, matchesArr);
        }
        matchesArr = new String[0];
    }
    
    public boolean hasBubble(int row, int col)
    {
        return bubbleGrid[row][col] != ' ';
    }
    
    public void removeBubble(int row, int col)
    {
        bubbleGrid[row][col] = ' ';
    }

    public char[][] removeMatches(char[][] grid, String[] matches)
    {
        for(int i = 0; i < matches.length; i++)
        {
            String[] coords = matches[i].split(",");
            int row = Integer.parseInt(coords[0]);
            int col = Integer.parseInt(coords[1]);
            grid[row][col] = ' ';
        }
        return grid;
    }


    public void findMatches(int row, int col, char color) 
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
        if(row + 1 < _Rows)
        {
            if(bubbleGrid[row + 1][col] == color)
                findMatches(row + 1, col, color);
        }

        //coluna à direita
        if(col + 1 < _Cols)
        {
            if(bubbleGrid[row][col + 1] == color)
                findMatches(row, col + 1, color);
        }

        //linha acima
        if(row > 0)
        {
            if(bubbleGrid[row - 1][col] == color)
                findMatches(row - 1, col, color);
        }

        //coluna à esquerda
        if(col > 0)
        {
            if(bubbleGrid[row][col - 1] == color)
                findMatches(row, col - 1, color);
        }

    }


    public String[] incrementArr(String[] arr)
    {
        String[] novo = new String[arr.length+1];
        for (int i = 0; i < arr.length; i++)
        {
            novo[i] = arr[i];
        }
        return novo;
    }

    public String[] add(String[] arr, String val)
    {
        arr = incrementArr(arr);
        arr[arr.length-1] = val;

        return arr;
    }

    public boolean contains(String[] arr, String val)
    {
        for(int i = 0; i < arr.length; i++)
        {
            if( val.equals(arr[i]) )
                return true;
        }
        return false;
    }

}
