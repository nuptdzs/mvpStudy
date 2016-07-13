package com.example.dzs.testapp.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dzs on 2016/7/11.
 */
public class Story implements Serializable{
    private long id;
    private int type;
    private List<String> images;
    private String ga_prefix;
    private String image;

    @Override
    public String toString() {
        return "Story{" +
                "id=" + id +
                ", type=" + type +
                ", images=" + images +
                ", ga_prefix='" + ga_prefix + '\'' +
                ", image='" + image + '\'' +
                ", share_url='" + share_url + '\'' +
                ", css=" + css +
                ", body='" + body + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public List<String> getCss() {
        return css;
    }

    public void setCss(List<String> css) {
        this.css = css;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    private String share_url;
    private List<String> css;
    private String body;
    private String title;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
