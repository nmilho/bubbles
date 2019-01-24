
/**
 * Write a description of class teste here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class teste
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class teste
     */
    public teste()
    {
        // initialise instance variables
        double x = 25;
      
        
        double raio = 15;
        
        double resto =  x % raio;
        double centerX = 0;
        if(resto < raio/2)
        {
            centerX = x - resto;
        }
        else
        {
            centerX = x + (raio - resto);
        }
        
      
    }

    
}
