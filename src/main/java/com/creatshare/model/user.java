package com.creatshare.model;

/**
 * @author 作者:yiranblade E-mail:
 * @date 创建时间：2016年5月22日 下午6:10:52
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
public class user {

    private String id;
    private String cookieid;

    public String getCookieid() {
        return cookieid;
    }

    public void setCookieid(String cookieid) {
        this.cookieid = cookieid;
    }

    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
