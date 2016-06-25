package com.creatshare.controller;

import javax.servlet.http.Cookie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.creatshare.util.ResultInfo;
import com.creatshare.util.UUIDGenerator;

/**
 * @author 作者:yiranblade E-mail:
 * @date 创建时间：2016年5月23日 下午5:36:07
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
@Controller
public class ValiteAndShowController extends BaseController {

    private static Logger log = LoggerFactory.getLogger(ValiteAndShowController.class);

    /**
     * @Description (根据用户cookie获取其所有二维码数据)
     * @return json格式的数组(若用户活码对应为图片等，传回文本形式地址)
     */
    @RequestMapping(value = "/doValite",method = RequestMethod.GET,produces = "application/json; charset=UTF-8")
    public @ResponseBody Object valiteshow(){
        log.debug("Process Cookie",request.getCookies().toString());
        ResultInfo resultinfo=new ResultInfo();
        if(request.getCookies()!=null){
            Cookie[] cookies=request.getCookies();
            for(Cookie cookie:cookies){
                String name=cookie.getName();
                String log=cookie.getValue();
                if(name.equals("log")){
                    resultinfo.setData(userService.valiteCoder(log));
                    break;
                }
            }
            if(resultinfo.getData()!=null){
                return JSON.toJSON(resultinfo);
            }else{
            String log=UUIDGenerator.getUUID();
            Cookie cookie=new Cookie(log,log);
            cookie.setMaxAge(7*24*60*60);
            response.addCookie(cookie);
            return JSON.toJSON(ResultInfo.USER_NOT_FOUND);
            }
            
        }else{
            String log=UUIDGenerator.getUUID();
            Cookie cookie=new Cookie("log",log);
            cookie.setMaxAge(60 * 60 * 24 * 365);
            response.addCookie(cookie);
            return JSON.toJSON(ResultInfo.USER_NOT_FOUND);
        }
        
        
        
        
    }
    
}
