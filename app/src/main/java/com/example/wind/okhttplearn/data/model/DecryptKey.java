package com.example.wind.okhttplearn.data.model;

/**
 * Created by zlk on 2016/6/18.
 */
public class DecryptKey {


    /**
     * success : true
     * msg : 操作成功
     * obj : F514F01F74A493D83E71DF885E6F0D7DC914312FF173FF9FE350613A3819D90D
     */

    private boolean success;
    private String msg;
    private String obj;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getObj() {
        return obj;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }
}
