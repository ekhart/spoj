/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spoj5palin;

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
public class SPOJ5Palin {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        BufferedReader br = null;
        
        try {
            String line;
            br = new BufferedReader(new FileReader("E:\\code\\java\\netbeans\\SPOJ5Palin\\palin.txt"));
            br.readLine();
            while ((line = br.readLine()) != null) {
                int number = Integer.parseInt(line);
                int a = number, 
                    b = number;
                while (!isPalin(Integer.toString(--a)) || !isPalin(Integer.toString(++b)))
                    ;
                
                int diffa = Math.abs(number - a);
                int diffb = Math.abs(number - b);

                System.out.println(diffa < diffb ? a : b);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SPOJ5Palin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SPOJ5Palin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) { }
        }
            
        
        //realine
        //convert to int
        //while (isNotPalin(int.toString)
        // palin(int - 1)
        // palin(int + 1)
    }
    
    public static boolean isPalin(String s) {
        for (int i = 0, j = s.length()-1; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }
}
