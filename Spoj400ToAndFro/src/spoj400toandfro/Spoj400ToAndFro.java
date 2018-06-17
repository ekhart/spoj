/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spoj400toandfro;

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
public class Spoj400ToAndFro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader br = null;
        
        try {
            String line;
            br = new BufferedReader(new FileReader("E:\\code\\java\\netbeans\\Spoj400ToAndFro\\np.txt"));
            while ((line = br.readLine()) != null) {
                int length = Integer.parseInt(line);
                String code = br.readLine();
                decode(code, length);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Spoj400ToAndFro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Spoj400ToAndFro.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) { }
        }
    }

    private static void decode(String code, int length) {
        int rows = code.length()/length;
        char [][]t = new char[rows][];
        for (int i  = 0, j = 0; j < rows; i += length) {
            int mid = i + length;
            t[j] = new char[length];
            if (j % 2 == 0)
                t[j++] = code.substring(i, mid).toCharArray();
            else
                t[j++] = new StringBuilder(code.substring(i, mid)).reverse().toString().toCharArray();
        }
        print(t);
    }
    
    private static void print(char [][]t) {
        String line = "";
        int i, j;
        for (i = 0; i<t[i].length; ++i) {
            for (j = 0; j<t.length; ++j)
                line += t[j][i];
        }
        System.out.println(line + "\n");
    }
}
