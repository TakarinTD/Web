package vonglap;

import java.util.*;

public class ChuSoLonNhat {
    public static void main (String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập số tự nhiên n:");
        int n=scanner.nextInt();
        int max=0;
        System.out.print("Chữ số lớn nhất của "+n+" là: ");
        while (n!=0){
            int i=n%10;
            if(max<i) max=i;
            n/=10;
        }
        System.out.print(max);
    }
}
