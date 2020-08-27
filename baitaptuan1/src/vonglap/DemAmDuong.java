package vonglap;

import java.util.*;

public class DemAmDuong {
    public static void main (String[] args) {
        int n,soDuong=0,soAm=0,soKhong=0,a;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập số lượng số nguyên: ");
        n=scanner.nextInt();
        System.out.println("Nhập "+n+" số nguyên: ");
        while (n!=0){
            a=scanner.nextInt();
            if(a<0) soAm++;
            else if(a==0) soKhong++;
            else soDuong++;
            n--;
        }
        System.out.println("Có "+soAm+" số âm, "+soKhong+" số không, "+soDuong+" số dương.");
    }
}
