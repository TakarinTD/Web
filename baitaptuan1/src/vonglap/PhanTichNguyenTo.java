package vonglap;

import java.util.*;

public class PhanTichNguyenTo {
    public static void main (String[] args) {
        int n,i = 2;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập n:");
        List<Integer> listNumbers = new ArrayList<Integer>();
        n=scanner.nextInt();
        while (n > 1) {
            if (n % i == 0) {
                n = n / i;
                listNumbers.add(i);
            } else {
                i++;
            }
        }
        if (listNumbers.isEmpty()) {
            listNumbers.add(n);
        }
        int size=listNumbers.size();
        System.out.print("Kết quả: n=");
        for(int j=0;j<size-1;j++){
            System.out.print(listNumbers.get(i)+"x");
        }
        System.out.print(listNumbers.get(size - 1));
    }
}
