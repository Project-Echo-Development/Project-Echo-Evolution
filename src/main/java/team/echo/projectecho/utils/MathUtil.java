package team.echo.projectecho.utils;

import java.util.Random;

public class MathUtil {

    public static int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
