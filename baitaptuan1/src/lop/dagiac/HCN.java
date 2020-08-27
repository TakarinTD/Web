package lop.dagiac;

public class HCN extends HBH {
    public HCN () {
        this.soCanh=4;
        this.tenDaGiac="Hinh chu nhat";
        this.kichThuocCanh=new int[2];
    }

    protected void nhapCanh () {
        for (int i = 0; i < 2; i++) {
            System.out.print("Nhap do dai thu " + (i + 1) + " :");
            this.kichThuocCanh[i] = scanner.nextInt();
        }
    }

    protected int tinhDienTich(){
        return this.kichThuocCanh[0]*this.kichThuocCanh[1];
    }
}
