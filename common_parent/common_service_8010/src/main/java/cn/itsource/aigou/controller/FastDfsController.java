package cn.itsource.aigou.controller;

import cn.itsource.aigou.util.AjaxResult;
import cn.itsource.aigou.utils.FastDfsApiOpr;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FastDfsController {

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public AjaxResult upload(@RequestParam(value = "file",required = true)MultipartFile file){
        try {
            System.out.println(file.getOriginalFilename() + ":" + file.getSize());
            String originalFilename = file.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
            System.out.println(extName);
            String filePath =  FastDfsApiOpr.upload(file.getBytes(), extName);
            return AjaxResult.me().setResultObj(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("上传失败!"+e.getMessage());
        }
    }

    @RequestMapping(value = "/del",method = RequestMethod.DELETE)
    public AjaxResult upload(@RequestParam(value = "filePath",required = true)String filePath){
        String pathTmp = filePath.substring(1);
        String groupName =  pathTmp.substring(0, pathTmp.indexOf("/"));
        String remotePath = pathTmp.substring(pathTmp.indexOf("/")+1);
        System.out.println(groupName);
        System.out.println(remotePath);
        FastDfsApiOpr.delete(groupName, remotePath);
        return  AjaxResult.me();
    }
}
