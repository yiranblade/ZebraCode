package com.creatshare.util;

/**
 * @author 作者:yiranblade E-mail:
 * @date 创建时间：2016年5月24日 下午9:04:34
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
public class ResultInfo {

    public static final String FILE_UPLOAD_SUCCESS = "文件上传成功";
    public static final String CODE_CREATE_SUCCESS = "活码制作成功";
    public static final String CODE_DELETE_SUCCESS = "二维码删除成功";
    public static final String CODE_UPDATE_SUCCESS = "二维码更新成功";
    public static final String FILE_UPLOAD_FAILD = "文件上传失败";
    public static final String CODE_CREATE_FAILD = "活码制作失败";
    public static final String CODE_DELETE_FAILD = "二维码删除失败";
    public static final String CODE_UPDATE_FAILD = "二维码更新失败";
    public static final String USER_NOT_FOUND = "请新创建一个活码吧^_^";

    private int code;

    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
