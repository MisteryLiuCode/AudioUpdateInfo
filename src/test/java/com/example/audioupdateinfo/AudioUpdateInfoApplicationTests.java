package com.example.audioupdateinfo;

import com.mpatric.mp3agic.Mp3File;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
class AudioUpdateInfoApplicationTests {

    @Test
    void contextLoads() {
    }
    
    /**
     * description: 遍历文件夹
     * 
     * @param
     * @return 
     */
    @Test
    public void getFile() throws Exception{
        String path = "/Users/liushuaibiao/Documents/文稿 - 刘帅彪的MacBook Pro/其他/051 吴军 数学通识50讲【完结】";        //要遍历的路径
        File file = new File(path);        //获取其file对象
        File[] fs = file.listFiles();    //遍历path下的文件和目录，放在File数组中
        for (File f : fs) {                    //遍历File[]数组
            if (!f.isDirectory()
            && f.getName().contains("mp3")) {
                System.out.println(f.getName());
                Mp3File mp3file = new Mp3File(f);
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
                mp3file.save("/Users/liushuaibiao/Documents/文稿 - 刘帅彪的MacBook Pro/其他/吴军数学通识(终版)/"+f.getName());
            }
        }
    }

}
