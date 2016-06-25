package com.creatshare.service;

import java.util.List;

import com.creatshare.model.user;

/**
 * @author 作者:yiranblade E-mail:
 * @date 创建时间：2016年5月23日 下午5:19:08
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
public interface userService {

    public boolean AddnewCoder(user user);

    public boolean deleteCoder(user user);

    public boolean UpdateCoder(user user);

    public List<user> valiteCoder(String checking);

}
