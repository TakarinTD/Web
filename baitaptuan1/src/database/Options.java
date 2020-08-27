package database;

import java.sql.*;

public interface Options {
    void insert(Connection conn) throws SQLException;
    void update(Connection conn);
    void delete(Connection conn);
    void select(Connection conn);
}
