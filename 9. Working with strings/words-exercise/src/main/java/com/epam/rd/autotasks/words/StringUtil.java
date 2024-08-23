package com.epam.rd.autotasks.words;
import java.util.Arrays;

public class StringUtil {
    public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) {
        //throw new UnsupportedOperationException();
        if (words == null || sample == null || words.length == 0) {
            return 0;
        }
        sample = sample.trim().toLowerCase();
        int count = 0;
        for (String word : words) {
            if (word.trim().toLowerCase().equals(sample)) {
                count++;
            }
        }
        return count;
    }

    public static String[] splitWords(String text) {
        //throw new UnsupportedOperationException();
        if (text == null || text.trim().isEmpty()) {
            return null;
        }

        text = text.replaceAll("[,.;:!?]", " ");
        String[] words = text.trim().split("\\s+");

        if (words.length == 0 || (words.length == 1 && words[0].isEmpty())) {
            return null;
        }
        return words;
    }

    public static String convertPath(String path, boolean toWin) {
        if (path == null || path.isEmpty() || isInvalidPath(path)) {
            return null;
        }

        if (toWin) {
            if (path.equals("~")) {
                return "C:\\User";
            } else if (path.startsWith("~")) {
                return "C:\\User" + path.substring(1).replace("/", "\\");
            } else if (path.startsWith("/")) {
                return "C:" + path.replace("/", "\\");
            } else {
                return path.replace("/", "\\");
            }
        } else {
            if (path.equals("C:\\User")) {
                return "~";
            } else if (path.startsWith("C:\\User")) {
                return "~/" + path.substring(8).replace("\\", "/");
            } else if (path.startsWith("C:\\")) {
                return "/" + path.substring(3).replace("\\", "/");
            } else {
                return path.replace("\\", "/");
            }
        }
    }

    private static boolean isInvalidPath(String path) {
        if (path == null || path.isEmpty()) {
            return true;
        }
        if (path.chars().filter(ch -> ch == '~').count() > 1) {
            return true;
        }
        if (path.contains("~") && !path.startsWith("~") && path.contains("/")) {
            return true;
        }
        if (path.contains("/") && path.contains("\\")) {
            return true;
        }
        if (path.contains("C:") && (path.indexOf("C:") != 0 || path.indexOf("C:") != path.lastIndexOf("C:"))) {
            return true;
        }
        if (path.contains("C:") && (path.contains("/") || path.contains("~"))) {
            return true;
        }
        if (path.contains("//") || path.contains("\\\\") || path.contains("~~")) {
            return true;
        }
        if (path.contains("~\\") || path.contains("\\~")) {
            return true;
        }
        if (path.contains("C:\\") && path.indexOf("C:\\") != 0) {
            return true;
        }
        if (path.contains("C:") && path.startsWith("/")) {
            return true;
        }
        return false;
    }

    public static String joinWords(String[] words) {
        //throw new UnsupportedOperationException();
        if (words == null || words.length == 0) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        boolean first = true;
        for (String word : words) {
            if (word != null && !word.isEmpty()) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append(word);
                first = false;
            }
        }
        sb.append("]");
        return sb.length() > 2 ? sb.toString() : null;
    }

    public static void main(String[] args) {
        System.out.println("Test 1: countEqualIgnoreCaseAndSpaces");
        String[] words = new String[]{" WordS    \t", "words", "w0rds", "WOR  DS", };
        String sample = "words   ";
        int countResult = countEqualIgnoreCaseAndSpaces(words, sample);
        System.out.println("Result: " + countResult);
        int expectedCount = 2;
        System.out.println("Must be: " + expectedCount);

        System.out.println("Test 2: splitWords");
        String text = "   ,, first, second!!!! third";
        String[] splitResult = splitWords(text);
        System.out.println("Result : " + Arrays.toString(splitResult));
        String[] expectedSplit = new String[]{"first", "second", "third"};
        System.out.println("Must be: " + Arrays.toString(expectedSplit));

        System.out.println("Test 3: convertPath");
        String unixPath = "/some/unix/path";
        String convertResult = convertPath(unixPath, true);
        System.out.println("Result: " + convertResult);
        String expectedWinPath = "C:\\some\\unix\\path";
        System.out.println("Must be: " + expectedWinPath);

        System.out.println("Test 4: joinWords");
        String[] toJoin = new String[]{"go", "with", "the", "", "FLOW"};
        String joinResult = joinWords(toJoin);
        System.out.println("Result: " + joinResult);
        String expectedJoin = "[go, with, the, FLOW]";
        System.out.println("Must be: " + expectedJoin);
    }
}