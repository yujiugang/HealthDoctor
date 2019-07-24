package com.example.base.model.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * <p>文件描述：<p>
 * <p>作者：liudada<p>
 * <p>创建时间：2019/7/23<p>
 */
@Entity
public class SreachHistoryDaoBean {
    @Id(autoincrement = true)
    private Long id;
    private String name;
    @Generated(hash = 1678431821)
    public SreachHistoryDaoBean(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 434582178)
    public SreachHistoryDaoBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
