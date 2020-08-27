package database;

import java.sql.*;
import java.util.*;

public class ChiTietSuDungDichVu implements Options{
    private String maDatPhong,maDichvu;
    private int soLuong;
    Scanner scanner=new Scanner(System.in);

    public ChiTietSuDungDichVu () {
    }

    public String getMaDatPhong () {
        return maDatPhong;
    }

    public void setMaDatPhong (String maDatPhong) {
        this.maDatPhong = maDatPhong;
    }

    public String getMaDichvu () {
        return maDichvu;
    }

    public void setMaDichvu (String maDichvu) {
        this.maDichvu = maDichvu;
    }

    public int getSoLuong () {
        return soLuong;
    }

    public void setSoLuong (int soLuong) {
        this.soLuong = soLuong;
    }

    public void nhapChiTietSuDungDichVu(){
        System.out.printf("Nhap ma dat phong: ");
        this.setMaDatPhong(scanner.nextLine());
        System.out.printf("Nhap ma dich vu: ");
        this.setMaDichvu(scanner.nextLine());;
        System.out.printf("Nhap so luong: ");
        this.setSoLuong(scanner.nextInt());
        scanner.nextLine();
    }

    @Override
    public void insert (Connection conn) throws SQLException {
        String ctsddv = " insert into karaoke.chi_tiet_su_dung_dich_vu (MaDatPhong, MaDV, SoLuong)"
                + " values (?, ?, ?)";
        PreparedStatement preparedStmtCTSDDV = conn.prepareStatement(ctsddv);
        System.out.printf("So dich vu su dung can them: ");
        int n = scanner.nextInt();
        if(n==0) System.out.println("Khong co dich vu nao duoc su dung!");
        else {
            scanner.nextLine();
            for (int i = 1; i <= n; i++) {
                System.out.println("Nhap dich vu su dung thu " + i);
                this.nhapChiTietSuDungDichVu();
                preparedStmtCTSDDV.setString(1, this.getMaDatPhong());
                preparedStmtCTSDDV.setString(2, this.getMaDichvu());
                preparedStmtCTSDDV.setInt(3, this.getSoLuong());
                try {
                    preparedStmtCTSDDV.execute();
                    System.out.println("Them thanh cong dich vu su dung " + i);
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
