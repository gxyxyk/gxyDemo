package com.exception;

/**
 * 自定义异常类
 */
public class SysException extends Exception {
// serialVersionUID 的作用 Java序列化是将一个对象编码成一个字节流，
// 反序列化将字节流编码转换成一个对象。
// 序列化是Java中实现持久化存储的一种方法；为数据传输提供了线路级对象表示法。
    private static final long serialVersionUID = 4055945147128016300L;
    //异常提示信息
    private String message;
    public String getMessage(){
        return message;
    }
    public void setMessage(String  message){
        this.message = message;
    }
    public SysException(String message){
        this.message = message;
    }
}
