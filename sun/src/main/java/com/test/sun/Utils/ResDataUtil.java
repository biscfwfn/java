package com.test.sun.Utils;

public class ResDataUtil {
    private String code = "0";
    private String message = "OK";
    private Object data;

    public ResDataUtil(Object data){
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}
