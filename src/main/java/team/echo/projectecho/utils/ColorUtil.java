package team.echo.projectecho.utils;

public class ColorUtil {

    public static String formatColor(String text, String... colors) {
        return String.join("", colors) + text;
    }
}
