package com.cj.utils;

import java.io.Serializable;
import java.util.List;

public class PageBean<T> implements Serializable{
    //当前的页数
    private Integer curPage;
    //总页数 需要计算出来（不用set）
    private Integer amountPages;
    //总记录数
    private Integer totalRecords;
    //每页显示的条数
    private Integer pageSize = 10;
    //每页显示的数据
    private List<T> data;

    public Integer getCurPage() {
        return curPage;
    }

    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }

    public Integer getAmountPage() {
        return amountPages;
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
        amountPages=totalRecords%pageSize==0?totalRecords/pageSize:totalRecords/pageSize+1;//计算出总页数
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}

