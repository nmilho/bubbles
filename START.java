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
            System.out.println("X=" + grid.posOnPane(x) + "   ---   Y=" + grid.posOnPane(y));
            System.out.println("GridPos");
            System.out.println("X=" + grid.gridPos(x) + "   ---   Y=" + grid.gridPos(y));
            System.out.println("---------------------------------------------------------------------");
            int random = (int)x % bubbleColors.length;
            this.grid.drawBubble(x, y, bubbleColors[random]);
            this.pane.getChildren().add(grid.getBubbleCircle(x, y));
            
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

} // END class Begin
