package vonglap;

public class HCN {
    public static void main (String[] args) {
        int cd, cr;
        java.util.Scanner scanner = new java.util.Scanner (System.in);
        System.out.println ("Nhập chiều dài: ");
        cd = scanner.nextInt ();
        System.out.println ("Nhập chiều rộng: ");
        cr = scanner.nextInt ();
        int n=2*cd;
        for (int j = 1; j <= cr; j++) {
            for (int i = 1; i <= n; i++) {
                if ((j == 1) || (j == cr)) {
                    if (i % 2 == 1)
                        System.out.printf ("*");
                    else System.out.printf (" ");
                } else if (i == 1 || i == n-1) System.out.printf ("*");
                else System.out.printf (" ");
            }
            System.out.println ();
        }
    }
}
