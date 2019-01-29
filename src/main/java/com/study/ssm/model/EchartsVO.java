package com.study.ssm.model;

import java.util.List;

/**
 * @ClassName EchartsVO
 * @Description TODO
 * @Author DuJian
 * @Date 2019/1/29 14:40
 **/
public class EchartsVO<T,V> {
    //表中的x轴类别
    private List<T> xAxisCategory;
    //表中的数据
    private List<V> datas;

    public EchartsVO() {
    }
    public EchartsVO(List<T> xAxisCategory, List<V> datas) {
        this.xAxisCategory = xAxisCategory;
        this.datas = datas;
    }

    public List<T> getxAxisCategory() {
        return xAxisCategory;
    }

    public void setxAxisCategory(List<T> xAxisCategory) {
        this.xAxisCategory = xAxisCategory;
    }

    public List<V> getDatas() {
        return datas;
    }

    public void setDatas(List<V> datas) {
        this.datas = datas;
    }
}
