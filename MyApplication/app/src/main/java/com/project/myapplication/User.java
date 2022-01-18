package com.project.myapplication;

/**
 * @author admin
 * @description:
 * @date :2022/1/18 19:58
 */
public class User {
    private String name;
    private String content;
    private int image;
    private String fensi;

    public String getFensi() {
        return fensi;
    }

    public void setFensi(String fensi) {
        this.fensi = fensi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
