package com.example.college_information_system.modal;

public class ForumModal {

    private String forumID;
    private String _id;
    private String forumTitle;
    private String forumDces;
    private String postedby;
    private String forum_post_date;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getForumTitle() {
        return forumTitle;
    }

    public void setForumTitle(String forumTitle) {
        this.forumTitle = forumTitle;
    }

    public String getForumDces() {
        return forumDces;
    }

    public void setForumDces(String forumDces) {
        this.forumDces = forumDces;
    }

    public String getPostedby() {
        return postedby;
    }

    public void setPostedby(String postedby) {
        this.postedby = postedby;
    }

    public String getForum_post_date() {
        return forum_post_date;
    }

    public void setForum_post_date(String forum_post_date) {
        this.forum_post_date = forum_post_date;
    }

    public String getForumID() {
        return forumID;
    }

    public void setForumID(String forumID) {
        this.forumID = forumID;
    }

    public ForumModal(String forumID, String _id, String forumTitle, String forumDces, String postedby, String forum_post_date) {
        this.forumID = forumID;
        this._id = _id;
        this.forumTitle = forumTitle;
        this.forumDces = forumDces;
        this.postedby = postedby;
        this.forum_post_date = forum_post_date;
    }

}
