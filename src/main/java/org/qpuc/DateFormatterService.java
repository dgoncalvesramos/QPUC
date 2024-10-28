package org.qpuc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateFormatterService {
    public static String formatBirthDate(String dateTime) {
        // Remove any extra characters, quotes, or spaces
        String datePart = dateTime.replaceAll("[^0-9-]", "").substring(0, 10);
        LocalDate date = LocalDate.parse(datePart); // Parse cleaned date string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d 'of' MMMM 'in' yyyy", Locale.ENGLISH);
        return date.format(formatter);
    }
}
