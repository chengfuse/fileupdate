package com.project.Controller;

import com.project.entity.Files;
import com.project.server.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    @Resource
    private FileService fileService;
    private final static String PATH = "D:\\Program Files\\IdeaPa\\fileupdate\\src\\main\\resources\\static\\img\\";
    @RequestMapping(value = "/fileup",method = RequestMethod.POST,
    headers = "Content-Type= multipart/form-data",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> fileUp(@RequestParam("file") MultipartFile file)throws  Exception {
        Map<String,String> fileup=new HashMap<String,String>();
        if(file.equals(null)){
            System.out.println("没有文件");
            fileup.put("fileup","没有文件");
        }
        String fileName=file.getOriginalFilename();
        String Suffix=fileName.substring(fileName.indexOf(".")+1);
        Date time=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
        fileName=format.format(time)+"."+Suffix;
        System.out.println("fileName");
        if(file.getSize()<=10485760){
            byte[] buffer=new byte[1024];
            InputStream in=file.getInputStream();
            int length=0;
            OutputStream savefile=new FileOutputStream(PATH+fileName);
            while((length=in.read(buffer))!=-1){
                savefile.write(buffer,0,length);
            }
            Files files=new Files();
            files.setfId(format.format(time));
            files.setfName(fileName);
            files.setfDate(time);
            files.setfPath(PATH+fileName);
            files.setfSize(file.getSize());
            fileService.addFile(files);
            in.close();
        }else{
            fileup.put("fileup","上传的文件过大");
        }
        fileup.put("fileup","上传成功");
        return fileup;
    }
    @RequestMapping(value = "/showfiles",method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Files> showFiles(){
        return fileService.findFiles();
    }
    @RequestMapping(value = "/delfile/{fId}",method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String,String> delFile(@PathVariable() long fId){
        Map<String,String> map=new HashMap<>();
        Files file= fileService.findFile(fId);
        if(file!=null){
            File f=new File(PATH+file.getfName());
            f.delete();
            fileService.removeFile(fId);
            map.put("del","yes");
        }else{
            map.put("del","no");
        }
        return map;
    }
}