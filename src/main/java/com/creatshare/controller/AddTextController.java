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
 * @author 作者:yiranblade E-mail:
 * @date 创建时间：2016年5月23日 下午5:32:42
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
@Controller
public class AddTextController extends BaseController {

    private static Logger log = LoggerFactory.getLogger(AddTextController.class);

    /**
     * @Description (传递文本数据，请求方法post)
     * @param text(参数名为text，类型为String)
     * @return 成功返回json数据(活码创建成功)失败返回json数据(活码创建失败)
     */
    @RequestMapping(value = "/doaddtext", method = RequestMethod.POST,produces = "application/json; charset=UTF-8")
    public @ResponseBody Object addtext(@RequestParam("text") String text) {
        log.debug("Process Cookie", request.getCookies().toString());
        if (!text.isEmpty()) {
            user user = new user();
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                String value = cookie.getValue();
                System.out.println(name);
                if (name.equals("log")) {
                    user.setCookieid(value);
                    user.setContent(text);
                }
            }
            userService.AddnewCoder(user);
            return JSON.toJSON(ResultInfo.CODE_CREATE_SUCCESS);
        }else 
            return JSON.toJSON(ResultInfo.CODE_CREATE_FAILD);
        
        
    }

}
