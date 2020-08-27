package database;

import java.sql.*;
import java.util.*;

public class Phong implements Options{
    private String maPhong,loaiPhong,moTa;
    private int soKhachToiDa,giaPhong;
    Scanner scanner=new Scanner(System.in);

    public Phong () {
    }

    public String getMaPhong () {
        return maPhong;
    }

    public void setMaPhong (String maPhong) {
        this.maPhong = maPhong;
    }

    public String getLoaiPhong () {
        return loaiPhong;
    }

    public void setLoaiPhong (String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public String getMoTa () {
        return moTa;
    }

    public void setMoTa (String moTa) {
        this.moTa = moTa;
    }

    public int getSoKhachToiDa () {
        return soKhachToiDa;
    }

    public void setSoKhachToiDa (int soKhachToiDa) {
        this.soKhachToiDa = soKhachToiDa;
    }

    public int getGiaPhong () {
        return giaPhong;
    }

    public void setGiaPhong (int giaPhong) {
        this.giaPhong = giaPhong;
    }

    public void nhapThongTinPhong(){
        System.out.printf("Nhap ma phong: ");
        this.setMaPhong(scanner.nextLine());
        System.out.printf("Nhap loai phong: ");
        this.setLoaiPhong(scanner.nextLine());
        System.out.printf("Nhap so khach toi da: ");
        this.setSoKhachToiDa(scanner.nextInt());
        System.out.printf("Nhap gia phong trong 1 gio: ");
        this.setGiaPhong(scanner.nextInt());
        scanner.nextLine();
        System.out.printf("Nhap mo ta neu co (khong co an enter): ");
        this.setMoTa(scanner.nextLine());
    }

    @Override
    public void insert (Connection conn) throws SQLException {
        String p = " insert into karaoke.phong (MaPhong, LoaiPhong, SoKhachToiDa, GiaPhong, Mota)"
                + " values (?, ?, ?, ?, ?)";
        PreparedStatement preparedStmtP = conn.prepareStatement(p);
        System.out.printf("So phong can them: ");
        int n = scanner.nextInt();
        if(n==0) System.out.println("Khong co phong duoc them!");
        else {
            scanner.nextLine();
            for (int i = 1; i <= n; i++) {
                System.out.println("Nhap phong thu " + i);
                this.nhapThongTinPhong();
                preparedStmtP.setString(1, this.getMaPhong());
                preparedStmtP.setString(2, this.getLoaiPhong());
                preparedStmtP.setInt(3, this.getSoKhachToiDa());
                preparedStmtP.setInt(4, this.getGiaPhong());
                preparedStmtP.setString(5, this.getMoTa());
                try {
                    preparedStmtP.execute();
                    System.out.println("Them thanh cong phong " + i);
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
