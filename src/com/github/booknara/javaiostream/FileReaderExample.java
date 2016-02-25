package com.github.booknara.javaiostream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Daehee Han(@daniel_booknara) on 2/23/16.
 * Convenience class for reading character files. The constructors of this class assume that the default character encoding and the default byte-buffer size are appropriate.
 * To specify these values yourself, construct an InputStreamReader on a FileInputStream.
 * FileReader is meant for reading streams of characters. For reading streams of raw bytes, consider using a FileInputStream.
 */
public class FileReaderExample {
    public static void main(String[] args) throws IOException {
        int data;
        File inputFile = new File(".", "/src/com/github/booknara/javaiostream/test.txt");
        FileReader fileInput1 = new FileReader(inputFile);

        // Read a byte
        do {
            data = fileInput1.read();
            if (data != -1)
                System.out.print((char)data);
        } while (data != -1);

        fileInput1.close();

        System.out.println("------------------------------------");

        FileReader fileInput2 = new FileReader(inputFile);
        char[] characters = new char[(int)inputFile.length()];

        // Read a byte array
        fileInput2.read(characters);
        for(int i = 0; i < characters.length; i++)
            System.out.print(characters[i]);

        fileInput2.close();
    }
}
