package com.program.tutorcommon.dto;

import com.program.tutorcommon.enums.StateEnum;

import java.io.Serializable;

/**
 * @author Li on 2018/2/2.
 */
public class TutorResult implements Serializable {
    /**
     * 响应业务状态
     */
    private Integer status;

    /**
     * 返回的数据
     */
    private Object data;

    /**
     * 错误信息
     */
    private String error;

    /**
     * 返回总页数
     */
    private long pageSize;

    /**
     * 本页返回数量
     */
    private Integer total;


    /**
     * 请求成功
     *
     * @param status
     */
    public TutorResult(Integer status) {
        this.status = status;
    }

    /**
     * 请求成功并携带数据
     * @param status
     * @param data
     */
    public TutorResult(Integer status, Object data) {
        this.status = status;
        this.data = data;
    }

    /**
     * 请求成功并携带参数和页数
     * @param status
     * @param data
     * @param pageSize
     * @param total
     */
    public TutorResult(Integer status, Object data, long pageSize, Integer total) {
        this.status = status;
        this.data = data;
        this.pageSize = pageSize;
        this.total = total;
    }

    /**
     * 请求失败
     * @param status
     * @param error
     */
    public TutorResult(Integer status, String error) {
        this.status = status;
        this.error = error;
    }

    public static TutorResult ok(){
        return new TutorResult(StateEnum.SUCCESS.getState());
    }

    public static TutorResult ok(Object data){
        return new TutorResult(StateEnum.SUCCESS.getState(),data);
    }

    public static TutorResult warn(String warn){
        return new TutorResult(StateEnum.WARN.getState(),warn);
    }

    public static TutorResult error(String error){
        return new TutorResult(StateEnum.ERROR.getState(),error);
    }

    public static TutorResult ok(Object data,long pageSize,Integer total){
        return new TutorResult(StateEnum.SUCCESS.getState(),data,pageSize,total);
    }
}
