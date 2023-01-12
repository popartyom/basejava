package com.urise.webapp.util;

import java.time.*;

/**
 * @author Artyom Popov
 */
public class DateUtil {
    public static LocalDate of(int year, Month month) {
        return LocalDate.of(year, month, 1);
    }
}
