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
            LongProperty xx = new SimpleLongProperty(x);
            LongProperty yy = new SimpleLongProperty(y);
            int random = (int)x % bubbleColors.length;
            this.grid.drawBubble(x, y, bubbleColors[random]);
            this.pane.getChildren().add(grid.getBubbleCircle(x, y));
            Text txt1 = new Text();
            this.pane.getChildren().add(txt1);
            txt1.textProperty().bind(Bindings.createStringBinding(() -> ("x " + xx.get())));
            txt1.setFill(Color.BLACK);
            txt1.setOpacity(0);
            Text txt2 = new Text();
            this.pane.getChildren().add(txt2);
            txt2.textProperty().bind(Bindings.createStringBinding(() -> ("y " + yy.get())));
            txt2.setFill(Color.RED);
            txt2.setOpacity(0);
            
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
