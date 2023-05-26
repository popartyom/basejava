package com.urise.webapp.util;

import java.time.*;

/**
 * @author Artyom Popov
 */
public class DateUtil {

    public static final LocalDate NOW = LocalDate.of(3000, 1, 1);

    public static LocalDate of(int year, Month month) {
        return LocalDate.of(year, month, 1);
    }
}
