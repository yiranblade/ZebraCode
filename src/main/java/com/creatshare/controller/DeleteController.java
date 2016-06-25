package com.creatshare.controller;

import javax.servlet.http.Cookie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.creatshare.model.user;
import com.creatshare.util.ResultInfo;

/** 
 * @author  作者:yiranblade E-mail: 
 * @date 创建时间：2016年5月23日 下午5:34:44 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
@Controller
public class DeleteController extends BaseController{
    private static Logger log=LoggerFactory.getLogger(DeleteController.class);
    /**
     * @Description (根据id删除对应二维码，请求方法GET)
     * @param id(参数名称id)
     * @return 成功返回json数据(二维码删除成功)失败返回json数据(二维码删除失败)
     */
    @RequestMapping(value="/dodelete",method=RequestMethod.GET,produces = "application/json; charset=UTF-8")
    public @ResponseBody Object DeleteCode(@RequestParam("id")String id){
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
                }
            }
            if(userService.deleteCoder(user))
            return JSON.toJSON(ResultInfo.CODE_DELETE_SUCCESS);
            else return JSON.toJSON(ResultInfo.CODE_DELETE_FAILD);
        }
        return JSON.toJSON(ResultInfo.CODE_DELETE_FAILD);
        
        
    }
    
    
}
