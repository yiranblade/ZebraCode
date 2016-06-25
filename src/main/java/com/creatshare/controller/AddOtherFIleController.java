package com.creatshare.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.Cookie;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.creatshare.model.user;
import com.creatshare.util.ResultInfo;

/**
 * @author 作者:yiranblade E-mail:
 * @date 创建时间：2016年5月23日 下午5:33:33
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
@Controller
public class AddOtherFIleController extends BaseController {

    private static Logger log = LoggerFactory.getLogger(AddOtherFIleController.class);
    /**
     * @Description (传递任何一个非文本文件，请求方法post)
     * @param file（参数名为file）
     * @return 成功返回JSON格式(文件上传成功)失败返回JSON格式(文件上传失败)
     * @throws IOException
     */
    @RequestMapping(value = "/doUpload", method = RequestMethod.POST,produces = "application/json; charset=UTF-8")
    public @ResponseBody Object uploadfile(@RequestParam("file") MultipartFile file) throws IOException {
        if(!file.isEmpty()){
            String filename=System.currentTimeMillis()+file.getOriginalFilename();
            user user=new user();
            if(request.getCookies()!=null){
                Cookie[] cookies=request.getCookies();
                for(Cookie cookie:cookies){
                    String name=cookie.getName();
                    String value=cookie.getValue();
                    if(name.equals("log")){
                        user.setCookieid(value);;
                        user.setContent("/resoueces"+filename);
                        log.debug("Process file()",file.getOriginalFilename());
                        FileUtils.copyInputStreamToFile(file.getInputStream(), new File(request.getSession().getServletContext().getRealPath("/resources"),filename));
                        
                        userService.AddnewCoder(user);
                    }
                }
            }
           
        }else{
            return JSON.toJSON(ResultInfo.FILE_UPLOAD_FAILD);
        }
        return JSON.toJSON(ResultInfo.FILE_UPLOAD_SUCCESS);
        

    }

}
