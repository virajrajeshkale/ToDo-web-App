package com.lcwd.ToDoManager.Controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.Arrays;

@RestController
@RequestMapping("/file")
public class FileController {

    Logger logger = LoggerFactory.getLogger(FileController.class);
    @PostMapping("/single")
    public  String uploadsinglefile(@RequestParam("image") MultipartFile file)
    {
        logger.info("File Name : {}",file.getName());
        logger.info("Content  Type :{}",file.getContentType());
        logger.info("File Orignal Name :{}",file.getOriginalFilename());
        logger.info("File Size :{}",file.getSize());

            return "File Test";
    }

    //method for upload multiple file
    @PostMapping("/multiple")
    public  String uploadMultiplefile(@RequestParam("files") MultipartFile[] files)
    {
        Arrays.stream(files).forEach(file -> {
            logger.info("File Name :{}",file.getName());
            logger.info("File Content :{}",file.getContentType());
            logger.info("File Size :{}",file.getSize());
        });

        return "Handled Multiple files...";
    }

    //method for send image from server to user

    @GetMapping("receive-image")
    public void  sendimage(HttpServletResponse response)
    {
            try{
                InputStream  fileinputStream = new FileInputStream("Images/background.jpg");
                response.setContentType(MediaType.IMAGE_JPEG_VALUE);
                StreamUtils.copy(fileinputStream,response.getOutputStream());
            }catch (Exception e)
            {
                e.printStackTrace();
            }
    }
}
