package com.xuecheng.test.fastdfs;

import org.csource.fastdfs.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author Administrator
 * @version 1.0
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestFastDFS {

    //上传文件
    @Test
    public void testUpload() {

        try {
            //加载fastdfs配置文件
            ClientGlobal.initByProperties("config/fastdfs-client.properties");
            //定义TrackerClient,用于请求TrackerServer
            TrackerClient trackerClient = new TrackerClient();

            //链接tracker
            TrackerServer trackerServer = trackerClient.getConnection();
            //获取Stroage
            StorageServer storeStorage = trackerClient.getStoreStorage(trackerServer);

            //创建StroageClient
            StorageClient1 storageClient1 = new StorageClient1(trackerServer, storeStorage);
            //向stroage服务器上传文件
            //本地文件的路径
            String filePath = "c:/2.png";

            //上传成功后拿到文件id
            String fileId = storageClient1.upload_file1(filePath, "png", null);
            System.out.println(fileId);

//            group1/M00/00/00/wKgZg1yvP7OAMg0NAAA2oP2noV0576.png
        } catch (Exception e) {

        }


    }


    //下载文件
    @Test
    public void testDownload() {
        try {
            //加载fastdfs配置文件
            ClientGlobal.initByProperties("config/fastdfs-client.properties");

            TrackerClient trackerClient = new TrackerClient(); //定义TrackerClient,用于请求TrackerServer

            //链接tracker
            TrackerServer trackerServer = trackerClient.getConnection();
            //获取Stroage
            StorageServer storeStorage = trackerClient.getStoreStorage(trackerServer);

            //创建StroageClient
            StorageClient1 storageClient1 = new StorageClient1(trackerServer, storeStorage);
            //group1/M00/00/00/wKgZg1yvP7OAMg0NAAA2oP2noV0576.png
            //文件id
            String fileId = "group1/M00/00/00/wKgZg1yvP7OAMg0NAAA2oP2noV0576.png";
            byte[] bytes = storageClient1.download_file1(fileId);
            FileOutputStream fileOutputStream = new FileOutputStream(new File("c:/java/1.png"));
            fileOutputStream.write(bytes);
        } catch (Exception e) {

        }

    }


}
