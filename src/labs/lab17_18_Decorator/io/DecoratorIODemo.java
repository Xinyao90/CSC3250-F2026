package io;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/** Optional library example: no files or network connections are needed. */
public class DecoratorIODemo {
    public static void main(String[] args) throws IOException {
        byte[] bytes = {0, 0, 0, 42};
        try (DataInputStream input = new DataInputStream(
                new BufferedInputStream(new ByteArrayInputStream(bytes)))) {
            System.out.println(input.readInt());
        }
    }
}
