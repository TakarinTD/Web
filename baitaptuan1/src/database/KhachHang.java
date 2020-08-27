package database;

import java.sql.*;
import java.util.*;

public class KhachHang implements Options {
    private String MaKH, TenKH, DiaChi;
    private int SDT;
    Scanner scanner = new Scanner(System.in);

    public KhachHang () {
    }

    public String getMaKH () {
        return MaKH;
    }

    public void setMaKH (String maKH) {
        MaKH = maKH;
    }

    public String getTenKH () {
        return TenKH;
    }

    public void setTenKH (String tenKH) {
        TenKH = tenKH;
    }

    public String getDiaChi () {
        return DiaChi;
    }

    public void setDiaChi (String diaChi) {
        DiaChi = diaChi;
    }

    public int getSDT () {
        return SDT;
    }

    public void setSDT (int SDT) {
        this.SDT = SDT;
    }

    public void nhapThongTinKhachHang () {
        System.out.printf("Nhap ma khach hang: ");
        this.setMaKH(scanner.nextLine());
        System.out.print("Nhap ten khach hang: ");
        this.setTenKH(scanner.nextLine());
        System.out.printf("Nhap dia chi khach hang: ");
        this.setDiaChi(scanner.nextLine());
        System.out.printf("Nhap sdt khach hang: ");
        this.setSDT(scanner.nextInt());
        scanner.nextLine();
    }

    @Override
    public void insert (Connection conn) throws SQLException {
        String kh = " insert into karaoke.khach_hang (MaKH, TenKH, DiaChi, SoDT)"
                + " values (?, ?, ?, ?)";
        PreparedStatement preparedStmtKH = conn.prepareStatement(kh);
        System.out.printf("So khach hang can them: ");
        int n = scanner.nextInt();
        if (n == 0) System.out.println("Khong co khach hang duoc them!");
        else {
            scanner.nextLine();
            for (int i = 1; i <= n; i++) {
                System.out.println("Nhap thong tin khach hang thu " + i);
                this.nhapThongTinKhachHang();
                preparedStmtKH.setString(1, this.getMaKH());
                preparedStmtKH.setString(2, this.getTenKH());
                preparedStmtKH.setString(3, this.getDiaChi());
                preparedStmtKH.setInt(4, this.getSDT());
                try {
                    preparedStmtKH.execute();
                    System.out.println("Them thanh cong khach hang " + i);
                } catch (Exception e) {
                    System.out.println("Loi vui long nhap lai!");
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
