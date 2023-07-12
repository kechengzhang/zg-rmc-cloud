package com.zgtec.zgrmc.controller;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author zkc
 * @description
 * @Date 2023/4/24 23:58 星期一
 * @Version 1.0
 */
public class Test1 implements Runnable{
    private List<String> list ;
    private String outputDir ;
    private String outputFile ;
    public Test1(List<String> list,String outputDir,String outputFile){
        this.list=list;
        this.outputDir=outputDir;
        this.outputFile=outputFile;
    }
    private static final String ffmpegPath = "D:\\aaaa\\ffmpeg.exe";
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public void run() {
        try {
            String format1 = "%s -i %s -c copy -bsf:v h264_mp4toannexb -f mpegts %s";
//            String format1 = "%s -i %s -c copy -bsf:v h264_mp4toannexb -f mpegts  %s";
            String command1 = String.format(format1, ffmpegPath, list.get(0), outputDir + "input1.ts");
            String command2 = String.format(format1, ffmpegPath, list.get(1), outputDir + "input2.ts");
            String command4 = String.format(format1, ffmpegPath, list.get(2), outputDir + "input3.ts");

            String format3 = "%s -i \"concat:%s|%s|%s\" -c copy -bsf:a aac_adtstoasc -movflags +faststart %s";
//            String format3 = "%s -i \"concat:%s|%s\" -c copy -bsf:a aac_adtstoasc -movflags +faststart %s";
            String command3 = String.format(format3, ffmpegPath, outputDir + "input1.ts", outputDir + "input2.ts", outputDir + "input3.ts",outputFile);

            if (execCommand(command1) > 0 && execCommand(command2) >  0&& execCommand(command4) >  0 && execCommand(command3) > 0) {
                File file1 = new File(outputDir + "input1.ts");
                File file2 = new File(outputDir + "input2.ts");
                File file3 = new File(outputDir + "input3.ts");
                file1.delete();
                file2.delete();
                file3.delete();
                return ;
            } else {
                return ;
            }
        } catch (Exception e) {
            e.printStackTrace();
//            System.out.println("-----合并失败!!!!!!" + outputFile);
            return ;
        }
    }

    private static Integer execCommand(String command) {
        try {
            Process process = Runtime.getRuntime().exec(command);
            //获取进程的标准输入流
            final InputStream is1 = process.getInputStream();
            //获取进城的错误流
            final InputStream is2 = process.getErrorStream();
            //启动两个线程，一个线程负责读标准输出流，另一个负责读标准错误流
            readInputStream(is1);
            readInputStream(is2);
            process.waitFor();
            process.destroy();
            System.out.println("-----操作成功" + command + " " + sdf.format(new Date()));
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("-----操作失败" + command);
            return -1;
        }
    }

    private static void readInputStream(InputStream inputStream) {
        new Thread(() -> {
            BufferedReader br1 = new BufferedReader(new InputStreamReader(inputStream));
            try {
                String line1 = null;
                while ((line1 = br1.readLine()) != null) {
                    if (line1 != null) {
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}