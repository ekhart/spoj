/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spoj6arith;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 *
 * @author Ekh
 */
public class SPOJ6Arith {

    /**
     * @param args the command line arguments
     */
    //1. readline
    //2. parse expr: a op b
    //3. print in format - get string length of wynik
    //    a
    // op b
    // ----
    //    c
    public static void main(String[] args) {
        BufferedReader br = null;
        
        try {
            String line;
            br = new BufferedReader(new FileReader("E:\\code\\java\\netbeans\\SPOJ6Arith\\arith.txt"));
            final String NUMBER = "\\d+";
            final String OPERATOR = ".";
            while ((line = br.readLine()) != null) {
                Scanner s = new Scanner(line);
                int a = Integer.parseInt(s.findInLine(NUMBER));
                char operator = s.findInLine(OPERATOR).charAt(0);
                int b = Integer.parseInt(s.findInLine(NUMBER));
                
                int result = calculateResult(a, operator, b);
                System.out.println(printAsHuman(a, operator, b, result));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SPOJ6Arith.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SPOJ6Arith.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) { }
        }
    }

    public static String printAsHuman(int a, char operator, int b, int result) {
        int width = Integer.toString(result).length();
        String format = " %" + width + "d%n" + 
                        operator + "%" + width + "d%n" +
                        padString("", width, '-') + "%n" +
                        " %" + width + "d%n";
        return String.format(format, a, b, result);
    }
    
    public static String padString(String str, int leng, char sep) {
        for (int i = str.length(); i <= leng; i++)
            str += sep;
        return str;
    }
    
    private static int calculateResult(int a, char operator, int b) {
        switch (operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return b != 0 ? a / b : 0;
        }
        return 0;
    }
}
