package com.javase.day0803;

public class News implements Comparable<News>{
    private Integer id;

    private String title;

    public News(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public News() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public int compareTo(News o) {
        return this.getId() - o.getId();
    }

//    @Override
//    public int compareTo(News o) {
//        return this.getId() - o.getId();
//    }
}
