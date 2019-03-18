package com.test.sun.ExceptionHandling;

/**
 * Spring 对于 RuntimeException类的异常才会进行事务回滚
 */
public class UserDefinedException extends RuntimeException {
    private String code;
    private String message;

    public UserDefinedException(UserDefinedException e){
        this.code = e.code;
        this.message = e.message;
    }
    public UserDefinedException(String code, String message) {
        this.code = code;
        this.message = message;
    }
    public UserDefinedException(ErrorCode obj){
        this.code = obj.getCode();
        this.message = obj.getMessage();
    }
    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }
}
