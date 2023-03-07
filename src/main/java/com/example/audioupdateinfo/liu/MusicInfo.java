package com.example.audioupdateinfo.liu;

import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.Mp3File;

import java.io.File;

/**
 * @author liushuaibiao
 * @date 2023/3/7 15:53
 */
public class MusicInfo {

    public static void main(String[] args) throws Exception {

        String path = "D:\\JAVA";        //要遍历的路径
        File file = new File(path);        //获取其file对象
        File[] fs = file.listFiles();    //遍历path下的文件和目录，放在File数组中
        for (File f : fs) {                    //遍历File[]数组
            if (!f.isDirectory()) {
                System.out.println(f.getName());
            }
        }

        Mp3File mp3file = new Mp3File("/Users/liushuaibiao/Desktop/1.mp3");

        if (mp3file.hasId3v2Tag()) {
            mp3file.removeId3v1Tag();
        }
        if (mp3file.hasId3v2Tag()) {
            mp3file.removeId3v2Tag();
        }
        if (mp3file.hasCustomTag()) {
            mp3file.removeCustomTag();
        }
//        // 将ID3信息去除，并保存到一个新文件
        mp3file.save("/Users/liushuaibiao/Desktop/去除ID3后.mp3");
    }

}
