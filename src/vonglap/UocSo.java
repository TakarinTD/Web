package vonglap;

import java.util.Scanner;

import static java.lang.StrictMath.abs;

public class UocSo {
    public static void main(String[] args) {
        int n,k=0;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập N: ");
        n=scanner.nextInt();
        int m=abs(n);
        int uocN[] = new int[m];
        for(int i=m;i>=-m;i--){
            if(i!=0){
                if(m%i==0) {
                    uocN[k]=i;
                    k++;
                }
            }
        }
        System.out.printf("Tập các ước của "+n+" là: { ");
        for(int i=k-1;i>=0;i--){
            System.out.printf(uocN[i]+", ");
        }
        System.out.println("}");
    }
}
