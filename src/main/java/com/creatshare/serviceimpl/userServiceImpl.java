package com.creatshare.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creatshare.daoimpl.userDaoimpl;
import com.creatshare.model.user;
import com.creatshare.service.userService;

/**
 * @author 作者:yiranblade E-mail:
 * @date 创建时间：2016年5月23日 下午5:22:00
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
@Service
public class userServiceImpl implements userService {

    userDaoimpl usr;
    @Autowired
    public void setUsr(userDaoimpl usr) {
        this.usr = usr;
    }

    public boolean AddnewCoder(user user) {
        // TODO Auto-generated method stub
        if(user!=null){
            usr.Adduser(user);
            
            return true;
        }else{
            return false;
        }
    }

    public boolean deleteCoder(user user) {
        // TODO Auto-generated method stub
        if(user!=null){
            return usr.Deleteuser(user);
            
        }else{
            return false;
        }
    }

    public boolean UpdateCoder(user user) {
        // TODO Auto-generated method stub
        if(user!=null){
            return usr.Updateuser(user);
        }else{
            return false;
        }
    }

    public List<user> valiteCoder(String checking) {
        // TODO Auto-generated method stub
        if(checking!=null){
            List<user> user =usr.valitecoding(checking);
            return user;
        }
        return null;
    }

}
