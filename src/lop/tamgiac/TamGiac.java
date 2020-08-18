package lop.tamgiac;

import static java.lang.StrictMath.sqrt;
import java.util.*;

public abstract class TamGiac {
    protected int a, b, c;
    protected String viTri;
    Scanner scanner = new Scanner(System.in);

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

    public String getViTri () {
        return viTri;
    }

    public void setViTri (String viTri) {
        this.viTri = viTri;
    }

    protected int chuVi () {
        return this.getA() + this.getB() + this.getC();
    }

    protected double dienTich () {
        double nuaChuVi = this.chuVi() / 2;
        return sqrt(nuaChuVi * (nuaChuVi - this.getA()) * (nuaChuVi - this.getB()) * (nuaChuVi - this.getC()));
    }

    protected void nhapTamGiac () {
        System.out.println("Nhap 3 canh tam giac: ");
        this.setA(scanner.nextInt());
        this.setB(scanner.nextInt());
        this.setC(scanner.nextInt());
    }

    protected void xuatTamGiac () {
        System.out.println("Tam giac co 3 canh: " + a + " " + b + " " + c + " ");
    }
}
