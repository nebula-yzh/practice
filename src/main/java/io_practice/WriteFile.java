package io_practice;

import java.io.*;
import java.util.List;

/**
 * @author yingzhihao
 * @date 2022/8/27 17:13
 * @description: TODO
 */
public class WriteFile {

    public static void writeFileContentByByte(String filePath, byte[] buffered) throws IOException {
        //字节流
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        //使用缓冲区读取文件数据
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        bufferedOutputStream.write(buffered, 0, buffered.length);
        fileOutputStream.close();
        bufferedOutputStream.close();
    }

    public static void writeFileContentByStr(String filePath, List<String> list) throws IOException {
        //字符流
        FileWriter fileWriter = new FileWriter(filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(list.toString(), 0, list.toString().length());
        bufferedWriter.close();
        fileWriter.close();
    }
}
