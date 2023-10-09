package com.urise.webapp.sql;

import java.sql.*;

/**
 * @author Artyom Popov
 */
public interface SqlTransaction<T> {
    T execute(Connection conn) throws SQLException;
}
