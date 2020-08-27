package test1.bai1;

import java.util.Scanner;

import static java.lang.Math.*;

public class PhuongTrinhBacHai {
    public static void main(String[] args) {

        double a, b, c, delta, x1, x2;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập hệ số a: ");
        a = scanner.nextDouble();
        System.out.println("Nhập hệ số b: ");
        b = scanner.nextDouble();
        System.out.println("Nhập hệ số c: ");
        c = scanner.nextDouble();

        if (a == 0) {
            if (b == 0) {
                System.out.println("Phương trình vô nghiệm!");
            } else {
                System.out.println("Phương trình có một nghiệm: "
                        + "x = " + (-c / b));
            }
            return;
        } else {
            delta = b * b - 4 * a * c;
            if (delta >= 0) {
                double canDelta = sqrt(delta);
                x1 = ((-1.0) * b - canDelta) / (2 * a);
                x2 = ((-1.0) * b + canDelta) / (2 * a);
                System.out.println("Căn delta = " + sqrt(delta));
                System.out.println("Nghiệm x1 = " + x1);
                System.out.println("Nghiệm x2 = " + x2);
            } else {
                System.out.println("Delta âm Phương trình vô nghiệm");
            }
        }
    }
}
