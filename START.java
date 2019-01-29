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
import javafx.scene.input.MouseEvent;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.binding.Bindings;

import lang.stride.*;
import java.util.Scanner;

/** 
 * @author Gonçalo Lopes
 * @version 2018-12-14
 */
public class START  {
    
    public static final Color[] bubbleColors = {Color.YELLOW, Color.GREEN, Color.RED,
            Color.BLUE, Color.GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK};
    private int GRID_SIZE = 30;

    private int TOTAL_COLS = 5;
    private int TOTAL_ROWS = 10;
    private int RADIUS = 15;


    private Pane pane;    
    private Line line;
    private Color nextColor;
    private BubbleWorld grid;
    private Stage primaryStage;
    private Scene scene;
    

    public void launch()
    {
        // Initialises JavaFX:
        new JFXPanel();
        // Makes sure JavaFX doesn't exit when first window is closed:
        Platform.setImplicitExit(false);
        // Runs initialisation on the JavaFX thread:
        Platform.runLater(() -> start());
    }
    
    private void start() 
    {

        this.primaryStage = new Stage();
        this.primaryStage.setOnCloseRequest(
            e -> Platform.runLater( () -> {Platform.exit(); System.exit(0);} ) );
        
        this.pane = new Pane();
        this.grid = new BubbleWorld(TOTAL_COLS, TOTAL_ROWS);
        this.pane.setPrefSize(GRID_SIZE * TOTAL_COLS, GRID_SIZE * TOTAL_ROWS);
        this.scene = new Scene(pane, Color.AZURE);
        this.primaryStage.setScene(scene);
        this.primaryStage.show();


        this.addLine();

        drawGrid(TOTAL_COLS, TOTAL_ROWS);

        scene.setOnMouseMoved( event ->  {
            double w = event.getX();
            double k = event.getY();
            moveEndOfLine(w, k);
        });

        scene.setOnMousePressed(((MouseEvent event) -> {
            int x = (int)event.getX();
            int y = (int)event.getY();
            System.out.println("Coords");
            System.out.println("X=" + x + "   ---   Y=" + y);
            System.out.println("PosOnPane");
            System.out.println("X=" + this.posOnPane(x) + "   ---   Y=" + this.posOnPane(y));
            System.out.println("GridPos");
            System.out.println("X=" + this.gridPos(x) + "   ---   Y=" + this.gridPos(y));
            System.out.println("---------------------------------------------------------------------");
            int random = (int)x % bubbleColors.length;
            this.grid.drawBubble(x, y, bubbleColors[random]);
            Circle cc = new Circle(x, y, 15);
            this.pane.getChildren().add(cc);
            
        }));

    } // END start

    private void addLine() {
        this.line = new Line((GRID_SIZE * TOTAL_COLS)/2, GRID_SIZE * TOTAL_ROWS, (GRID_SIZE * TOTAL_COLS)/2, GRID_SIZE * TOTAL_ROWS);
        this.line.setStrokeWidth(5);
        this.line.setStroke(Color.BLACK);
        pane.getChildren().add(line);  
    }
    
    private void moveEndOfLine(double x, double y) {
        line.setEndX(x);
        line.setEndY(y);
    }

    public Pane getPane()
    {
        return this.pane;
    }

    public BubbleWorld getGrid()
    {
        return this.grid;
    }

    public void drawGrid(int cols, int lines)
    {
        Line ll;
        int width = GRID_SIZE * TOTAL_COLS;
        int height = GRID_SIZE * TOTAL_ROWS;
        /*ll = new Line(0, 15, width, 15);
        pane.getChildren().add(ll);*/
        for(int i = 0; i < lines*2; i++)
        {
            System.out.println("startX=0     startY=" + i*GRID_SIZE/2 + "    endX=" + width + "    endY=" + i*GRID_SIZE/2);
            ll = new Line(0, i*GRID_SIZE/2, width, i*GRID_SIZE/2);
            pane.getChildren().add(ll);
            
        }

        for(int i = 0; i < cols*2; i++)
        {
            System.out.println("startX=" + i*GRID_SIZE/2 + "     startY=0    endX=" + i*GRID_SIZE/2 + "    endY=" + height);
            ll = new Line(i*GRID_SIZE/2, 0, i*GRID_SIZE/2, height);
            pane.getChildren().add(ll);
            
        }
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
        return (int)(coord - RADIUS) / GRID_SIZE;
        /*double rest = (double)coord % (double)RADIUS;

        if(rest < (double)RADIUS/2)
        {
            return (int)(((double)coord - rest)/RADIUS);
        }
        else
        {
            return (int)(((double)coord + (double)RADIUS - rest)/RADIUS);   
        }*/
    }
} // END class Begin
