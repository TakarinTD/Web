package vonglap;

import java.math.BigInteger;
import java.util.Scanner;

import static java.lang.Math.abs;

public class GiaiThua {
    public static void main(String[] args) {
        int n;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập N: ");
        n=scanner.nextInt();
        BigInteger ketQua= BigInteger.valueOf(1);
        int m=abs(n);
        while (m!=0){
            ketQua= ketQua.multiply(BigInteger.valueOf(m));
            m--;
        }
        if(n>=0) System.out.println("Kết quả: "+ketQua);
        else System.out.println("Kết quả: -"+ketQua);;
    }

}
