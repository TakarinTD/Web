package vonglap;

public class TamGiacCanRong {
    public static void main (String[] args) {
        int h;
        java.util.Scanner scanner=new java.util.Scanner (System.in);
        System.out.println("Nhập chiều cao tam giác: ");
        h=scanner.nextInt();
        System.out.println("Tam giác rỗng với chiều cao "+h);
        for (int i=1;i<h;i++)
        {
            for(int j=h-i;j>0;j--)
                System.out.printf (" ");
            for (int k=1;k<=2*i-1;k++)
            {
                if (k==2*i-1|| k==1)
                    System.out.printf ("*");
                else System.out.printf (" ");
            }
            System.out.println ();
        }
        for(int k=1;k<=2*h-1;k++){
            if(k%2==1) {
                System.out.printf ("*");
            }
            else System.out.printf (" ");
        }
    }
}
