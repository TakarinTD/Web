package vonglap;

import static java.lang.StrictMath.sqrt;
import java.util.*;

public class KiemTraSoNguyenTo {
    public static void main (String[] args) {
        int n;
        System.out.println("Nhập n: ");
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        if (n < 2) {
            System.out.printf(n+" không là số nguyên tố!");
            return;
        }
        int squareRoot = (int)sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                System.out.printf(n+" không là số nguyên tố!");
                return;
            }
        }
        System.out.printf(n+" là số nguyên tố!");
        return;
    }
}
