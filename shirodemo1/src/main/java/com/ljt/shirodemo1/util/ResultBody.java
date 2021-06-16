package com.ljt.shirodemo1.util;


import com.alibaba.fastjson.JSONObject;

/**
 * @author pancm
 * @Title: ResultBody
 * @Description: 返回格式
 * @Version:1.0.0
 * @date 2018年3月7日
 */
public class ResultBody {
    /**
     * 响应代码
     */
    private String errorCode;

    /**
     * 响应消息
     */
    private String errorMsg;

    /**
     * 响应结果
     */
    private Object data;

    public ResultBody() {
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String code) {
        this.errorCode = code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String message) {
        this.errorMsg = message;
    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 成功
     *
     * @return
     */
    public static ResultBody success() {
        return success(null);
    }

    /**
     * 成功
     *
     * @param data
     * @return
     */
    public static ResultBody success(Object data) {
        ResultBody rb = new ResultBody();
        rb.setErrorCode(Constants.SUCCESS_CODE);
        rb.setErrorMsg(Constants.SUCCESS_MSG);
        rb.setData(data);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultBody error(String code, String message) {
        ResultBody rb = new ResultBody();
        rb.setErrorCode(code);
        rb.setErrorMsg(message);
        rb.setData(null);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultBody error() {
        ResultBody rb = new ResultBody();
        rb.setErrorCode(Constants.FAILED_CODE);
        rb.setErrorMsg(Constants.FAILED_MSG);
        rb.setData(null);
        return rb;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}
