package vonglap;

import java.util.*;

public class SoChinhPhuong {
    public static void main (String[] args) {
        int n,i=0;
        System.out.println("Nhập N:");
        Scanner scanner=new Scanner(System.in);
        List<Integer> listNumbers = new ArrayList<Integer>();
        n=scanner.nextInt();
        while(i*i<=n){
            if(i*i==n){
                System.out.println(n+" là số chính phương");
                return;
            }
            i++;
        }
        System.out.println(n+" không là số chính phương");
    }
}
