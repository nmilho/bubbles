
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

/** Este template foi criado na 
 * Escola Superior de Tecnologia e Gestão do
 * Instituto PolitÈcnico de Beja
 * em 2016/10/05
 * -----------------------------------------------------
 * Esta classe cria um programa utilizando JavaFX que funciona dentro do BLueJ e
 * com um "Pane" para desenho de "Shapes"
 * 
 * Deve criar um objeto da classe GUI e depois chamar o método launch()
 * 
 * Adicione aqui uma descrição da classe, o seu nome e a data
 * @author (o seu nome) 
 * @version (número de versão ou data)
 * 
 * O programa deve ser escrito em inglês. Color [] bubbleColors   int [] randomColors
 */
public class Bubble { 

    private Circle circle;
    
    public Bubble(int x, int y, int RADIUS, Color fill)
    {
        this.circle = new Circle(x, y, RADIUS);
        this.circle.setFill(fill);
    }
    
    public Circle getCircle()
    {
        return this.circle;
    }
    
    public Color getColor ()
    {
        return (Color) this.circle.getFill();
    }
} // END class Bubble
