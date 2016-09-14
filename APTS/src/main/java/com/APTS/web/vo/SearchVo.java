package com.APTS.web.vo;

import java.sql.Date;

/**
 * Created by Ruanjianhong on 2016/9/2.
 */
public class SearchVo {

    private Integer type;
    private Integer corp;
    private Integer batch;
    private Date logmin;
    private Date logmax;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCorp() {
        return corp;
    }

    public void setCorp(Integer corp) {
        this.corp = corp;
    }

    public Integer getBatch() {
        return batch;
    }

    public void setBatch(Integer batch) {
        this.batch = batch;
    }

    public Date getLogmin() {
        return logmin;
    }

    public void setLogmin(Date logmin) {
        this.logmin = logmin;
    }

    public Date getLogmax() {
        return logmax;
    }

    public void setLogmax(Date logmax) {
        this.logmax = logmax;
    }

}
