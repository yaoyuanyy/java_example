package com.yy.example.java.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Description:
 * <pre>
 * https://www.happycoders.eu/java/filechannel-bytebuffer-memory-mapped-file-locks/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-11-11 at 16:51
 */
public class C2_FileChannelTest {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("test", "tt.log");
        System.out.println(path.toAbsolutePath());
        FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ);

        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        int count = fileChannel.read(byteBuffer);
        System.out.println(count);
    }
}
