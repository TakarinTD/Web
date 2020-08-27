package database;

import java.sql.*;
import java.util.*;

public class ConnectDatabaseKaraoke {
    private static String DB_URL = "jdbc:mysql://localhost:3306/karaoke";
    private static String USER_NAME = "root";
    private static String PASSWORD = "123456";

    public static void main (String[] args) {
        KhachHang khachHang = new KhachHang();
        ChiTietSuDungDichVu chiTietSuDungDichVu = new ChiTietSuDungDichVu();
        DichVuDiKem dichVuDiKem = new DichVuDiKem();
        Phong phong = new Phong();
        DatPhong datPhong = new DatPhong();
        Scanner scanner = new Scanner(System.in);
        try {
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            phong.insert(conn);
            dichVuDiKem.insert(conn);
            khachHang.insert(conn);
            datPhong.insert(conn);
            chiTietSuDungDichVu.insert(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static Connection getConnection (String dbUrl, String userName, String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbUrl, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }

    private static void select(Connection conn,String field,String table,String where) throws SQLException {
        String query=" select "+field+" from "+table+" where "+where;
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        ResultSet rs=preparedStmt.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                                       + "  " + rs.getString(3));
        }
    }
}
