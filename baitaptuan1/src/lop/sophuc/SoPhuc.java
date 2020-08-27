package lop.sophuc;

import java.util.*;

public class SoPhuc {
    private double phanThuc, phanAo;

    public double getPhanThuc () {
        return phanThuc;
    }

    public void setPhanThuc (double phanThuc) {
        this.phanThuc = phanThuc;
    }

    public double getPhanAo () {
        return phanAo;
    }

    public void setPhanAo (double phanAo) {
        this.phanAo = phanAo;
    }

    public static SoPhuc cong (SoPhuc soPhuc1, SoPhuc soPhuc2) {
        SoPhuc soPhuc = new SoPhuc();
        soPhuc.setPhanThuc(soPhuc1.getPhanThuc() + soPhuc2.getPhanThuc());
        soPhuc.setPhanAo(soPhuc1.getPhanAo() + soPhuc2.getPhanAo());
        return soPhuc;
    }

    public static SoPhuc tru (SoPhuc soPhuc1, SoPhuc soPhuc2) {
        SoPhuc soPhuc = new SoPhuc();
        soPhuc.setPhanThuc(soPhuc1.getPhanThuc() - soPhuc2.getPhanThuc());
        soPhuc.setPhanAo(soPhuc1.getPhanAo() - soPhuc2.getPhanAo());
        return soPhuc;
    }

    public static SoPhuc nhan (SoPhuc soPhuc1, SoPhuc soPhuc2) {
        SoPhuc soPhuc = new SoPhuc();
        soPhuc.setPhanThuc(soPhuc1.getPhanThuc() * soPhuc2.getPhanThuc() - soPhuc1.getPhanAo() * soPhuc2.getPhanAo());
        soPhuc.setPhanAo(soPhuc1.getPhanAo() * soPhuc2.getPhanThuc() + soPhuc2.getPhanAo() * soPhuc1.getPhanThuc());
        return soPhuc;
    }

    public static SoPhuc chia (SoPhuc soPhuc1, SoPhuc soPhuc2) {
        SoPhuc soPhuc = new SoPhuc();
        soPhuc.setPhanThuc((soPhuc1.getPhanThuc() * soPhuc2.getPhanThuc() + soPhuc1.getPhanAo() * soPhuc2.getPhanAo()) / (soPhuc1.getPhanThuc() * soPhuc1.getPhanThuc() + soPhuc1.getPhanAo() * soPhuc1.getPhanAo()));
        soPhuc.setPhanAo((soPhuc1.getPhanThuc() * soPhuc2.getPhanAo() - soPhuc2.getPhanThuc() * soPhuc1.getPhanAo()) / (soPhuc1.getPhanThuc() * soPhuc1.getPhanThuc() + soPhuc1.getPhanAo() * soPhuc1.getPhanAo()));
        return soPhuc;
    }

    public void nhapSoPhuc () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập phần thực: ");
        this.setPhanThuc(scanner.nextDouble());
        System.out.println("Nhập phần ảo: ");
        this.setPhanAo((scanner.nextDouble()));
    }

    public void inSoPhuc () {
        if (this.getPhanAo() < 0)
            System.out.println("" + this.getPhanThuc() + this.getPhanAo() + "i");
        else System.out.println( this.getPhanThuc() + "+" + this.getPhanAo() + "i");
    }

    public static void main (String[] args) {
        SoPhuc soPhuc1 = new SoPhuc();
        SoPhuc soPhuc2 = new SoPhuc();
        System.out.println("Nhập số phức 1:");
        soPhuc1.nhapSoPhuc();
        System.out.println("Nhập số phức 2:");
        soPhuc2.nhapSoPhuc();
        System.out.print("Tổng 2 số phức: ");
        SoPhuc.cong(soPhuc1,soPhuc2).inSoPhuc();
        System.out.print("Hiệu 2 số phức: ");
        SoPhuc.tru(soPhuc1,soPhuc2).inSoPhuc();
        System.out.print("Tích 2 số phức: ");
        SoPhuc.nhan(soPhuc1,soPhuc2).inSoPhuc();
        System.out.print("Thương 2 số phức: ");
        SoPhuc.chia(soPhuc1,soPhuc2).inSoPhuc();
    }
}
