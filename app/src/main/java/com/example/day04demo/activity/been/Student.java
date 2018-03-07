package com.example.day04demo.activity.been;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 王宇辉 on 2018/3/6.
 */
@Entity
public class Student {

    @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb = "img")
    private String img;
    @Property(nameInDb = "name")
    private String name;
    @Property(nameInDb = "content")
    private String content;

    @Generated(hash = 1829709435)
    public Student(Long id, String img, String name, String content) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.content = content;
    }

    @Generated(hash = 1556870573)
    public Student() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImg() {
        return this.img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
