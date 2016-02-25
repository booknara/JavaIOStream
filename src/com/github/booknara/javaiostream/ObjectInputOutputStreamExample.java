package com.github.booknara.javaiostream;

import java.io.*;

/**
 * Created by Daehee Han(@daniel_booknara) on 2/23/16.
 * An ObjectInputStream deserializes primitive data and objects previously written using an ObjectOutputStream.
 */
public class ObjectInputOutputStreamExample {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person(1234, "John", "US");

        System.out.println("person object" + person.toString());
        FileOutputStream fileOutputStream = new FileOutputStream("person.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(person);

        objectOutputStream.flush();
        objectOutputStream.close();
        fileOutputStream.close();

        Person copyPerson;
        FileInputStream fileInputStream = new FileInputStream("person.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        copyPerson = (Person) objectInputStream.readObject();

        System.out.println("copied person object" + copyPerson.toString());
        objectInputStream.close();
        fileInputStream.close();
    }
}
