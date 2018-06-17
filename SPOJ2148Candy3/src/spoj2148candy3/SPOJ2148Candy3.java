/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spoj2148candy3;

/**
 *
 * @author Ekh
 */
public class SPOJ2148Candy3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyFileRead file = new MyFileRead("E:\\code\\java\\netbeans\\SPOJ2148Candy3\\np.txt");
        for (String line; (line = file.nextLine()) != null;) {
            if (line.isEmpty()) continue;
            int n = Integer.parseInt(line);
            int t[] = new int[n];
            
            for (int i = 0; i < n; ++i)
                t[i] = Integer.parseInt(file.nextLine());
            
            System.out.println(sum(t) % n == 0 ? "YES" : "NO");
        }
        file.close();
    }
    
    public static int sum(int t[]) {
        int sum = 0;
        for (int i = 0; i < t.length; ++i) 
            sum += t[i];
        return sum;
    }
}
