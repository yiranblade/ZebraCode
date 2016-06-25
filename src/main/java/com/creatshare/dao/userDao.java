package com.creatshare.dao;

import java.util.List;

import com.creatshare.model.user;

/**
 * @author 作者:yiranblade E-mail:
 * @date 创建时间：2016年5月22日 下午6:23:28
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
public interface userDao {

    /**
     * @Description (增添一条新记录)
     * @param user
     * @return
     */
    public boolean Adduser(user user);

    /**
     * @Description (删除已有的一条记录)
     * @param user
     * @return
     */
    public boolean Deleteuser(user user);

    /**
     * @Description (对原记录进行更新)
     * @param user
     * @return
     */
    public boolean Updateuser(user user);

    
   // public User findByID(String id);

    /**
     * @Description (验证用户是否存在，若存在则返回其所有相关记录)
     * @param checking
     * @return
     */
    public List<user> valitecoding(String checking);

}
