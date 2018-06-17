/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spoj4onp;

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
public class SPOJ4Onp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader br = null;
        
        try {
            String line;
            br = new BufferedReader(new FileReader("E:\\code\\java\\netbeans\\SPOJ4Onp\\np.txt"));
            while ((line = br.readLine()) != null) {
                System.out.println(new Rpn(line));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SPOJ4Onp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SPOJ4Onp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) { }
        }
    }
    //http://en.wikipedia.org/wiki/Shunting-yard_algorithm
}