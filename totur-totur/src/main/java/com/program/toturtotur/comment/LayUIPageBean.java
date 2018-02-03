package com.program.toturtotur.comment;

import java.io.Serializable;
import java.util.List;

/**
 * @author Li on 2018/2/2.
 */
public class LayUIPageBean<T> implements Serializable{
    private int code ;
    private String msg;
    private long count;
//    private Integer page;
//    private Integer limit;
    private List<T> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

//    public Integer getPage() {
//        return page;
//    }
//
//    public void setPage(Integer page) {
//        this.page = page;
//    }
//
//    public Integer getLimit() {
//        return limit;
//    }
//
//    public void setLimit(Integer limit) {
//        this.limit = limit;
//    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "LayUIPageBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
//                ", page=" + page +
//                ", limit=" + limit +
                ", data=" + data +
                '}';
    }
}
