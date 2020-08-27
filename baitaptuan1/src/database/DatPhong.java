package database;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class DatPhong implements Options{
    private String maDatPhong, maPhong, maKH, ghiChu,trangThaiDat;
    private Calendar ngayDat;
    private Time gioBatDau, gioKetThuc;
    private int tienDatCoc;

    Scanner scanner=new Scanner(System.in);

    public DatPhong () {
    }

    public String getMaDatPhong () {
        return maDatPhong;
    }

    public void setMaDatPhong (String maDatPhong) {
        this.maDatPhong = maDatPhong;
    }

    public String getMaPhong () {
        return maPhong;
    }

    public void setMaPhong (String maPhong) {
        this.maPhong = maPhong;
    }

    public String getMaKH () {
        return maKH;
    }

    public void setMaKH (String maKH) {
        this.maKH = maKH;
    }

    public String getGhiChu () {
        return ghiChu;
    }

    public void setGhiChu (String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Calendar getNgayDat () {
        return ngayDat;
    }

    public void setNgayDat (int year, int month, int day) {
        Calendar ngayDat = Calendar.getInstance();
        ngayDat.set(year, month, day);
        this.ngayDat = ngayDat;
    }

    public Time getGioBatDau () {
        return gioBatDau;
    }

    public void setGioBatDau (int hour, int minute) {
        Time gioBatDau = new Time(hour, minute, 0);
        this.gioBatDau = gioBatDau;
    }

    public Time getGioKetThuc () {
        return gioKetThuc;
    }

    public void setGioKetThuc (int hour, int minute) {
        Time gioKetThuc = new Time(hour, minute, 0);
        this.gioKetThuc = gioKetThuc;
    }

    public int getTienDatCoc () {
        return tienDatCoc;
    }

    public void setTienDatCoc (int tienDatCoc) {
        this.tienDatCoc = tienDatCoc;
    }

    public String getTrangThaiDat () {
        return trangThaiDat;
    }

    public void setTrangThaiDat (String trangThaiDat) {
        this.trangThaiDat = trangThaiDat;
    }

    public void nhapThongTinDatPhong(){
        System.out.printf("Nhap ma dat phong: ");
        this.setMaDatPhong(scanner.nextLine());
        System.out.printf("Nhap ma phong: ");
        this.setMaPhong(scanner.nextLine());
        System.out.printf("Nhap ma khach hang: ");
        this.setMaKH(scanner.nextLine());
        System.out.printf("Nhap ngay dat (YYYY/MM/DD): ");
        this.setNgayDat(scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
        System.out.printf("Nhap gio bat dau (hh/mm): ");
        this.setGioBatDau(scanner.nextInt(),scanner.nextInt());
        System.out.printf("Nhap gio ket thuc (hh/mm): ");
        this.setGioKetThuc(scanner.nextInt(),scanner.nextInt());
        System.out.printf("Nhap tien dat coc: ");
        this.setTienDatCoc(scanner.nextInt());
        scanner.nextLine();
        System.out.printf("Nhap ghi chu neu co (khong co an enter): ");
        this.setGhiChu(scanner.nextLine());
        System.out.printf("Nhap trang thai dat: ");
        this.setTrangThaiDat(scanner.nextLine());
    }


    @Override
    public void insert (Connection conn) throws SQLException {
        String dp = " insert into karaoke.dat_phong (MaDatPhong, MaPhong, MaKH, NgayDat, GioBatDau, GioKetThuc, TienDatCoc, GhiChu, TrangThaiDat)"
                + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStmtDP = conn.prepareStatement(dp);
        System.out.printf("So don dat phong can them: ");
        int n = scanner.nextInt();
        if(n==0) System.out.println("Khong phong nao duoc dat them!");
        else {
            scanner.nextLine();
            for (int i = 1; i <= n; i++) {
                System.out.println("Nhap don dat phong thu " + i);
                this.nhapThongTinDatPhong();
                preparedStmtDP.setString(1, this.getMaDatPhong());
                preparedStmtDP.setString(2, this.getMaPhong());
                preparedStmtDP.setString(3, this.getMaKH());
                preparedStmtDP.setDate(4, new Date(this.getNgayDat().getTime().getTime()));
                preparedStmtDP.setTime(5, this.getGioBatDau());
                preparedStmtDP.setTime(6, this.getGioKetThuc());
                preparedStmtDP.setInt(7, this.getTienDatCoc());
                preparedStmtDP.setString(8, this.getGhiChu());
                preparedStmtDP.setString(9, this.getTrangThaiDat());
                try {
                    preparedStmtDP.execute();
                    System.out.println("Them thanh cong don dat phong " + i);
                } catch (Exception e) {
                    System.out.println("Loi vui long hap lai!");
                    i--;
                }
            }
        }
    }

    @Override
    public void update (Connection coon) {

    }

    @Override
    public void delete (Connection coon) {

    }

    @Override
    public void select (Connection conn) {

    }
}
