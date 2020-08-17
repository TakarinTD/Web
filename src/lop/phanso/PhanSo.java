package lop.phanso;

import java.util.*;

public class PhanSo {
    private int tuSo,mauSo;

    public PhanSo () {
    }

    public PhanSo (int tuSo, int mauSo) {
        this.tuSo = tuSo;
        this.mauSo = mauSo;
    }

    public int getTuSo () {
        return tuSo;
    }

    public void setTuSo (int tuSo) {
        this.tuSo = tuSo;
    }

    public int getMauSo () {
        return mauSo;
    }

    public void setMauSo (int mauSo) {
        this.mauSo = mauSo;
    }

    public void nhapPhanSo(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập tử số: ");
        this.setTuSo(scanner.nextInt());
        do{
            System.out.println("Mẫu số khác 0! Nhập mẫu số: ");
            this.setMauSo(scanner.nextInt());
        }while (this.getMauSo()==0);
    }

    public void inPhanSo(){
        System.out.println("Phân số: "+this.getTuSo()+"/"+this.getMauSo());
    }

    public PhanSo rutGon(){
        PhanSo rutGon=new PhanSo();
        int ts=this.getTuSo();
        int ms=this.getMauSo();
        while (ts != ms) {
            if (ts > ms) {
                ts -= ms;
            } else {
                ms -= ts;
            }
        }
        rutGon.setTuSo(this.getTuSo()/ts);
        rutGon.setMauSo(this.getMauSo()/ms);
        return rutGon;
    }

    public PhanSo nghichDao(){
        PhanSo ngichDao=new PhanSo();
        ngichDao.setTuSo(this.getMauSo());
        ngichDao.setMauSo(this.getTuSo());
        return ngichDao;
    }

    public PhanSo add(PhanSo soHang1,PhanSo soHang2){
        PhanSo tong=new PhanSo();
        tong.setTuSo(soHang1.getTuSo()*soHang2.getMauSo()+soHang1.getMauSo()*soHang2.getTuSo());
        tong.setMauSo(soHang1.getMauSo()*soHang2.getMauSo());
        tong.rutGon();
        return tong;
    }

    public PhanSo sub(PhanSo soHang1,PhanSo soHang2){
        PhanSo hieu=new PhanSo();
        hieu.setTuSo(soHang1.getTuSo()*soHang2.getMauSo()-soHang1.getMauSo()*soHang2.getTuSo());
        hieu.setMauSo(soHang1.getMauSo()*soHang2.getMauSo());
        hieu.rutGon();
        return hieu;
    }

    public PhanSo mul(PhanSo thuaSo1,PhanSo thuaSo2){
        PhanSo tich=new PhanSo();
        tich.setTuSo(thuaSo1.getTuSo()*thuaSo2.getTuSo());
        tich.setMauSo(thuaSo1.getMauSo()* thuaSo2.getMauSo());
        return tich;
    }

    public PhanSo div(PhanSo soBiChia,PhanSo soChia){
        PhanSo thuong=new PhanSo();
        thuong.setTuSo(soBiChia.getTuSo()*soChia.getMauSo());
        thuong.setMauSo(soBiChia.getMauSo()* soChia.getTuSo());
        return thuong;
    }
}
