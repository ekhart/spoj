/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spoj7975whatsnext;

/**
 *
 * @author Ekh
 */
public class SPOJ7975WhatsNext {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyFileRead file = new MyFileRead("E:\\code\\java\\netbeans\\SPOJ7975WhatsNext\\np.txt");
        final String AP = "AP", GP = "GP";
        for (String line; (line = file.nextLine()) != null && isEnd(line);) {
            String nums[] = line.split(" ");
            int a = Integer.parseInt(nums[0]);
            int b = Integer.parseInt(nums[1]);
            int c = Integer.parseInt(nums[2]);
            
            if (isAP(a, b, c))
                System.out.println(AP + " " + nextAP(a, b, c));
            else if (isGP(a, b, c))
                System.out.println(GP + " " + nextGP(a, b, c));
            else
                System.out.println("dont know");
        }
        file.close();
    }

    private static boolean isEnd(String line) {
        return line.charAt(0) != '0' && line.charAt(2) != '0' && line.charAt(4) != '0';
    }

    private static boolean isAP(int a, int b, int c) {
        return (c - b) == (b - a);
    }

    private static boolean isGP(int a, int b, int c) {
        return (c / b) == (b / a);
    }

    private static int nextAP(int a, int b, int c) {
        return c + (b - a);
    }

    private static int nextGP(int a, int b, int c) {
        return c * (b / a);
    }
}
