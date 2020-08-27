package lop.dagiac;

import java.util.*;

public class DaGiac {
    protected int soCanh;
    protected int kichThuocCanh[];
    protected String tenDaGiac;
    Scanner scanner = new Scanner(System.in);

    public DaGiac() {
        this.soCanh = 0;
        this.kichThuocCanh = null;
    }

    public DaGiac (String tenDaGiac) {
        this.tenDaGiac = tenDaGiac;
    }

    public int getSoCanh () {
        return soCanh;
    }

    public void setSoCanh (int soCanh) {
        this.soCanh = soCanh;
    }

    public int[] getKichThuocCanh () {
        return kichThuocCanh;
    }

    public void setKichThuocCanh(int[] a) {
        this.kichThuocCanh = a;
    }

    public String getTenDaGiac () {
        return tenDaGiac;
    }

    public void setTenDaGiac (String tenDaGiac) {
        this.tenDaGiac = tenDaGiac;
    }

    protected void nhapDaGiac () {
        do {
            System.out.println("Nhap so canh: ");
            this.soCanh = scanner.nextInt();
        }
        while (this.soCanh <= 2);
        for (int i = 0; i < this.soCanh; i++) {
            System.out.println("Nhap canh thu " + (i + 1) + " :");
            this.kichThuocCanh[i] = scanner.nextInt();
        }
    }

    protected int tinhCV () {
        int cv = 0;
        for (int i = 0; i < this.soCanh; i++) {
            cv += this.kichThuocCanh[i];
        }
        return cv;
    }

    protected void xuatDaGiac () {
        System.out.print("Day la: "+tenDaGiac+", co "+soCanh+" canh, kich thuoc cac canh la: ");
        for (int i = 0; i < this.soCanh; i++) {
            System.out.print(this.kichThuocCanh[i]+" ");
        }
    }

}
