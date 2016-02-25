package com.github.booknara.javaiostream;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Daehee Han(@daniel_booknara) on 2/23/16.
 * A ByteArrayInputStream contains an internal buffer that contains bytes that may be read from the stream. An internal counter keeps track of the next byte to be supplied by the read method.
 * Closing a ByteArrayInputStream has no effect. The methods in this class can be called after the stream has been closed without generating an IOException.
 */
public class ByteArrayInputStreamExample {
    public static void main(String[] args) throws IOException {
        byte[] buffer = new byte[20];
        Random rand = new Random();

        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = (byte) rand.nextInt();
        }

        ByteArrayInputStream inputStream = new ByteArrayInputStream(buffer);

        int num;
        while ((num = inputStream.read()) != -1) {
            System.out.print(num + " ");
        }

        inputStream.close();
    }
}
