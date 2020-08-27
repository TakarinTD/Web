package lop.dagiac;

public class HV extends HCN{
    public HV () {
        this.soCanh=4;
        this.tenDaGiac="Hinh vuong";
        this.kichThuocCanh=new int[1];
    }

    protected void nhapCanh () {
        System.out.print("Nhap canh hinh vuong: ");
        this.kichThuocCanh[0]=scanner.nextInt();
    }

    protected int tinhCV(){
        return 4*this.kichThuocCanh[0];
    }

    protected int tinhDienTich(){
        return this.kichThuocCanh[0]*this.kichThuocCanh[0];
    }
}
