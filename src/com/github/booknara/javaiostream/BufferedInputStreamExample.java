package com.github.booknara.javaiostream;

import java.io.*;

/**
 * Created by Daehee Han(@daniel_booknara) on 2/23/16.
 * A FileInputStream obtains input bytes from a file in a file system. What files are available depends on the host environment.
 * FileInputStream is meant for reading streams of raw bytes such as image data. For reading streams of characters, consider using FileReader.
 */
public class BufferedInputStreamExample {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = null;
        BufferedInputStream bufferedInputStream = null;

        File inputFile = new File(".", "/src/com/github/booknara/javaiostream/test.txt");
        // Open input stream file
        inputStream = new FileInputStream(inputFile);

        // Convert to buffered input stream
        bufferedInputStream = new BufferedInputStream(inputStream);

        // Read a byte
        while (bufferedInputStream.available() > 0) {
            char c = (char)bufferedInputStream.read();

            System.out.println("Char : " + c);
        }

        bufferedInputStream.close();
        inputStream.close();
    }
}
