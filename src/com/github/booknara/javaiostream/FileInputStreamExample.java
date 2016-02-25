package com.github.booknara.javaiostream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Daehee Han(@daniel_booknara) on 2/23/16.
 * A FileInputStream obtains input bytes from a file in a file system. What files are available depends on the host environment.
 * FileInputStream is meant for reading streams of raw bytes such as image data. For reading streams of characters, consider using FileReader.
 */
public class FileInputStreamExample {
    public static void main(String[] args) throws IOException {
        int data;
        File inputFile = new File(".", "/src/com/github/booknara/javaiostream/test.txt");
        FileInputStream fileInput1 = new FileInputStream(inputFile);

        // Read a byte
        do {
            data = fileInput1.read();
            if (data != -1)
                System.out.print((char)data);
        } while (data != -1);

        fileInput1.close();

        System.out.println("------------------------------------");

        FileInputStream fileInput2 = new FileInputStream(inputFile);
        byte[] bytes = new byte[(int)inputFile.length()];

        // Read a byte array
        fileInput2.read(bytes);
        for(int i = 0; i < bytes.length; i++)
            System.out.print((char)bytes[i]);

        fileInput2.close();
    }
}
