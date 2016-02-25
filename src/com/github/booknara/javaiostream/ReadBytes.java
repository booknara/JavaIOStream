package com.github.booknara.javaiostream;

import java.io.IOException;

/**
 * Created by Daehee Han(@daniel_booknara) on 2/23/16.
 */
public class ReadBytes {
    public static void main(String[] args) throws IOException {
        byte data[] = new byte[10];

        System.out.print("Enter some characters : ");
        System.in.read(data);
        System.out.print("Entered characters : ");

        for(int i = 0; i < data.length; i++) {
            System.out.print((char) data[i]);
        }

        System.out.println();
        System.out.print("Done");
    }
}
