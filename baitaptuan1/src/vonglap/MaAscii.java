package vonglap;

import java.util.*;

public class MaAscii {
    public static void main (String[] args) {
        char kiTu;
        Scanner scanner=new Scanner(System.in);
        do{
            System.out.println("Nhập một ký tự: ");
            kiTu=scanner.next().charAt(0);
            System.out.println("Ma Ascii tương ứng: "+(int)kiTu);
        }while(kiTu!='0');
    }
}
