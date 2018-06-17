/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spoj11trailingzerosfact;

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
public class SPOJ11TrailingZerosFact {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader br = null;
        
        try {
            String line;
            br = new BufferedReader(new FileReader("E:\\code\\java\\netbeans\\SPOJ11TrailingZerosFact\\np.txt"));
            while ((line = br.readLine()) != null) {
                Scanner s = new Scanner(line);
                System.out.println(Z(s.nextInt()));
            }
            
            br = new BufferedReader(new FileReader("E:\\code\\java\\netbeans\\SPOJ11TrailingZerosFact\\np2.txt"));
            while ((line = br.readLine()) != null) {
                Scanner s = new Scanner(line);
                System.out.println(factorial(s.nextInt()));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SPOJ11TrailingZerosFact.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SPOJ11TrailingZerosFact.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) { }
        }
    }

    private static int Z(int n) {
        int zeros = 0;
        double fives;
        for (int powersOf5 = 5; (fives = ((n*1.0)/((1.0)*powersOf5))) > 1.0; powersOf5 *= 5)
            zeros += fives;
        return zeros; 
    }
    
    private static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++)
            fact *= i;
        return fact;
    }
}
