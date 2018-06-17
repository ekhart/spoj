/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spoj3442lastdigit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ekh
 */
public class SPOJ3442LastDigit {
    /**
     * @param args the command line arguments
     */
    static Map<Integer, List<Integer>> lastDigit;
    
    public static void main(String[] args) {
        init();
        MyFileRead file = new MyFileRead("E:\\code\\java\\netbeans\\SPOJ3442LastDigit\\np.txt");
        for (String line; (line = file.nextLine()) != null;) {
            String nums[] = line.split(" ");
            System.out.println(lastDigit(Integer.parseInt(nums[0]), Integer.parseInt(nums[1])));
        }
        file.close();
    }

    private static void init() {
        lastDigit = new HashMap<>();
        lastDigit.put(2, new ArrayList<>(Arrays.asList(2, 4, 8, 6)));
        lastDigit.put(3, new ArrayList<>(Arrays.asList(3, 9, 7, 1)));
        lastDigit.put(4, new ArrayList<>(Arrays.asList(4, 6)));
        lastDigit.put(5, new ArrayList<>(Arrays.asList(5)));
        lastDigit.put(6, new ArrayList<>(Arrays.asList(6)));
        lastDigit.put(7, new ArrayList<>(Arrays.asList(7, 9, 3, 1)));
        lastDigit.put(8, new ArrayList<>(Arrays.asList(8, 4, 2, 6)));
        lastDigit.put(9, new ArrayList<>(Arrays.asList(9, 1)));
    }
    
    private static int lastDigit(int a, int b) {
        List digits = lastDigit.get(a);
        return (int) digits.get(digits.size() == 1 ? 0 : b % digits.size() - 1);
    }
}
