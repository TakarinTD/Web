package lop.dagiac;

public class HBH extends DaGiac{
    protected int chieuCao;
    protected int check;

    public HBH () {
        this.soCanh=4;
        this.tenDaGiac="Hinh binh hanh";
        this.kichThuocCanh=new int[2];
    }

    protected void nhapDaGiac () {
        for (int i = 0; i < 2; i++) {
            System.out.print("Nhập do dai thu " + (i + 1) + " :");
            this.kichThuocCanh[i] = scanner.nextInt();
        }
        System.out.print("Nhap chieu cao: ");
        this.chieuCao=scanner.nextInt();
        System.out.print("Chieu cao nay ung voi canh thu: ");
        this.check=scanner.nextInt();
    }

    protected int tinhCV(){
        return 2*(this.kichThuocCanh[0]+this.kichThuocCanh[1]);
    }

    protected int tinhDienTich(){
        if(check==1) return this.chieuCao*this.kichThuocCanh[0];
        return this.chieuCao*this.kichThuocCanh[1];
    }
    protected void xuatDaGiac () {
        System.out.print("Day la: "+tenDaGiac+","+" kich thuoc 2 canh la: ");
        for (int i = 0; i < 2; i++) {
            System.out.print(this.kichThuocCanh[i]+" ");
        }
    }
}
