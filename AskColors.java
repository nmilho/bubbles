
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
public class AskColors extends Group { 
    private static int ask()
    {
        TextInputDialog dialog = new TextInputDialog("2");
        dialog.setTitle("BUBBLE SHOOTER");
        dialog.setHeaderText("INDIQUE QUANTAS CORES PRETENDE (entre 2 e 8)");
        dialog.setContentText("Introduza o número e colores :");
        Optional<String> result = dialog.showAndWait();
        int numberColor = Integer.parseInt(result.get());
        return numberColor;
    }

    public static int numberColors ()
    {
        int numberColors = ask();
        if (numberColors < 2 || numberColors > 8)
        {
            do {
                numberColors = ask();
            } while (numberColors < 2 || numberColors > 8);
        } 
        return numberColors;
    }
} // END class askColors
