package ua.hillel.springcoredemo.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestUtil {
    public static String readFromFile(String fileName) {
        InputStream in = TestUtil.class.getClassLoader().getResourceAsStream(fileName);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
        return bufferedReader.lines().reduce((val, acc) -> val + acc).orElse("{}");
    }
}
