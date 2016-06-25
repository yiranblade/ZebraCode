package com.creatshare.controller;

import javax.servlet.http.Cookie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.creatshare.model.user;
import com.creatshare.util.ResultInfo;

/**
 * @author 作者:yiranblade E-mail:
 * @date 创建时间：2016年5月23日 下午5:35:07
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
public class UpdateController extends BaseController{

    private static Logger log = LoggerFactory.getLogger(UpdateController.class);
    /**
     * @Description (更新二维码，请求方法post)
     * @param id(更新二维码id，参数名称id)
     * @param text（更新的文本若为其他文件，则调用上传接口）
     * @return 成功返回json数据(二维码更新成功)失败返回json数据(二维码更新失败)
     */
    @RequestMapping(value="/doupdate",method=RequestMethod.POST,produces = "application/json; charset=UTF-8")
    public @ResponseBody Object updateCode(@RequestParam("id")String id,@RequestParam("text") String text){
        log.debug("process cookies:",request.getCookies().toString());
        if(request.getCookies()!=null){
            user user=new user();
            Cookie[] cookies=request.getCookies();
            for(Cookie cookie:cookies){
                String name=cookie.getName();
                String value=cookie.getValue();
                if(name.equals("log")){
                    user.setCookieid(value);
                    user.setId(id);
                    user.setContent(text);
                }
            }
            if(userService.UpdateCoder(user)){
            return JSON.toJSON(ResultInfo.CODE_UPDATE_SUCCESS);}
            else {
                return JSON.toJSON(ResultInfo.CODE_UPDATE_FAILD);
            }
        }
        return JSON.toJSON(ResultInfo.CODE_UPDATE_FAILD);
        
        
    }
    
}
