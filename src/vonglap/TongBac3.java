package vonglap;

import java.util.Scanner;

import static java.lang.StrictMath.pow;

public class TongBac3 {
    public static void main(String[] args) {
        int n,sum=0;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập N (N>0): ");
        n=scanner.nextInt();
        for(int i=1;i<=n;i++){
            sum+=pow(i,3);
        }
        System.out.println("Tổng bậc 3 của "+ n +" số nguyên đầu tiên: "+sum);
    }
}
