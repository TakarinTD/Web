package vonglap;

import java.util.*;

public class Fibonacci {
    public static void main (String[] args) {
        int n;
        System.out.println("Nhập n(n>0): ");
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        int f1=1,f2=1,f3=0;
        for(int i=3;i<=n;i++){
            f3=f1+f2;
            f1=f2;
            f2=f3;
        }
        System.out.println("Số hạng thứ "+n+" của dãy Fibonacci là:  "+(n<3?1:f3));
    }
}

