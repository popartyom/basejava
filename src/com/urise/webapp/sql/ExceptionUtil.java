package com.urise.webapp.sql;

import com.urise.webapp.exception.*;
import org.postgresql.util.*;

import java.sql.*;

/**
 * @author Artyom Popov
 */
public class ExceptionUtil {
    private ExceptionUtil() {
    }

    public static StorageException convertException(SQLException e) {
        if (e instanceof PSQLException) {
            if (e.getSQLState().equals("23505")) {
                return new ExistStorageException(null);
            }
        }
        return new StorageException(e);
    }
}
