package com.example.college_information_system.modal;

public class BlogModal {

    private String blogTitle;
    private String blogDes;
    private String blogImage;
    private String postedby;

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogDes() {
        return blogDes;
    }

    public void setBlogDes(String blogDes) {
        this.blogDes = blogDes;
    }

    public String getBlogImage() {
        return blogImage;
    }

    public void setBlogImage(String blogImage) {
        this.blogImage = blogImage;
    }

    public String getPostedby() {
        return postedby;
    }

    public void setPostedby(String postedby) {
        this.postedby = postedby;
    }

    // constructor
    public BlogModal(String blogTitle, String blogDes, String blogImage, String postedby) {
        this.blogTitle = blogTitle;
        this.blogDes = blogDes;
        this.blogImage = blogImage;
        this.postedby = postedby;
    }

}
