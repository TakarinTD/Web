package vonglap;

import java.math.*;
import java.util.*;

public class GiaiThua {
    public static void main(String[] args) {
        BigInteger n;
        BigInteger m=new BigInteger("1");
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập N: ");
        n=scanner.nextBigInteger();
        BigInteger ketQua= BigInteger.valueOf(1);
        //int m=abs(n);
        while (!n.equals(BigInteger.ZERO)){
            ketQua= ketQua.multiply(n);
            n=n.subtract(m);
        }
       // if(n>=0) System.out.println("Kết quả: "+ketQua);
        System.out.println("Kết quả: "+ketQua);;
    }

}
