
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
 * O programa deve ser escrito em inglês.
 */
public class AskColumns extends Group { 
    private static int ask()
    {        
        TextInputDialog dialog = new TextInputDialog("15");
        dialog.setTitle("BUBBLE SHOOTER");
        dialog.setHeaderText("INDIQUE QUANTAS COLUNAS PRETENDE (entre 15 e 20)");
        dialog.setContentText("Introduza o número e colunas :");
        Optional<String> result = dialog.showAndWait();
        int columns = Integer.parseInt(result.get());   
        return columns; 
    }

    public static int columns ()
    {
       int columns = ask();
       if (columns < 15 || columns > 20)
        {
            do {
                 columns = ask();
            } while (columns < 15 || columns > 20);
        }
        return columns;
    }
} // END class askColumns
