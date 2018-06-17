/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spoj3410square;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ekh
 */
public class Spoj3410Square {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader br = null;
        
        try {
            String line;
            br = new BufferedReader(new FileReader("E:\\code\\java\\netbeans\\Spoj3410Square\\np.txt"));
            while ((line = br.readLine()) != null) {
                System.out.println(squaresInGrid(Integer.parseInt(line)));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Spoj3410Square.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Spoj3410Square.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) { }
        }
    }

    private static int squaresInGrid(int n) {
        int result = 0;
        while (n > 0)
            result += Math.pow(n--, 2);
        return result;
    }
}
