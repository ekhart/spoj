/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spoj1025fashionshows;

import java.io.FileNotFoundException;

/**
 *
 * @author Ekh
 */
public class SPOJ1025FashionShows {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        MyFileRead file = new MyFileRead("E:\\code\\java\\netbeans\\SPOJ1025FashionShows\\np.txt");
        for (String line; (line = file.nextLine()) != null;) {
            int n = Integer.parseInt(line);
            int mans[] = hotness(file.nextLine(), n);
            int woman[] = hotness(file.nextLine(), n);
            
            System.out.println(hotnessBonds(mans, woman));
        }
        file.close();
    }
    
    private static int[] hotness (String line, int n) {
        int m[] = new int[n];
        int i = 0;
        for (String num : line.split(" "))
            m[i++] = Integer.parseInt(num);
        return m;
    } 

    private static int hotnessBonds(int[] mans, int[] woman) {
        int sum = 0;
        for (int i = 0; i<mans.length; ++i) 
            sum += mans[i] * woman[i];
        return sum;
    }
}
