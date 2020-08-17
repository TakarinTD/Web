package vonglap;

import java.util.*;

public class ChuSo {
    public static void main (String[] args) {
        int n;
        String chu[]={"Không","Một","Hai","Ba","Bốn","Năm","Sáu","Bảy","Tám","Chín"};
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập n:");
        n=scanner.nextInt();
        System.out.print("Kết quả: ");
        for(int i=0;i<=9;i++){
            if(i==n) {
                System.out.println(chu[i]);
                break;
            }
        }
    }
}
