package vonglap;

import java.util.*;

public class LuyThua {
    public static void main (String[] args) {
        int x, n;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập x: ");
        x=scanner.nextInt();
        System.out.println("Nhập n: ");
        n=scanner.nextInt();
        int x1=x;
        for(int i=2;i<=n;i++){
            x*=x1;
        }
        System.out.println(x1+"^"+n+"="+x);
    }
}
