package lop.vector;

import static java.lang.Math.*;
import java.util.*;

public class Vector {
    private double hoanhDoDau, tungDoDau, hoanhDoCuoi, tungDoCuoi;
    private double hoanhDoVector, tungDoVector;
    private String name;

    public Vector () {
    }

    public Vector (String name) {
        this.name = name;
    }

    public double getHoanhDoDau () {
        return hoanhDoDau;
    }

    public void setHoanhDoDau (double hoanhDoDau) {
        this.hoanhDoDau = hoanhDoDau;
    }

    public double getTungDoDau () {
        return tungDoDau;
    }

    public void setTungDoDau (double tungDoDau) {
        this.tungDoDau = tungDoDau;
    }

    public double getHoanhDoCuoi () {
        return hoanhDoCuoi;
    }

    public void setHoanhDoCuoi (double hoanhDoCuoi) {
        this.hoanhDoCuoi = hoanhDoCuoi;
    }

    public double getTungDoCuoi () {
        return tungDoCuoi;
    }

    public void setTungDoCuoi (double tungDoCuoi) {
        this.tungDoCuoi = tungDoCuoi;
    }


    public double getHoanhDoVector () {
        return hoanhDoVector;
    }

    public void setHoanhDoVector (double hoanhDoDau, double hoanhDoCuoi) {
        this.hoanhDoVector = hoanhDoCuoi - hoanhDoDau;
    }

    public void setHoanhDoVector (double hoanhDoVector) {
        this.hoanhDoVector = hoanhDoVector;
    }

    public double getTungDoVector () {
        return tungDoVector;
    }

    public void setTungDoVector (double tungDoDau, double tungDoCuoi) {
        this.tungDoVector = tungDoCuoi - tungDoDau;
    }

    public void setTungDoVector (double tungDoVector) {
        this.tungDoVector = tungDoVector;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public static boolean soSanhHaiVector (Vector vector1, Vector vector2) {
        if ((module(vector1) == module(vector2)) && cungPhuong(vector1, vector2) && (vector1.getHoanhDoVector() / vector2.getHoanhDoVector()) > 0)
            return true;
        return false;
    }

    public static double goc (Vector vector1, Vector vector2) {
        double a1 = vector1.getHoanhDoVector();
        double b1 = vector1.getTungDoVector();
        double a2 = vector2.getHoanhDoVector();
        double b2 = vector2.getTungDoVector();
        double cos = (a1 * a2 + b1 * b2) / (module(vector1) * module(vector2));
        return acos(cos);
    }

    public static double module (Vector vector) {
        return sqrt(pow(vector.getHoanhDoVector(), 2) + pow(vector.getTungDoVector(), 2));
    }

    public static boolean cungPhuong (Vector vector1, Vector vector2) {
        if ((vector1.getHoanhDoVector() / vector2.getHoanhDoVector() == vector1.getTungDoVector() / vector2.getTungDoVector()) || (vector2.getHoanhDoVector() == 0 && vector2.getTungDoVector() == 0))
            return true;
        return false;
    }

    public static Vector cong (Vector vector1, Vector vector2) {
        Vector vector = new Vector("tong");
        vector.setHoanhDoVector(vector1.getHoanhDoVector() + vector2.getHoanhDoVector());
        vector.setTungDoVector(vector1.getTungDoVector() + vector2.getTungDoVector());
        vector.in();
        return vector;
    }

    public static Vector tru (Vector vector1, Vector vector2) {
        Vector vector = new Vector("hieu");
        vector.setHoanhDoVector(vector1.getHoanhDoVector() - vector2.getHoanhDoVector());
        vector.setTungDoVector(vector1.getTungDoVector() - vector2.getTungDoVector());
        vector.in();
        return vector;
    }

    public static double nhan (Vector vector1, Vector vector2) {
        return module(vector1) * module(vector2) * cos(goc(vector1, vector2));
    }

    public void nhapTheoDiemDauCuoi () {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ten vector: ");
        this.setName(scanner.nextLine());
        System.out.print("Nhap hoanh do dau: ");
        this.setHoanhDoDau(scanner.nextDouble());
        System.out.print("Nhap hoanh cuoi dau: ");
        this.setHoanhDoCuoi(scanner.nextDouble());
        System.out.print("Nhap tung do dau: ");
        this.setTungDoDau(scanner.nextDouble());
        System.out.print("Nhap tung cuoi dau: ");
        this.setTungDoCuoi(scanner.nextDouble());

        this.setHoanhDoVector(this.getHoanhDoDau(),this.getHoanhDoCuoi());
        this.setTungDoVector(this.getTungDoDau(),this.getTungDoCuoi());
    }

    public void nhapTheoToaDo(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ten vector: ");
        this.setName(scanner.nextLine());
        System.out.print("Nhap hoanh do vector: ");
        this.setHoanhDoVector(scanner.nextDouble());
        System.out.print("Nhap tung do vector: ");
        this.setTungDoVector(scanner.nextDouble());
    }

    public void in(){
        System.out.println(this.getName()+"("+this.getHoanhDoVector()+","+this.getTungDoVector()+")");
    }


    public static void main (String[] args) {
        Vector vector1 = new Vector();
        Vector vector2 = new Vector();
        System.out.println("Nhap vector 1: ");
        vector1.nhapTheoDiemDauCuoi();
        System.out.println("Nhap vector 2: ");
        vector2.nhapTheoToaDo();
        System.out.print("vector 1: ");
        vector1.in();
        System.out.print("vector 2: ");
        vector2.in();
        if(soSanhHaiVector(vector1,vector2)){
            System.out.println("Hai vector bang nhau!");
        }
        else if(cungPhuong(vector1,vector2)){
            System.out.println("Hai vector cung phuong!");
        }
        System.out.println("Goc giua hai vector la: "+Math.toDegrees(goc(vector1,vector2))+"do");
        System.out.println("Module vector1 la: "+module(vector1));
        System.out.println("Module vector2 la: "+module(vector2));
        System.out.print("Tong 2 vector la vector: " );
        cong(vector1,vector2);
        System.out.print("Hieu 2 vector la vector: ");
        tru(vector1,vector2);
        System.out.println("Tich hai vector la: "+nhan(vector1,vector2));
    }
}
