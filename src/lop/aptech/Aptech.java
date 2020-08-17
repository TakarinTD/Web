package lop.aptech;

public class Aptech {
    private String khoaHoc;
    private double diemTongKet;
    private boolean viPhamNoiQuy;//false không vi phạm, true v phạm
    private double tbSoLanThi;//Tính trung bình số lần thi của những kỳ thi đã tham gia

    public String getKhoaHoc () {
        return khoaHoc;
    }

    public void setKhoaHoc (String khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

    public double getDiemTongKet () {
        return diemTongKet;
    }

    public void setDiemTongKet (double diemTongKet) {
        this.diemTongKet = diemTongKet;
    }

    public boolean isViPhamNoiQuy () {
        return viPhamNoiQuy;
    }

    public void setViPhamNoiQuy (boolean viPhamNoiQuy) {
        this.viPhamNoiQuy = viPhamNoiQuy;
    }

    public double getTbSoLanThi () {
        return tbSoLanThi;
    }

    public void setTbSoLanThi (double tbSoLanThi) {
        this.tbSoLanThi = tbSoLanThi;
    }
    public boolean kiemTraHocBong(){
        if(this.getKhoaHoc().equals("HDSE")&&this.getDiemTongKet()>=0.75&&this.isViPhamNoiQuy()==false&&this.getTbSoLanThi()==1.0) return true;
        else return false;
    }
}
