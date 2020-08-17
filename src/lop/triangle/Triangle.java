package lop.triangle;

import static java.lang.StrictMath.sqrt;
import java.util.*;

public class Triangle {
    private int a,b,c;

    public int getA () {
        return a;
    }

    public void setA (int a) {
        this.a = a;
    }

    public int getB () {
        return b;
    }

    public void setB (int b) {
        this.b = b;
    }

    public int getC () {
        return c;
    }

    public void setC (int c) {
        this.c = c;
    }

    public void nhapDoDaiBaCanh(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập độ dài ba cạnh tam giác: ");
        this.setA(scanner.nextInt());
        this.setB(scanner.nextInt());
        this.setC(scanner.nextInt());
    }
    public int chuVi(){
        return this.getA()+this.getB()+this.getC();
    }
    public double dienTich(){
        double nuaChuVi=this.chuVi()/2;
        return sqrt(nuaChuVi*(nuaChuVi-this.getA())*(nuaChuVi-this.getB())*(nuaChuVi-this.getC()));
    }
    public void kieuTamGiac(){
        int a=this.getA();
        int b=this.getB();
        int c=this.getC();
        if(a==b&&b==c){
            System.out.println("Tam giác đều!");
        }
        else if(a==b||a==c||b==c){
            if((a*a+b*b)==c*c||(a*a+c*c)==b*b||(b*b+c*c)==a*a) {
                System.out.println("Tam giác vuông cân!");
            } else System.out.println("Tam giác cân!");
        }
        else System.out.println("Tam giác thường!");
    }
}
