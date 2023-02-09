package data.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface DB {
    Connection getConnection () throws SQLException,ClassNotFoundException;

    Connection createConnection () throws SQLException ,ClassNotFoundException;


}
