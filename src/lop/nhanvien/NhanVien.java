package lop.nhanvien;

import java.util.*;

public class NhanVien {

    private String tenNhanVien,diaChi;
    private int tuoi;
    private double tienLuong, soGioLam;

    public NhanVien(){}

    public NhanVien (String tenNhanVien, String diaChi, int tuoi, double tienLuong, double soGioLam) {
        this.tenNhanVien = tenNhanVien;
        this.diaChi = diaChi;
        this.tuoi = tuoi;
        this.tienLuong = tienLuong;
        this.soGioLam = soGioLam;
    }

    public String getTenNhanVien () {
        return tenNhanVien;
    }

    public void setTenNhanVien (String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public int getTuoi () {
        return tuoi;
    }

    public void setTuoi (int tuoi) {
        this.tuoi = tuoi;
    }

    public String getDiaChi () {
        return diaChi;
    }

    public void setDiaChi (String diaChi) {
        this.diaChi = diaChi;
    }

    public double getTienLuong () {
        return tienLuong;
    }

    public void setTienLuong (double tienLuong) {
        this.tienLuong = tienLuong;
    }

    public double getSoGioLam () {
        return soGioLam;
    }

    public void setSoGioLam (double soGioLam) {
        this.soGioLam = soGioLam;
    }

    public void inputInfo(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập thông tin nhân viên: ");
        System.out.println("Họ và tên: ");
        String tenNhanVien=scanner.nextLine();
        this.setTenNhanVien(tenNhanVien);
        System.out.println("Địa chỉ: ");
        String diaChi=scanner.nextLine();
        this.setDiaChi(diaChi);
        System.out.println("Tuổi: ");
        int tuoi=scanner.nextInt();
        this.setTuoi(tuoi);
        System.out.println("Tiền Lương: ");
        double tienLuong=scanner.nextDouble();
        this.setTienLuong(tienLuong);
        System.out.println("Số giờ làm: ");
        double soGioLam=scanner.nextDouble();
        this.setSoGioLam(soGioLam);
    }
    public void printInfo(){
        System.out.println("Thông tin nhân viên: ");
        System.out.println("Họ và tên: "+this.getTenNhanVien());
        System.out.println("Địa chỉ: "+this.getDiaChi());
        System.out.println("Tuổi: "+this.getTuoi());
        System.out.println("Tiền Lương: "+this.getTienLuong());
        System.out.println("Số giờ làm: "+this.getSoGioLam());
    }
    public double tinhThuong(){
        if(this.getSoGioLam()<100) return 0;
        else if(this.getSoGioLam()<200) return this.getTienLuong()*0.1;
        else return this.getTienLuong()*0.2;
    }

    public static void main (String[] args) {
        NhanVien nv = new NhanVien();
    }
}
