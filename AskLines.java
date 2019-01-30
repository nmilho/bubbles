
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
public class AskLines extends Group { 
    private static int ask()
    {        
        TextInputDialog dialog = new TextInputDialog("7");
        dialog.setTitle("BUBBLE SHOOTER");
        dialog.setHeaderText("INDIQUE QUANTAS LINHAS PRETENDE (entre 7 e 10)");
        dialog.setContentText("Introduza o número e linhas :");
        Optional<String> result = dialog.showAndWait();
        int lines = Integer.parseInt(result.get());
        return lines;   
    }

    public static int lines ()
    {
        int lines = ask();
        if (lines < 7 || lines > 10)
        {
            do {
                lines = ask();
            } while (lines < 7 || lines > 10);
        }   
        return lines;
    }
} // END class askLines
