package vonglap;

import static java.lang.StrictMath.sqrt;
import java.util.*;

public class LietKeSoNguyenTo {
    public static void main (String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập n: ");
        n=scanner.nextInt();
        List<Integer> listNumbers = new ArrayList<Integer>();
        listNumbers.add(2);
        for(int i=3;i<=n;i++){
            int squareRoot = (int)sqrt(i);
            boolean check=true;
            for (int j = 2; j <= squareRoot; j++) {
                if(i%j==0){
                    check=false;
                    break;
                }
            }
            if(check) listNumbers.add(i);
        }
        int size=listNumbers.size();
        System.out.println("Các số nguyên tố từ 2 đến "+n+" là: ");
        for(int i=0;i<size-1;i++){
            System.out.print(listNumbers.get(i)+",");
        }
        System.out.print(listNumbers.get(size-1));
    }
}
