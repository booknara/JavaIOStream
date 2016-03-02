package com.github.booknara.javaiostream;

import java.io.*;

/**
 * Created by Daehee Han(@daniel_booknara) on 3/2/16.
 */
public class BufferBenchmark {
    public static void main(String[] args) {

        File source = new File(".", "test.txt");
        File target = new File(".", "test_copy.txt");

        if (!source.exists()) {
            System.out.println("A source file doesn't exist");
            return;
        }

        try {
            long startTime = System.currentTimeMillis();
            copyWithNonBuffer(source, target);
            long endTime = System.currentTimeMillis();

            System.out.println("Total non-buffer elapsed time : " + (endTime - startTime) + " milli seconds");

            startTime = System.currentTimeMillis();
            copyWithSmallBuffer(source, target);
            endTime = System.currentTimeMillis();

            System.out.println("Total small buffer elapsed time : " + (endTime - startTime) + " milli seconds");


            startTime = System.currentTimeMillis();
            copyWithDefaultBuffer(source, target);
            endTime = System.currentTimeMillis();

            System.out.println("Total default buffer elapsed time : " + (endTime - startTime) + " milli seconds");

            startTime = System.currentTimeMillis();
            copyWithFullBuffer(source, target);
            endTime = System.currentTimeMillis();

            System.out.println("Total full buffer elapsed time : " + (endTime - startTime) + " milli seconds");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void copyWithNonBuffer(File source, File target) throws IOException {
        InputStream in = null;
        OutputStream out = null;

        try {
            in = new FileInputStream(source);
            out = new FileOutputStream(target);

            while (true) {
                int byteDate = in.read();

                if (byteDate == -1)
                    break;

                out.write(byteDate);
            }

        } finally {
            if (in != null) in.close();
            if (out != null) out.close();
        }
    }

    private static void copyWithSmallBuffer(File source, File target) throws IOException {
        final int BUFFER_SIZE = 2048;

        InputStream inBuffer = null;
        OutputStream outBuffer = null;

        try {
            InputStream in = new FileInputStream(source);
            inBuffer = new BufferedInputStream(in, BUFFER_SIZE);
            OutputStream out = new FileOutputStream(target);
            outBuffer = new BufferedOutputStream(out, BUFFER_SIZE);

            while (true) {
                int byteDate = inBuffer.read();

                if (byteDate == -1)
                    break;

                outBuffer.write(byteDate);
            }

        } finally {
            if (inBuffer != null) inBuffer.close();
            if (outBuffer != null) outBuffer.close();
        }
    }

    private static void copyWithDefaultBuffer(File source, File target) throws IOException {
        InputStream inBuffer = null;
        OutputStream outBuffer = null;

        try {
            InputStream in = new FileInputStream(source);
            inBuffer = new BufferedInputStream(in);
            OutputStream out = new FileOutputStream(target);
            outBuffer = new BufferedOutputStream(out);

            while (true) {
                int byteDate = inBuffer.read();

                if (byteDate == -1)
                    break;

                outBuffer.write(byteDate);
            }

        } finally {
            if (inBuffer != null) inBuffer.close();
            if (outBuffer != null) outBuffer.close();
        }
    }


    private static void copyWithFullBuffer(File source, File target) throws IOException {
        InputStream in = null;
        OutputStream out = null;

        try {
            in = new FileInputStream(source);
            out = new FileOutputStream(target);
            int size = in.available();
            byte[] buffer = new byte[size];

            int byteDate = in.read(buffer);
            out.write(buffer);

        } finally {
            if (in != null) in.close();
            if (out != null) out.close();
        }
    }

}
