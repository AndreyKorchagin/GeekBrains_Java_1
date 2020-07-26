package com.korchagin.courses.task15;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws IOException {
//        searchWordInText("Abc");
        mergeFiles();
        searchFiles();
    }

    public static int searchWordInText(String template) throws IOException {
        Path path = Paths.get("1.txt");
        int count = 0;
        byte[] l = template.getBytes(StandardCharsets.US_ASCII);

        RandomAccessFile aFile = new RandomAccessFile(path.toFile(), "r");
        FileChannel inChannel = aFile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(1024);
        int byteRead = inChannel.read(buf);


        while (byteRead != -1){
            buf.flip();
            while (buf.hasRemaining()){
                System.out.println((char)buf.get());
                int tick = buf.position();
                if(tick < buf.limit() - l.length) {
                    for (int i = 0; i < l.length; i++) {
                        if (buf.get() != l[i]) {
                            break;
                        }
                        if (i == l.length - 1) {
                            count++;
                        }
                    }
                    buf.position(tick++);
                } else {
                    buf.compact();
                    break;
                }
            }
            buf.clear();
            byteRead = inChannel.read(buf);

        }
        aFile.close();
        return count;
    }

    public static void mergeFiles() throws IOException {
        Path path1 = Paths.get("2/");
        Path path2 = Paths.get("2/out.txt");

        if (Files.isDirectory(path1)) {
            DirectoryStream<Path> files = Files.newDirectoryStream(path1);
            RandomAccessFile out = new RandomAccessFile(path2.toFile(), "rw");
            FileChannel outChannel = out.getChannel();

            for (Path file : files) {
                RandomAccessFile in = new RandomAccessFile(path2.toFile(), "rw");
                FileChannel inChannel = in.getChannel();
                ByteBuffer buf = ByteBuffer.allocate(1024);
                int byteRead = inChannel.read(buf);
                while (byteRead != -1) {
                    System.out.println(buf.get());
                    buf.flip();
                    outChannel.write(buf);
                    buf.clear();
                    byteRead = inChannel.read(buf);
                }
            }
        }
    }

    public static void searchFiles() {
        Path catalog = Paths.get("3");
        List<Path> result = new ArrayList<>();
        if (Files.isDirectory(catalog)) {
            try {
                Files.walkFileTree(catalog, new FileVisitor<>() {
                    @Override
                    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        if (Files.size(file) <= 102400) {
                            result.add(file);
                        }
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult visitFileFailed(Path file, IOException exc) {
                        return FileVisitResult.TERMINATE;
                    }

                    @Override
                    public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
                        return FileVisitResult.CONTINUE;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(result);
    }
}
