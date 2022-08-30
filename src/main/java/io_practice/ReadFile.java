package io_practice;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author yingzhihao
 * @date 2022/8/27 16:40
 * @description: 文件操作
 */
public class ReadFile {
    public static void main(String[] args) throws IOException {
        //File dir = new File("D:\\BaiduNetdiskDownload\\深入设计模式.pdf");
        //listAllFiles(dir);
        //readFileContentByStr("D:\\BaiduNetdiskDownload\\深入设计模式.pdf");
        String readFilePath = "D:\\BaiduNetdiskDownload\\read.txt";
        String writeFilePath = "D:\\BaiduNetdiskDownload\\wirte.txt";
        //byte[] bytes = readFileContentByByte(readFilePath);
        //WriteFile.writeFileContentByByte(writeFilePath, bytes);
        List<String> strings = readFileContentByStr(readFilePath);
        strings.forEach(System.out::println);
        WriteFile.writeFileContentByStr(writeFilePath, strings);

    }

    /**
     * 递归打印目录下所有文件
     *
     * @param dir
     */
    public static void listAllFiles(File dir) {
        if (dir == null || !dir.exists()) {
            return;
        }
        if (dir.isFile()) {
            System.out.println(dir.getName());
            return;
        }
        //递归打印文件名
        for (File file : Objects.requireNonNull(dir.listFiles())) {
            listAllFiles(file);
        }
    }

    public static List<String> readFileContentByStr(String filePath) throws IOException {
        //字符流
        FileReader fileReader = new FileReader(filePath);
        //使用缓冲区读取文件数据
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str;
        List<String> list = new ArrayList<>();
        while ((str = bufferedReader.readLine()) != null) {
            list.add(str);
        }
        fileReader.close();
        bufferedReader.close();
        return list;
    }


    public static byte[] readFileContentByByte(String filePath) throws IOException {
        //字节流
        FileInputStream fileInputStream = new FileInputStream(filePath);
        //使用缓冲区读取文件数据
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        byte[] buffer = new byte[1024];
        //while (bufferedInputStream.read(buffer,0,buffer.length) != -1){
        //    System.out.println(Arrays.toString(buffer));
        //}
        bufferedInputStream.read(buffer, 0, buffer.length);
        bufferedInputStream.close();
        fileInputStream.close();
        return buffer;
    }


}
