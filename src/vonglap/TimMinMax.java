package vonglap;

import java.util.Scanner;

public class TimMinMax {
    public static void main(String[] args) {
        int n;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập số số nguyên cần duyệt (N>0): ");
        n=scanner.nextInt();
        int daySo[]=new int[n];
        System.out.println("Nhập dãy số cần duyệt: ");
        for(int i=0;i<n;i++){
            daySo[i]=scanner.nextInt();
        }
        int max=daySo[0],min=daySo[0];
        for(int i=1;i<n;i++){
            if(daySo[i]>max) max=daySo[i];
            if(daySo[i]<min) min=daySo[i];
        }
        System.out.println("Số lớn nhất của dãy: "+max);
        System.out.println("Số nhỏ nhất của dãy: "+min);
    }
}
