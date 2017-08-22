package com.taotao.controller;

import com.taotao.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2017/8/17.
 */
@Controller
@RequestMapping("/file")
public class FileControlelr {


    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String fileUpload(@RequestParam("file")MultipartFile file,HttpServletRequest request) throws IOException {
        String path=request.getSession().getServletContext().getRealPath("upload");
        System.out.println(path);
        String fileName=file.getOriginalFilename();
        File dir=new File(path,fileName);
        if(!dir.exists()){
            dir.mkdirs();
        }
        file.transferTo(dir);
        return "ok";
    }

    @RequestMapping("/")
    public String directToFileJsp(){
        return "file";
    }
}
