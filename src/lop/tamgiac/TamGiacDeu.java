package lop.tamgiac;

import static java.lang.StrictMath.sqrt;

public class TamGiacDeu extends TamGiacCan {
    protected void nhapTamGiac () {
        System.out.print("Nhap do dai canh tam giac: ");
        this.a=this.b=this.c=scanner.nextInt();
    }
    protected void xuatTamGiac(){
        System.out.println("Tam giac deu voi canh bang: "+this.a);
    }
    protected int chuVi () {
        return 3*this.getA();
    }

    protected double dienTich () {
        return this.a*this.a*sqrt(3)/4;
    }
}
