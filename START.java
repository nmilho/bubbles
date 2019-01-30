
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

/** 
 * @author Gonçalo Lopes
 * @version 2018-12-14
 */
public class START  {
    private Pane pane;

    public static final Color[] bubbleColors = {Color.YELLOW, Color.GREEN, Color.RED,
            Color.BLUE, Color.GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK};

    private Line line;
    private Bubble nextBub;
    private BubbleWorld grid;

    boolean hasLine = false;

    public void launch()
    {
        // Initialises JavaFX:
        new JFXPanel();
        // Makes sure JavaFX doesn't exit when first window is closed:
        Platform.setImplicitExit(false);
        // Runs initialisation on the JavaFX thread:
        Platform.runLater(() -> start(new Stage()));
    }

    private void start(Stage primaryStage) 
    {
        primaryStage.setOnCloseRequest(
            e -> Platform.runLater( () -> {Platform.exit(); System.exit(0);} ) );
            
        int lines = AskLines.lines();
        int columns = AskColumns.columns();
        Pane pane = new Pane();
        pane.setPrefSize(30 * columns + 30, 30 * lines + 300);
        Scene scene = new Scene(pane, Color.AZURE);
        primaryStage.setScene(scene);
        primaryStage.show();

        BubbleWorld grid = new BubbleWorld(pane, lines, columns);
        //BubbleWorld.bubbleWorld(pane, lines, columns);

        this.addLine(pane, Color.BLACK, lines, columns);

        this.addNextBub(pane, grid.getRandomColor(), lines, columns);





        scene.setOnMouseMoved( event ->  {
                double w = event.getX();
                double k = event.getY();
                if (hasLine)
                {
                    moveEndOfLine(w, k);
                }
            });
        
        scene.setOnMousePressed(((MouseEvent event) -> {
                double x = event.getX();
                double y = event.getY();
                Bubble c = grid.circleInPoint(x, y);
                if (c == null) // if there is a rectangle
                { 
                    Color fll = nextBub.getColor();
                    grid.AddAndDrawNewBubble(pane, x, y, fll);
                    
                    int col = grid.getColumn(x);
                    int lin = grid.getLine(y);
                    
                    grid.findMatches(lin, col, fll, lines, columns);
                    grid.removeMatches(pane);
                    
                    nextBub.getCircle().setFill(grid.getRandomColor());
                }
        }));

    } // END start

    private void addLine(Pane pane, Color fill, int lines, int columns) {
        this.line = new Line((30 * columns + 30)/2, 30 * lines + 250, (30 * columns + 30)/2, 30 * lines + 250);
        this.line.setStrokeWidth(5);
        this.line.setStroke(fill);
        pane.getChildren().add(line);  
        this.hasLine = true;
    }

    private void addNextBub(Pane pane, Color fill, int lines, int columns)
    {
        this.nextBub = new Bubble((30 * columns + 30)/2, 30 * lines + 250, 15, fill);
        pane.getChildren().add(this.nextBub.getCircle());  
    }

    private void moveEndOfLine(double x, double y) {
        line.setEndX(x);
        line.setEndY(y);
    }

    private void removeLine(Pane pane) {
        pane.getChildren().remove(line);
        this.hasLine = false;
    }
} // END class Begin
