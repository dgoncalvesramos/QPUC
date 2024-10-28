package org.qpuc;

public class StringModifierService {
    public static String removeLanguageTag(String input) {
        if (input.contains("@")) {
            return input.substring(0, input.indexOf('@'));
        }
        return input;
    }

    public static String addUnderscoreBetweenBlanksAndPutItInUppercase(String input) {
        return input.replaceAll(" ", "_").toUpperCase();
    }
}
