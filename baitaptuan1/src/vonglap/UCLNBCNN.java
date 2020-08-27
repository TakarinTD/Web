package vonglap;

import java.util.Scanner;

public class UCLNBCNN {
    public static void main(String[] args) {
        int a,b,uCLN,bCNN;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập lần lượt 2 số a và b: ");
        a=scanner.nextInt();
        b=scanner.nextInt();
        uCLN=uSCLN(a,b);
        bCNN=bSCNN(a,b);
        System.out.println("UCLN("+a+","+b+") là:"+uCLN);
        System.out.println("Cách 1: BCNN("+a+","+b+") là:"+bCNN);
        System.out.println("Cách 2: BCNN("+a+","+b+") là:"+(a * b) / uCLN);
    }

    private static int bSCNN(int a, int b) {
        int temp;
        if(a>b)temp=a;
        else temp=b;
        while ((temp%a)!=0||(temp%b)!=0){
            temp++;
        }
        return temp;
    }


    private static int uSCLN(int a, int b) {
        int temp1 = a;
        int temp2 = b;
        while (temp1 != temp2) {
            if (temp1 > temp2) {
                temp1 -= temp2;
            } else {
                temp2 -= temp1;
            }
        }
        return temp1;

    }
}
