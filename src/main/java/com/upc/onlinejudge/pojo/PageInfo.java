package com.upc.onlinejudge.pojo;

import java.io.Serializable;

/**
 * @author wangchunfei
 */
public class PageInfo implements Serializable {
    private static final long serialVersionUID = -5269285351698720358L;
    private int pageNum = 1;

    private int pageSize = 20;

    private int total;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }


    public PageInfo() {

    }
    public PageInfo(int pageNum,int pageSize) {
        if (pageNum<=0) {
            return;
        } else if(pageSize<=0) {
            return;
        } else {
            this.pageNum = pageNum;
            this.pageSize = pageSize;
        }
    }
    public PageInfo(int pageNum,int pageSize,int total) {
        if (pageNum<=0) {
            return;
        } else if(pageSize<=0) {
            return;
        } else {
            this.pageNum = pageNum;
            this.pageSize = pageSize;
            this.total = total;
        }
    }
}
