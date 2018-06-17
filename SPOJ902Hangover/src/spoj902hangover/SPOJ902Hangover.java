/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spoj902hangover;

/**
 *
 * @author Ekh
 */
public class SPOJ902Hangover {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyFileRead file = new MyFileRead("E:\\code\\java\\netbeans\\SPOJ902Hangover\\np.txt");
        for (String line; (line = file.nextLine()) != null;) {
            float f = Float.parseFloat(line);
            if (f < 0.001) break;
            System.out.println(hangover(f) + " card(s)");
        }
        file.close();
    }

    private static int hangover(float f) {
        float sum = 0f;
        int i = 2; 
        while (sum + (1f / (i * 1f)) < f)
            sum += 1f / (i++ * 1f);
        return i - 1;
    }
}
