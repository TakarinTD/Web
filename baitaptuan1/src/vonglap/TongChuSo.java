package vonglap;

import java.util.*;

public class TongChuSo {
    public static void main (String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập số tự nhiên n:");
        int n=scanner.nextInt();
        int sum=0;
        System.out.print("Tổng các chữ số của "+n+" là: ");
        while (n!=0){
            sum+=n%10;
            n/=10;
        }
        System.out.print(sum);
    }
}
