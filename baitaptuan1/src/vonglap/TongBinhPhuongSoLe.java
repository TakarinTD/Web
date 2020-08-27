package vonglap;

import java.util.Scanner;

import static java.lang.Math.pow;

public class TongBinhPhuongSoLe {
    public static void main(String[] args) {
        int n,sum=0;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập N (N>0): ");
        n=scanner.nextInt();
        for(int i=1;i<=n;i++){
            if(i%2==1){
                sum+=pow(i,2);
            }
        }
        System.out.println("Tổng bình phương các số lẻ từ 1 đến "+n+" là: "+sum);
    }
}

