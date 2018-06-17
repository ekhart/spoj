/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spoj43addrev;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ekh
 */
public class SPOJ43AddRev {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader br = null;
        
        try {
            String line;
            br = new BufferedReader(new FileReader("E:\\code\\java\\netbeans\\SPOJ43AddRev\\addrev.txt"));
            while ((line = br.readLine()) != null) {
                Scanner s = new Scanner(line);
                int a = s.nextInt();
                int b = s.nextInt();
                
                System.out.println(revNumber(revNumber(a) + revNumber(b)));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SPOJ43AddRev.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SPOJ43AddRev.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) { }
        }
    }
    
    public static int revNumber(int i) {
        return Integer.parseInt(new StringBuilder(Integer.toString(i)).reverse().toString());
    }
}
