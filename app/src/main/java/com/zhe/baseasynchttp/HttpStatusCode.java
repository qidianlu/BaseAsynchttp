package com.zhe.baseasynchttp;

/**
 * Created by zhangyr on 2016/6/2.
 */
public enum HttpStatusCode {
    STATUS_UNKNOWN,//未知错误
    STATUS_SUCCESS,//请求成功
    STATUS_MULTIPLE_CHOICE,//重定向
    STATUS_BAS_REQUEST,//客户端错误
    STATUS_SERVER_ERROR;//服务器错误
}
