package com.apiwithrx.model;

import com.google.gson.annotations.SerializedName;

public class PostModel
{
    @SerializedName("userId")
    private int userID;
    @SerializedName("id")
    private int ID;
    @SerializedName("title")
    private String title;
    @SerializedName("body")
    private String body;

    public PostModel(int userID, int ID, String title, String body)
    {
        this.userID = userID;
        this.ID = ID;
        this.title = title;
        this.body = body;
    }

    public int getUserID() {
        return userID;
    }

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
