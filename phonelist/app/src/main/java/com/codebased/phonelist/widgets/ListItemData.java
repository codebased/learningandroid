package com.codebased.phonelist.widgets;

import android.graphics.Bitmap;

public class ListItemData {

    private String Id;
    private String rightText;
    private String text;
    private Bitmap thumbnail;
    private String subtext;
    private String photoUri;

    public String getRightText() {
        return rightText;
    }

    public ListItemData() {

    }

    public ListItemData(ListItemData data) {
        this.rightText = data.rightText;
        this.subtext = data.subtext;
        this.text = data.text;
        this.photoUri = data.photoUri;
        this.Id = data.Id;
        this.thumbnail = data.thumbnail;
    }

    public void setRightText(String rightText) {
        this.rightText = rightText;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Bitmap getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Bitmap thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getSubtext() {
        return subtext;
    }

    public void setSubtext(String subtext) {
        this.subtext = subtext;
    }

    public void setPhotoUri(String photoUri) {
        this.photoUri = photoUri;
    }

    public String getPhotoUri() {
        return this.photoUri;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    @Override
    public String toString() {
        return this.getText();
    }
}