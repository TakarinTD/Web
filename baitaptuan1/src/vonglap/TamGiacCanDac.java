package vonglap;

import java.util.Scanner;

public class TamGiacCanDac {
    public static void main(String[] args) {
        int h,g;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập chiều cao tam giác: ");
        h=scanner.nextInt();
        g=0;
        System.out.println("Tam giác cân đặc với chiều cao "+h);
        while (h > 0)
        {
            for (int i = 1; i<h; i++)
                System.out.printf("%c", ' ');
            for (int k = 0; k <= g; k ++)
                System.out.printf("%c", '*');
            h -- ;
            g += 2 ;
            System.out.printf("\n");
        }
    }
}
