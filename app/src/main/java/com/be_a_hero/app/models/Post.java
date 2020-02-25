package com.be_a_hero.app.models;

import java.io.Serializable;

public class Post implements Serializable {
    private int id;
    private String profileName;
    private int profileImage;
    private String timeAgo;
    private String location;
    private String postContent;
    private int postImage;
    private boolean isLiked;

    public Post() {
    }

    public Post(int id, String profileName, int profileImage, String timeAgo, String location, String postContent, int postImage, boolean isLiked) {
        this.id = id;
        this.profileName = profileName;
        this.profileImage = profileImage;
        this.timeAgo = timeAgo;
        this.location = location;
        this.postContent = postContent;
        this.postImage = postImage;
        this.isLiked = isLiked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public int getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(int profileImage) {
        this.profileImage = profileImage;
    }

    public String getTimeAgo() {
        return timeAgo;
    }

    public void setTimeAgo(String timeAgo) {
        this.timeAgo = timeAgo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public int getPostImage() {
        return postImage;
    }

    public void setPostImage(int postImage) {
        this.postImage = postImage;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }
}
