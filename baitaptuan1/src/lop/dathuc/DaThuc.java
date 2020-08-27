package lop.dathuc;

import java.util.*;

public class DaThuc {
    private double heSo[];
    private int bac;

    DaThuc () {
    }

    DaThuc (int m) {
        bac = m;
        heSo = new double[bac + 1];
    }

    DaThuc (double m[]) {
        bac = m.length-1;
        heSo = new double[bac + 1];
        heSo = m;
    }

    public void nhapDaThuc () {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap bac cua da thuc: ");
        bac = scanner.nextInt();

        heSo = new double[bac + 1];
        for (int i = 0; i <= bac; i++) {
            System.out.print("Nhap he so cua bac " + i + " : ");
            heSo[i] = scanner.nextInt();

        }
    }

    public void inDaThuc () {
        System.out.print(heSo[0]);
        for (int i = 1; i <= bac; i++) {
            System.out.print("+(" + heSo[i] + ")x^" + i);
        }
    }

    public DaThuc congDaThuc (DaThuc d1) {
        DaThuc d;
        int i, j;
        if (bac > d1.bac) {
            d = new DaThuc(bac);
            for (i = 0; i <= d1.bac; i++) {
                d.heSo[i] = heSo[i] + d1.heSo[i];
            }
            for (j = i; j <= bac; j++) {
                d.heSo[j] = heSo[j];
            }
        } else {
            d = new DaThuc(d1.bac);
            for (i = 0; i <= bac; i++)
                d.heSo[i] = heSo[i] + d1.heSo[i];
            for (j = i; j <= d1.bac; j++)
                d.heSo[j] = d1.heSo[j];
        }
        return d;

    }

    public DaThuc truDaThuc (DaThuc d1) {
        DaThuc d;
        int i, j;
        if (bac > d1.bac) {
            d = new DaThuc(bac);
            for (i = 0; i <= d1.bac; i++)
                d.heSo[i] = heSo[i] - d1.heSo[i];
            for (j = i; j <= bac; j++)
                d.heSo[j] = heSo[j];
        } else {
            d = new DaThuc(d1.bac);
            for (i = 0; i <= bac; i++)
                d.heSo[i] = heSo[i] - d1.heSo[i];
            for (j = i; j <= d1.bac; j++)
                d.heSo[j] = -d1.heSo[j];
        }
        return d;
    }

    public DaThuc nhanDaThuc (DaThuc d1) {
        DaThuc d;
        int k = d1.bac+bac;
        d = new DaThuc(k);
        for (int i = 0; i <= bac; i++) {
            for (int j = 0; j <= d1.bac; j++) {
                d.heSo[i + j] += heSo[i] * d1.heSo[j];
            }
        }
        return d;
    }

    public void chiaDaThuc (DaThuc d1) {
        DaThuc kq, sc, sbc, du;
        du = new DaThuc();
        sc = new DaThuc(heSo);
        sbc = new DaThuc(d1.heSo);
        if (sc.bac < sbc.bac) System.out.println("Bac cua so chia nho hon so bi chia");
        else {
            kq = new DaThuc(sc.bac - sbc.bac);
            int i=kq.bac;
            while (sc.bac >= sbc.bac) {
                kq.heSo[i] = sc.heSo[sc.bac] / sbc.heSo[sbc.bac];
                DaThuc tich =new DaThuc(i);
                tich.heSo[i]=kq.heSo[i];
                du = tich.nhanDaThuc(sbc);
                sc = sc.truDaThuc(du);
                sc.bac--;
                i--;
            }
            System.out.print("Thuong 2 da thuc la: ");
            kq.inDaThuc();
            System.out.print(" với số dư ");
            sc.inDaThuc();
            System.out.println();
        }

    }

    public static void main (String[] args) {
        DaThuc dt1 = new DaThuc();
        DaThuc dt2 = new DaThuc();

        System.out.println("Nhap da thuc 1");
        dt1.nhapDaThuc();
        System.out.println("Nhap da thuc 2");
        dt2.nhapDaThuc();

        System.out.print("Da thuc 1: ");
        dt1.inDaThuc();
        System.out.print("\nDa thuc 2:");
        dt2.inDaThuc();
        System.out.print("\nTong 2 da thuc la da thuc:");
        DaThuc tong;
        tong = dt1.congDaThuc(dt2);
        tong.inDaThuc();
        System.out.print("\nHieu  2 da thuc la da thuc:");
        DaThuc hieu;
        hieu = dt1.truDaThuc(dt2);
        hieu.inDaThuc();
        System.out.print("\nTich 2 da thuc la da thuc:");
        DaThuc tich;
        tich = dt1.nhanDaThuc(dt2);
        tich.inDaThuc();
        System.out.println();
        dt1.chiaDaThuc(dt2);
    }
}
