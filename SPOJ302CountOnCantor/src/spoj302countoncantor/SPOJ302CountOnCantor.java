/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spoj302countoncantor;

/**
 *
 * @author Ekh
 */
public class SPOJ302CountOnCantor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyFileRead file = new MyFileRead("E:\\code\\java\\netbeans\\SPOJ302CountOnCantor\\np.txt");
        for (String line; (line = file.nextLine()) != null;) {
            int i = Integer.parseInt(line);
            System.out.println("TERM " + i + " IS " + cantor(i));
        }
        file.close();
    }

    private static String cantor(int i) {
        int d = (int) ((-1 + Math.sqrt(1 + 8 * i)) / 2);
        int e = i - d * (d + 1) / 2;
        int v1 = e <= 1 ? d + e : d + 2 - e;
        int v2 = e <= 1 ?     1 : e;
        return String.format("%d/%d", d % 2 == 0 ? v1 : v2, d % 2 == 0 ? v2 : v1);
    }
}
