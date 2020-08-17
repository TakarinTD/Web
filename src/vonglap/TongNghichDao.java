package vonglap;

import java.util.Scanner;

public class TongNghichDao {
    public static void main (String[] args) {
        int n;
        float sum = 0;
        Scanner scanner = new Scanner (System.in);
        System.out.println ("Nhập N (N>0): ");
        n = scanner.nextInt ();
        for (int i = 1; i <= n; i++) {
            sum += 1.0 / i;
        }
        System.out.println ("Tổng nghịch đảo của " + n + " số nguyên đầu tiên là: " + sum);
    }
}
