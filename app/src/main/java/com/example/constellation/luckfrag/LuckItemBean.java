package com.example.constellation.luckfrag;

public class LuckItemBean {
    //将事业，爱情，健康等内容再综合一下，把list需要的数据源整理一下
    private String title;
    private String content;
    private int colorId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public LuckItemBean(String title, String content, int colorId) {
        this.title = title;
        this.content = content;
        this.colorId = colorId;
    }
}
