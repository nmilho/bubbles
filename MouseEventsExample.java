
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
 * 
 * @author Diogo Pina Manique 
 * @author João Paulo Barros
 * @version 2019/01/10
 */
public class MouseEventsExample  {

    private Line mouseLine;
    private boolean hasLine = false;
    private Pane pane;
    private void start(Stage primaryStage) 
    {
        primaryStage.setOnCloseRequest(
            e -> Platform.runLater( () -> {Platform.exit(); System.exit(0);} ) );

        // https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/Pane.html
        this.pane = new Pane();
        this.pane.setPrefSize(800, 800);
        primaryStage.setScene(new Scene(this.pane));
        primaryStage.show();

        this.addLine();

        this.pane.setOnMouseMoved(event -> {
                if (hasLine)
                {
                    moveEndOfLine(event.getX(), event.getY());
                }
            });

        this.pane.setOnMouseClicked(event -> {
                if (hasLine)
                {
                    removeLine();
                }
                else
                {
                    addLine();
                }
            });

    } // END start

    void addLine() {
        this.mouseLine = new Line(240,410,240,200);
        this.mouseLine.setStroke(Color.BLACK);
        //mouseLine.setStroke(Color.hsb(Math.random() * 360, 1, 1));
        this.pane.getChildren().add(mouseLine);
        this.hasLine = true;
    }

    void removeLine() {
        pane.getChildren().remove(mouseLine);
        mouseLine = null;
        this.hasLine = false;
    }

    void moveEndOfLine(double x, double y) {
        mouseLine.setEndX(x);
        mouseLine.setEndY(y);
    }

    /**
     * Add shape to pane 
     */
    public void addShape(Shape shape)
    {
        Platform.runLater(() -> this.pane.getChildren().add(shape));
    }

    /** execute this method to start the program
     * executing the code in method start(Stage primaryStage) 
     */
    public static void start()
    {
        MouseEventsExample drawingApp = new MouseEventsExample();
        drawingApp.launch();
    }

    public void launch()
    {
        // Initialises JavaFX:
        new JFXPanel();
        // Makes sure JavaFX doesn't exit when first window is closed:
        Platform.setImplicitExit(false);
        // Runs initialisation on the JavaFX thread:
        Platform.runLater(() -> start(new Stage()));
    }

    public MouseEventsExample() 
    {
        super();
    }
} // END class World

