package com.pangzi.vue_element_admin.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

public class ImgUtil {
    public static String saveImg(MultipartFile multipartFile,String path) throws IOException{
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();
        String oldName = multipartFile.getOriginalFilename();
        String fileName = UUID.randomUUID()+oldName.substring(oldName.lastIndexOf("."));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path+File.separator+fileName));
        byte[] bs = new byte[1024];
        int len;
        while(( len = fileInputStream.read(bs))!=-1){
            bos.write(bs,0,len);
        }
        bos.flush();
        bos.close();
        return fileName;
    }

    public static void deleteImg(String filePath) throws Exception{
        File file = new File(filePath);
        file.delete();
    }
}
