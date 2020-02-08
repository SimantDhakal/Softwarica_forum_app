package com.example.college_information_system.modal;

public class CommentModal {

    private String forumID;
    private String email;
    private String comment;

    public String getForumID() {
        return forumID;
    }

    public void setForumID(String forumID) {
        this.forumID = forumID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }



    public CommentModal(String forumID, String email, String comment) {
        this.forumID = forumID;
        this.email = email;
        this.comment = comment;
    }

}
