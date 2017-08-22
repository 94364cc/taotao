package com.taotaio.util;

import com.taotao.pojo.Message;

import java.io.*;
import java.util.Random;

/**
 * Created by Administrator on 2017/8/17.
 */
public class FileUtil {

    //生成图片名字(防止重复)
    public static String getFileName(){
        //获取当前的时间戳
        long current=System.currentTimeMillis();
        //生成3个随机数
        Random random=new Random();
        int end=random.nextInt(999);
        //如果不足3位前面补0
        String fileName=current+String.format("%04d",end);
        return fileName;
    }

    //文件上传
    public static Message fileUpload(String fileName,FileInputStream inputStream,String directory) throws IOException {
        String path = directory+fileName;
        Message message =new Message();
        File file =new File(path);
        if (!file.exists()){
            file.createNewFile();
        }
        byte[] b=new byte[1024];//缓冲池
        BufferedInputStream bis=new BufferedInputStream(inputStream,2*1024);
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(file));
        int len=0;
        while((len=bis.read(b))!=-1){
            bos.write(b,0,len);
        }
        bis.close();
        bos.close();
        message.setResult(1);
        return message;
    }

    //测试文件上传
    public static void main(String[] args) {
        File file =new File("C:\\Users\\Administrator\\Desktop\\1.png");
        try {
            FileInputStream in=new FileInputStream(file);
            System.out.println(file.length());
            fileUpload(file.getName(),in,"D:\\");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
