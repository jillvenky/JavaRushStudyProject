package com.savitski.thinkingInJava.chapter_16.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by esavitski on 20.01.2017.
 */
public class GetChannel {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = consoleReader.readLine();
        consoleReader.close();

        FileChannel fc = new FileOutputStream(fileName).getChannel();


        fc.write(ByteBuffer.wrap(("This question has been asked before and already has an answer. " +
                "If those answers do not fully address your question, please ask a new question. ").getBytes()));
        fc.close();

        /*fc = new RandomAccessFile(fileName, "rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("New text".getBytes()));
        fc.close();*/

        fc = new RandomAccessFile(fileName, "rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap(("\nIf you want to show duration time in seconds, you must divide the value by 1'000'000'000. " +
                "Or if you want a Date object: Date myTime = new Date(duration / 1000);\n" +
                "You can then access the various methods of Date to print number of minutes, hours, etc.").getBytes()));
        fc.close();

        /*fc = new RandomAccessFile(fileName, "r").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("New text".getBytes()));
        fc.close();*/

        /*fc = new FileOutputStream(fileName).getChannel();
        fc.position(0);
        fc.write(ByteBuffer.wrap("New text\\n".getBytes()));
        fc.close();*/



        fc = new FileInputStream(fileName).getChannel();
        /*ByteBuffer buff = ByteBuffer.allocate(2048);*/
        ByteBuffer buff = ByteBuffer.allocateDirect(2048);
        long startTime = System.currentTimeMillis();
        fc.read(buff);
        buff.flip();
        while (buff.hasRemaining()){
            System.out.print((char)buff.get());
        }
        fc.close();
        long endTime = System.currentTimeMillis();
        System.out.println("\n" + (endTime - startTime) );
    }
}
