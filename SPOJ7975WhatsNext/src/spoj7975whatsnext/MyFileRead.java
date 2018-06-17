package spoj7975whatsnext;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class MyFileRead {
    BufferedReader br = null;
    
    public MyFileRead(String path) {
        try {
            br = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MyFileRead.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String nextLine() {
        try {
            return br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(MyFileRead.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void close() {
        try {
                if (br != null)
                    br.close();
            } catch (IOException ex) { }
    }
}
