package database;

import java.sql.*;
import java.util.*;

public class DichVuDiKem implements Options{
    private String MaDV,TenDV,DonViTinh;
    private int DonGia;
    Scanner scanner=new Scanner(System.in);

    public DichVuDiKem () {
    }

    public String getMaDV () {
        return MaDV;
    }

    public void setMaDV (String maDV) {
        MaDV = maDV;
    }

    public String getTenDV () {
        return TenDV;
    }

    public void setTenDV (String tenDV) {
        TenDV = tenDV;
    }

    public String getDonViTinh () {
        return DonViTinh;
    }

    public void setDonViTinh (String donViTinh) {
        DonViTinh = donViTinh;
    }

    public int getDonGia () {
        return DonGia;
    }

    public void setDonGia (int donGia) {
        DonGia = donGia;
    }

    public void nhapDichVuDiKem(){
        System.out.printf("nhap ma dich vu: ");
        this.setMaDV(scanner.nextLine());
        System.out.printf("Nhap ten dich vu: ");
        this.setTenDV(scanner.nextLine());
        System.out.printf("Nhap don vi tinh: ");
        this.setDonViTinh(scanner.nextLine());
        System.out.printf("Nhap don gia: ");
        this.setDonGia(scanner.nextInt());
        scanner.nextLine();
    }

    @Override
    public void insert (Connection conn) throws SQLException {
        String dvdk = " insert into karaoke.dich_vu_di_kem (MaDV, TenDV, DonViTinh, DonGia)"
                + " values (?, ?, ?, ?)";
        PreparedStatement preparedStmtDVDK = conn.prepareStatement(dvdk);
        System.out.printf("So dich vu can them: ");
        int n = scanner.nextInt();
        if(n==0) System.out.println("Khong co dich vu nao duoc them!");
        else {
            scanner.nextLine();
            for (int i = 1; i <= n; i++) {
                System.out.println("Nhap dich vu thu " + i);
                this.nhapDichVuDiKem();
                preparedStmtDVDK.setString(1, this.getMaDV());
                preparedStmtDVDK.setString(2, this.getTenDV());
                preparedStmtDVDK.setString(3, this.getDonViTinh());
                preparedStmtDVDK.setInt(4, this.getDonGia());
                try {
                    preparedStmtDVDK.execute();
                    System.out.println("Them thanh cong dich vu " + i);
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
