package com.urise.webapp.sql;

import java.sql.*;

/**
 * @author Artyom Popov
 */
public interface SqlExecutor<T> {
    T execute(PreparedStatement st) throws SQLException;
}
